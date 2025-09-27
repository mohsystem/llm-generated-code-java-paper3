package CoT.gemini;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Task107 {

    public static Object jndiLookup(String jndiName) throws NamingException {
        // Secure JNDI Lookup
        Hashtable<String, Object> env = new Hashtable<>();

        // Explicitly set the Context.PROVIDER_URL to prevent malicious injection
        env.put(Context.PROVIDER_URL, "valid_provider_url"); // Replace with your provider URL

        // Restrict allowed protocols and classes to mitigate JNDI injection attacks
        env.put(Context.INITIAL_CONTEXT_FACTORY, "allowed_context_factory"); // Replace with allowed factory
        env.put("com.sun.jndi.ldap.object.trustURLCodebase", "false");
        env.put("com.sun.jndi.cosnaming.object.trustURLCodebase", "false");
        env.put("com.sun.jndi.rmi.object.trustURLCodebase", "false");

        Context ctx = new InitialContext(env);
        return ctx.lookup(jndiName);
    }


    public static void main(String[] args) {
        try {
            System.out.println(jndiLookup("java:comp/env/jdbc/myDataSource"));
            System.out.println(jndiLookup("java:comp/env/mail/Session"));
            System.out.println(jndiLookup("java:comp/env/ejb/MyEJB"));
            System.out.println(jndiLookup("java:comp/env/config/MyConfig"));
            System.out.println(jndiLookup("java:comp/env/queue/MyQueue"));

        } catch (NamingException e) {
            System.err.println("Error during JNDI lookup: " + e.getMessage());
        }
    }
}