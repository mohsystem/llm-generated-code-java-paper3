package ourMethod.claude;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.zip.*;

public class Task117 {
    private static final int MAX_FILE_SIZE = 100 * 1024 * 1024; // 100MB
    private static final int MAX_TOTAL_SIZE = 500 * 1024 * 1024; // 500MB
    private static final int MAX_FILES = 10000;
    private static final int BUFFER_SIZE = 8192;

    public static boolean extractArchive(String archivePath, String destDir) {
        if (archivePath == null || destDir == null || archivePath.isEmpty() || destDir.isEmpty()) {
            return false;
        }

        Path archivePathObj = Paths.get(archivePath);
        Path destPathObj = Paths.get(destDir);

        if (!Files.exists(archivePathObj) || !Files.isRegularFile(archivePathObj)) {
            return false;
        }

        try {
            Files.createDirectories(destPathObj);
        } catch (IOException e) {
            return false;
        }

        Path normalizedDest = destPathObj.toAbsolutePath().normalize();

        if (archivePath.toLowerCase().endsWith(".zip")) {
            return extractZip(archivePathObj, normalizedDest);
        } else if (archivePath.toLowerCase().endsWith(".tar")) {
            return extractTar(archivePathObj, normalizedDest);
        }

        return false;
    }

    private static boolean extractZip(Path archivePath, Path destDir) {
        long totalExtracted = 0;
        int fileCount = 0;

        try (ZipInputStream zis =
                     new ZipInputStream(new BufferedInputStream(Files.newInputStream(archivePath)), StandardCharsets.UTF_8)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (fileCount >= MAX_FILES) {
                    return false;
                }

                String name = entry.getName();
                if (name == null || name.isEmpty() || name.contains("..")
                        || name.startsWith("/") || name.startsWith("\\")) {
                    zis.closeEntry();
                    continue;
                }

                Path targetPath = destDir.resolve(name).normalize();
                if (!targetPath.startsWith(destDir)) {
                    zis.closeEntry();
                    continue;
                }

                if (entry.isDirectory()) {
                    Files.createDirectories(targetPath);
                    zis.closeEntry();
                    continue;
                }

                if (entry.getSize() > MAX_FILE_SIZE) {
                    zis.closeEntry();
                    continue;
                }

                Files.createDirectories(targetPath.getParent());

                Path tempFile = Files.createTempFile(destDir, ".tmp", ".extract");
                long bytesWritten = 0;

                try (OutputStream fos = new BufferedOutputStream(Files.newOutputStream(tempFile))) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        bytesWritten += len;
                        totalExtracted += len;

                        if (bytesWritten > MAX_FILE_SIZE || totalExtracted > MAX_TOTAL_SIZE) {
                            Files.delete(tempFile);
                            return false;
                        }

                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                }

                Files.move(
                        tempFile,
                        targetPath,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE
                );
                fileCount++;
                zis.closeEntry();
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private static boolean extractTar(Path archivePath, Path destDir) {
        long totalExtracted = 0;
        int fileCount = 0;

        try (InputStream fis = new BufferedInputStream(Files.newInputStream(archivePath))) {
            byte[] header = new byte[512];

            while (true) {
                int bytesRead = readFully(fis, header);
                if (bytesRead < 512 || isEmptyBlock(header)) {
                    break;
                }

                if (fileCount >= MAX_FILES) {
                    return false;
                }

                String name = extractTarString(header, 0, 100);
                long size = extractTarSize(header, 124, 12);
                char typeFlag = (char) header[156];

                if (name == null || name.isEmpty() || name.contains("..")
                        || name.startsWith("/") || size < 0 || size > MAX_FILE_SIZE) {
                    skipTarContent(fis, size);
                    continue;
                }

                Path targetPath = destDir.resolve(name).normalize();
                if (!targetPath.startsWith(destDir)) {
                    skipTarContent(fis, size);
                    continue;
                }

                if (typeFlag == '5' || name.endsWith("/")) {
                    Files.createDirectories(targetPath);
                    skipTarContent(fis, size);
                    continue;
                }

                if (typeFlag != '0' && typeFlag != '\0') {
                    skipTarContent(fis, size);
                    continue;
                }

                Files.createDirectories(targetPath.getParent());

                Path tempFile = Files.createTempFile(destDir, ".tmp", ".extract");
                long bytesWritten = 0;

                try (OutputStream fos = new BufferedOutputStream(Files.newOutputStream(tempFile))) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    long remaining = size;

                    while (remaining > 0) {
                        int toRead = (int) Math.min(buffer.length, remaining);
                        int len = fis.read(buffer, 0, toRead);
                        if (len <= 0) {
                            Files.delete(tempFile);
                            return false;
                        }

                        bytesWritten += len;
                        totalExtracted += len;

                        if (totalExtracted > MAX_TOTAL_SIZE) {
                            Files.delete(tempFile);
                            return false;
                        }

                        fos.write(buffer, 0, len);
                        remaining -= len;
                    }
                    fos.flush();
                }

                long padding = (512 - (size % 512)) % 512;
                skipBytes(fis, padding);

                Files.move(
                        tempFile,
                        targetPath,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE
                );
                fileCount++;
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private static String extractTarString(byte[] header, int offset, int length) {
        int end = offset;
        while (end < offset + length && header[end] != 0) {
            end++;
        }
        return new String(header, offset, end - offset, StandardCharsets.UTF_8);
    }

    private static long extractTarSize(byte[] header, int offset, int length) {
        try {
            String sizeStr = extractTarString(header, offset, length).trim();
            if (sizeStr.isEmpty()) {
                return 0;
            }
            return Long.parseLong(sizeStr, 8);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean isEmptyBlock(byte[] block) {
        for (byte b : block) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }

    private static int readFully(InputStream is, byte[] buffer) throws IOException {
        int total = 0;
        while (total < buffer.length) {
            int read = is.read(buffer, total, buffer.length - total);
            if (read < 0) {
                return total;
            }
            total += read;
        }
        return total;
    }

    private static void skipTarContent(InputStream is, long size) throws IOException {
        long padding = (512 - (size % 512)) % 512;
        skipBytes(is, size + padding);
    }

    private static void skipBytes(InputStream is, long bytes) throws IOException {
        long remaining = bytes;
        byte[] buffer = new byte[BUFFER_SIZE];
        while (remaining > 0) {
            long skipped = is.skip(remaining);
            if (skipped > 0) {
                remaining -= skipped;
            } else {
                int toRead = (int) Math.min(buffer.length, remaining);
                int read = is.read(buffer, 0, toRead);
                if (read <= 0) {
                    break;
                }
                remaining -= read;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1 - Extract valid ZIP:");
        System.out.println(extractArchive("test.zip", "output1"));

        System.out.println("Test 2 - Extract valid TAR:");
        System.out.println(extractArchive("test.tar", "output2"));

        System.out.println("Test 3 - Invalid archive path:");
        System.out.println(extractArchive("nonexistent.zip", "output3"));

        System.out.println("Test 4 - Null parameters:");
        System.out.println(extractArchive(null, "output4"));

        System.out.println("Test 5 - Empty destination:");
        System.out.println(extractArchive("test.zip", ""));
    }
}
