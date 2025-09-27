package CoT.claude;

import javax.naming.*;
import java.util.Properties;

public class Task107 {
    public static Object performJNDILookup(String jndiName, String providerURL) {
        Object result = null;
        InitialContext context = null;
        try {
            // Set up environment properties securely
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL, providerURL);
            env.put(Context.SECURITY_PRINCIPAL, "validUser"); // Use secure credentials
            env.put(Context.SECURITY_CREDENTIALS, "validPassword"); // Use secure credentials
            
            // Create initial context with security settings
            context = new InitialContext(env);
            
            // Validate JNDI name before lookup
            if (!isValidJNDIName(jndiName)) {
                throw new NamingException("Invalid JNDI name");
            }
            
            // Perform lookup with validated name
            result = context.lookup(jndiName);
            
        } catch (NamingException e) {
            System.err.println("JNDI Lookup failed: " + e.getMessage());
        } finally {
            try {
                if (context != null) {
                    context.close();
                }
            } catch (NamingException e) {
                System.err.println("Error closing context: " + e.getMessage());
            }
        }
        return result;
    }
    
    private static boolean isValidJNDIName(String jndiName) {
        // Implement validation logic for JNDI names
        if (jndiName == null || jndiName.trim().isEmpty()) {
            return false;
        }
        // Check for potentially malicious characters
        String invalidChars = ";,=+<>\\"\\\\";\n        for (char c : invalidChars.toCharArray()) {\n            if (jndiName.indexOf(c) != -1) {\n                return false;\n            }\n        }\n        return true;\n    }\n\n    public static void main(String[] args) {\n        // Test cases\n        String[] jndiNames = {\n            "java:comp/env/jdbc/TestDB",\n            "ldap://localhost:389/dc=example,dc=com",\n            "rmi://localhost:1099/TestService",\n            "invalid;name",\n            ""\n        };\n        \n        String providerURL = "rmi://localhost:1099";\n        \n        for (String jndiName : jndiNames) {\n            System.out.println("Testing JNDI lookup for: " + jndiName);\n            Object result = performJNDILookup(jndiName, providerURL);\n            System.out.println("Result: " + (result != null ? result : "Lookup failed"));
            System.out.println();
        }
    }
}
