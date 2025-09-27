package Vanilla.gpt4o;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {

    public static Object performJndiLookup(String jndiName) {
        try {
            InitialContext context = new InitialContext();
            return context.lookup(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] jndiNames = {
            "java:comp/env/jdbc/myDataSource",
            "java:comp/env/jms/myQueue",
            "java:comp/env/ejb/myBean",
            "java:comp/env/mail/myMailSession",
            "java:comp/env/url/myURL"
        };

        for (String jndiName : jndiNames) {
            System.out.println("Lookup result for " + jndiName + ": " + performJndiLookup(jndiName));
        }
    }
}