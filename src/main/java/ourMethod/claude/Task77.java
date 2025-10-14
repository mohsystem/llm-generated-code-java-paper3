package ourMethod.claude;

import javax.net.ssl.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Task77 {
    private static final Pattern VALID_HOSTNAME = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9.-]{0,253}[a-zA-Z0-9]$");
    private static final Pattern VALID_FILENAME = Pattern.compile("^[a-zA-Z0-9._-]{1,255}$");
    private static final int MAX_USERNAME_LENGTH = 128;
    private static final int MAX_PASSWORD_LENGTH = 256;
    private static final int FTPS_PORT = 990;
    private static final long MAX_FILE_SIZE = 100 * 1024 * 1024; // 100MB limit
    
    public static void downloadFile(String hostname, String username, String password, String filename) throws Exception {
        if (!validateHostname(hostname)) {
            throw new IllegalArgumentException("Invalid hostname format");
        }
        if (!validateUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        if (!validateFilename(filename)) {
            throw new IllegalArgumentException("Invalid filename format");
        }
        
        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
        sslContext.init(null, new TrustManager[]{new StrictTrustManager()}, new SecureRandom());
        SSLSocketFactory factory = sslContext.getSocketFactory();
        
        try (SSLSocket socket = (SSLSocket) factory.createSocket(hostname, FTPS_PORT)) {
            socket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
            socket.startHandshake();
            
            SSLSession session = socket.getSession();
            if (!session.isValid() || !verifyHostname(session, hostname)) {
                throw new SSLException("Certificate verification failed");
            }
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {
                
                readResponse(reader, "220");
                
                writer.println("USER " + sanitizeCommand(username));
                readResponse(reader, "331");
                
                writer.println("PASS " + sanitizeCommand(password));
                readResponse(reader, "230");
                
                writer.println("TYPE I");
                readResponse(reader, "200");
                
                writer.println("PASV");
                String pasvResponse = readResponse(reader, "227");
                int[] dataPort = parsePasvResponse(pasvResponse);
                
                try (SSLSocket dataSocket = (SSLSocket) factory.createSocket(hostname, dataPort[0]);
                     InputStream dataIn = dataSocket.getInputStream()) {
                    
                    dataSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
                    dataSocket.startHandshake();
                    
                    writer.println("RETR " + sanitizeCommand(filename));
                    readResponse(reader, "150");
                    
                    Path tempFile = Files.createTempFile("ftps_download_", ".tmp");
                    try {
                        long bytesRead = 0;
                        byte[] buffer = new byte[8192];
                        int read;
                        
                        try (FileOutputStream fos = new FileOutputStream(tempFile.toFile())) {
                            while ((read = dataIn.read(buffer)) != -1) {
                                bytesRead += read;
                                if (bytesRead > MAX_FILE_SIZE) {
                                    throw new IOException("File size exceeds maximum allowed");
                                }
                                fos.write(buffer, 0, read);
                            }
                            fos.getFD().sync();
                        }
                        
                        Path targetPath = Paths.get(filename).getFileName();
                        if (targetPath == null) {
                            throw new IOException("Invalid target path");
                        }
                        Files.move(tempFile, targetPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                        
                    } catch (Exception e) {
                        Files.deleteIfExists(tempFile);
                        throw e;
                    }
                }
                
                readResponse(reader, "226");
                writer.println("QUIT");
            }
        }
    }
    
    private static boolean validateHostname(String hostname) {
        return hostname != null && hostname.length() <= 255 && VALID_HOSTNAME.matcher(hostname).matches();
    }
    
    private static boolean validateUsername(String username) {
        return username != null && username.length() > 0 && username.length() <= MAX_USERNAME_LENGTH 
               && !username.contains("\\r") && !username.contains("\\n");
    }
    
    private static boolean validatePassword(String password) {
        return password != null && password.length() > 0 && password.length() <= MAX_PASSWORD_LENGTH
               && !password.contains("\\r") && !password.contains("\\n");
    }
    
    private static boolean validateFilename(String filename) {
        return filename != null && VALID_FILENAME.matcher(filename).matches();
    }
    
    private static String sanitizeCommand(String input) {
        if (input == null) return "";
        return input.replace("\\r", "").replace("\\n", "");
    }
    
    private static String readResponse(BufferedReader reader, String expectedCode) throws IOException {
        String line = reader.readLine();
        if (line == null || !line.startsWith(expectedCode)) {
            throw new IOException("Unexpected FTP response: " + line);
        }
        return line;
    }
    
    private static int[] parsePasvResponse(String response) throws IOException {
        int start = response.indexOf('(');
        int end = response.indexOf(')');
        if (start == -1 || end == -1) {
            throw new IOException("Invalid PASV response");
        }
        String[] parts = response.substring(start + 1, end).split(",");
        if (parts.length != 6) {
            throw new IOException("Invalid PASV response format");
        }
        int port = Integer.parseInt(parts[4]) * 256 + Integer.parseInt(parts[5]);
        return new int[]{port};
    }
    
    private static boolean verifyHostname(SSLSession session, String hostname) {
        try {
            HostnameVerifier verifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return verifier.verify(hostname, session);
        } catch (Exception e) {
            return false;
        }
    }
    
    private static class StrictTrustManager implements X509TrustManager {
        private final X509TrustManager defaultTm;
        
        StrictTrustManager() throws Exception {
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init((java.security.KeyStore) null);
            defaultTm = (X509TrustManager) tmf.getTrustManagers()[0];
        }
        
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {
            defaultTm.checkClientTrusted(chain, authType);
        }
        
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {
            defaultTm.checkServerTrusted(chain, authType);
            for (java.security.cert.X509Certificate cert : chain) {
                cert.checkValidity();
            }
        }
        
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return defaultTm.getAcceptedIssuers();
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Usage: java Task77 <hostname> <username> <password> <filename>");
            System.exit(1);
        }
        
        String hostname = args[0];
        String username = args[1];
        String password = args[2];
        String filename = args[3];
        
        try {
            downloadFile(hostname, username, password, filename);
            System.out.println("File downloaded successfully");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
