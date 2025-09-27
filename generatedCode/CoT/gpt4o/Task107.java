package CoT.gpt4o;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {
    public static Object performJndiLookup(String jndiName) {
        Object result = null;
        try {
            Context context = new InitialContext();
            result = context.lookup(jndiName);
        } catch (NamingException e) {
            System.out.println("JNDI Lookup failed: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(performJndiLookup("java:comp/env/jdbc/MyDataSource"));
        System.out.println(performJndiLookup("java:comp/env/jms/MyQueue"));
        System.out.println(performJndiLookup("java:comp/env/jms/MyTopic"));
        System.out.println(performJndiLookup("java:comp/env/ejb/MyBean"));
        System.out.println(performJndiLookup("java:comp/env/mail/MyMailSession"));
    }
}