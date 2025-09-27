package Vanilla.gemini;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {

    public static Object jndiLookup(String jndiName) throws NamingException {
        Context ctx = new InitialContext();
        return ctx.lookup(jndiName);
    }

    public static void main(String[] args) {
        try {
            System.out.println(jndiLookup("java:comp/env/jdbc/myDataSource"));
            System.out.println(jndiLookup("java:comp/env/mail/Session"));
            System.out.println(jndiLookup("java:comp/env/url/MyURL"));
            System.out.println(jndiLookup("java:comp/env/ejb/MyEJB"));
            System.out.println(jndiLookup("java:comp/UserTransaction"));

        } catch (NamingException e) {
            System.err.println("NamingException: " + e.getMessage());
        }
    }
}