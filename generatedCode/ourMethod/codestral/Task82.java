package ourMethod.codestral;
import org.mindrot.jbcrypt.BCrypt;

public class Task82 {
    public static String hashPassword(String password, String salt) {
        return BCrypt.hashpw(password + salt, BCrypt.gensalt());
    }

    public static void main(String[] args) {
        String password = "myPassword";
        String salt = "mySalt";
        System.out.println(hashPassword(password, salt));
    }
}