package ZeroShot.gemini;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Task107 {

    public static Object jndiLookup(String jndiName) throws NamingException {
        // Secure JNDI Lookup: Restrict allowed protocols and classes
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // Example: LDAP
        // Add other necessary properties like security credentials, etc.

        // Security measures: Whitelist allowed protocols
        env.put(Context.PROVIDER_URL, "ldap://allowed.ldap.server:389"); // Example URL
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new javax.naming.ldap.InitialLdapContext().getConnectPermission());
        }
        Context ctx = new InitialContext(env);


        return ctx.lookup(jndiName);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            System.out.println(jndiLookup("ldap://allowed.ldap.server:389/validObject")); // Replace with valid JNDI names
            System.out.println(jndiLookup("ldap://allowed.ldap.server:389/anotherValidObject"));
            // Add more test cases here
        } catch (NamingException e) {
            System.err.println("JNDI lookup failed: " + e.getMessage());
        }
    }
}