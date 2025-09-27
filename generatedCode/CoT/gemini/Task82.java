package CoT.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Task82 {

    public static byte[] getSaltedHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        md.update(password.getBytes());
        return md.digest();
    }

    public static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password1 = "test1";
        byte[] salt1 = generateSalt();
        byte[] saltedHash1 = getSaltedHash(password1, salt1);
        System.out.println("Password: " + password1 + ", Salt: " + Arrays.toString(salt1) + ", Hash: " + Arrays.toString(saltedHash1));


        String password2 = "password123";
        byte[] salt2 = generateSalt();
        byte[] saltedHash2 = getSaltedHash(password2, salt2);
        System.out.println("Password: " + password2 + ", Salt: " + Arrays.toString(salt2) + ", Hash: " + Arrays.toString(saltedHash2));

        String password3 = "MyStrongPassword";
        byte[] salt3 = generateSalt();
        byte[] saltedHash3 = getSaltedHash(password3, salt3);
        System.out.println("Password: " + password3 + ", Salt: " + Arrays.toString(salt3) + ", Hash: " + Arrays.toString(saltedHash3));

        String password4 = "123456";
        byte[] salt4 = generateSalt();
        byte[] saltedHash4 = getSaltedHash(password4, salt4);
        System.out.println("Password: " + password4 + ", Salt: " + Arrays.toString(salt4) + ", Hash: " + Arrays.toString(saltedHash4));

        String password5 = "AnotherTest";
        byte[] salt5 = generateSalt();
        byte[] saltedHash5 = getSaltedHash(password5, salt5);
        System.out.println("Password: " + password5 + ", Salt: " + Arrays.toString(salt5) + ", Hash: " + Arrays.toString(saltedHash5));


    }
}