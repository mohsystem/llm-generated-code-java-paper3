package ZeroShot.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Task81 {

    public static boolean verifySSLCertificate(byte[] certificate, byte[] knownHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] certHash = md.digest(certificate);
        return Arrays.equals(certHash, knownHash);
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        byte[] cert1 = {0x30, 0x82, 0x01, 0x0a};  // Example certificate
//        byte[] knownHash1 = {0x5e, 0x8d, 0x0b, 0x6a};  // Example hash
//
//        byte[] cert2 = {0x30, 0x82, 0x01, 0x0b};
//        byte[] knownHash2 = {0x5e, 0x8d, 0x0b, 0x6a};
//
//        byte[] cert3 = {0x30, 0x82, 0x01, 0x0c};
//        byte[] knownHash3 = {0x3e, 0x8d, 0x0b, 0x7b};
//
//        byte[] cert4 = {0x30, 0x82, 0x01, 0x0d};
//        byte[] knownHash4 = {0x5e, 0x8d, 0x0b, 0x6a};
//
//        byte[] cert5 = {0x30, 0x82, 0x01, 0x0e};
//        byte[] knownHash5 = {0x5e, 0x8d, 0x0b, 0x6a};
//
//        System.out.println(verifySSLCertificate(cert1, knownHash1));
//        System.out.println(verifySSLCertificate(cert2, knownHash2));
//        System.out.println(verifySSLCertificate(cert3, knownHash3));
//        System.out.println(verifySSLCertificate(cert4, knownHash4));
//        System.out.println(verifySSLCertificate(cert5, knownHash5));
//    }
}