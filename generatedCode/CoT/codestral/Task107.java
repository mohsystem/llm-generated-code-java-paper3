package CoT.codestral;
import javax.naming.*;

public class Task107 {
    public static Object lookup(String jndiName) throws NamingException {
        Context ctx = new InitialContext();
        return ctx.lookup(jndiName);
    }

    public static void main(String[] args) {
        try {
            System.out.println(lookup("java:comp/env/jdbc/myDatasource"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}