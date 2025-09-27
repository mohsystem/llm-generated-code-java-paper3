package Vanilla.codestral;
import javax.naming.*;

public class Task107 {
    public static Object jndiLookup(String jndiName) throws NamingException {
        Context ctx = new InitialContext();
        return ctx.lookup(jndiName);
    }

    public static void main(String[] args) {
        try {
            System.out.println(jndiLookup("java:comp/env/jdbc/MyDB"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}