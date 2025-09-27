package ZeroShot.claude;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.regex.Pattern;

public class Task107 {
    private static final Pattern SAFE_JNDI_PATTERN = Pattern.compile("^[a-zA-Z0-9/._-]+$");
    
    public static Object lookupJNDIResource(String jndiName) throws NamingException {
        // Input validation
        if (jndiName == null || jndiName.trim().isEmpty()) {
            throw new IllegalArgumentException("JNDI name cannot be null or empty");
        }
        
        // Validate JNDI name against safe pattern
        if (!SAFE_JNDI_PATTERN.matcher(jndiName).matches()) {
            throw new IllegalArgumentException("Invalid JNDI name format");
        }
        
        // Restrict to local JNDI context only
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
            "com.sun.jndi.fscontext.RefFSContextFactory");
        
        Context context = null;
        try {
            context = new InitialContext();
            return context.lookup(jndiName);
        } finally {
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException e) {
                    // Log error but don't expose details
                    System.err.println("Error closing JNDI context");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Test case 1: Valid JNDI lookup
            lookupJNDIResource("java:comp/env/jdbc/myDB");
            
            // Test case 2: Invalid JNDI name
            lookupJNDIResource("ldap://malicious-server/exploit");
            
            // Test case 3: Empty JNDI name
            lookupJNDIResource("");
            
            // Test case 4: Null JNDI name
            lookupJNDIResource(null);
            
            // Test case 5: Special characters in JNDI name
            lookupJNDIResource("java:comp/env/<script>");
            
        } catch (Exception e) {
            System.err.println("Error during JNDI lookup: " + e.getClass().getSimpleName());
        }
    }
}
