package Vanilla.llama31;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {
    public static void main(String[] args) {
        // Test cases
        String[] jndiNames = {
            "java:comp/env/mailPincode",
            "java:comp/env/jdbc/Oracle",
            "java:comp/env/ejb/myEJB",
            "java:comp/UserTransaction",
            "java:comp/env/mail"
        };

        for (String jndiName : jndiNames) {
            try {
                Context initContext = new InitialContext();
                Object resource = initContext.lookup(jndiName);
                System.out.println("JNDI Name: " + jndiName + ", Resource: " + resource);
            } catch (NamingException e) {
                System.out.println("Error looking up JNDI name: " + jndiName + ", Exception: " + e.getMessage());
            }
        }
    }

    public static Object performJndiLookup(String jndiName) throws NamingException {
        Context initContext = new InitialContext();
        return initContext.lookup(jndiName);
    }
}