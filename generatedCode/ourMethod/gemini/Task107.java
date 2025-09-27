package ourMethod.gemini;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Task107 {

    public static Object jndiLookup(String resourceName) throws NamingException {
        // Set up JNDI environment properties
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // Example LDAP factory
        env.put(Context.PROVIDER_URL, "ldap://localhost:389"); // Example LDAP URL

        // Create initial context
        Context ctx = new InitialContext(env);

        // Perform lookup
        return ctx.lookup(resourceName);
    }


    public static void main(String[] args) {
        String[] testCases = {
                "ldap://localhost:389/dc=example,dc=com",
                "java:comp/env/jdbc/myDataSource",
                "ejb/MyEJB",
                "mail/Session",
                "jms/QueueConnectionFactory"

        };
        for (String testCase : testCases) {
            try {
                Object resource = jndiLookup(testCase);
                System.out.println("Resource found for " + testCase + ": " + resource);
            } catch (NamingException e) {
                System.err.println("Error during JNDI lookup for " + testCase + ": " + e.getMessage());
            }
        }

    }
}