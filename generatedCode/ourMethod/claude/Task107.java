package ourMethod.claude;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Task107 {
    private static final String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.rmi.registry.RegistryContextFactory";
    private static final String PROVIDER_URL = "rmi://localhost:1099";
    
    public static Object lookupResource(String jndiName) throws NamingException {
        if (jndiName == null || jndiName.trim().isEmpty()) {
            throw new IllegalArgumentException("JNDI name cannot be null or empty");
        }
        
        // Validate JNDI name format
        if (!isValidJndiName(jndiName)) {
            throw new IllegalArgumentException("Invalid JNDI name format");
        }
        
        Context context = null;
        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, PROVIDER_URL);
            
            // Disable LDAP deserialization
            env.put("com.sun.jndi.ldap.object.trustURLCodebase", "false");
            
            context = new InitialContext(env);
            return context.lookup(jndiName);
        } finally {
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException e) {
                    // Log error but don't expose details
                    System.err.println("Error closing context");
                }
            }
        }
    }
    
    private static boolean isValidJndiName(String jndiName) {
        // Basic JNDI name validation
        return jndiName.matches("^[a-zA-Z][a-zA-Z0-9_/.-]*$");
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "java:comp/env/jdbc/TestDB",
            "java:comp/env/ejb/TestEJB",
            "java:comp/env/resource/TestResource",
            "rmi://localhost/TestService",
            "ldap://localhost/dc=example,dc=com"
        };
        
        for (String testCase : testCases) {
            try {
                System.out.println("Looking up: " + testCase);
                Object result = lookupResource(testCase);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error looking up " + testCase + ": " + e.getMessage());
            }
        }
    }
}
