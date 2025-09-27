package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task89 {
    public static boolean comparePassword(String userPassword) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("password.txt"));
        String storedPassword = reader.readLine();
        reader.close();

        if(userPassword.length() != storedPassword.length()) {
            return false;
        }

        for(int i = 0; i < userPassword.length(); i++) {
            if(userPassword.charAt(i) != storedPassword.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(comparePassword("password1"));
        System.out.println(comparePassword("wrongpassword"));
        System.out.println(comparePassword("passwor"));
        System.out.println(comparePassword("password123"));
        System.out.println(comparePassword("password1"));
    }
}