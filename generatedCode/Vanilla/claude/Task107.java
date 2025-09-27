package Vanilla.claude;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Task107 {
    public static Object performJNDILookup(String jndiName) {
        try {
            // Create properties for JNDI initialization
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
                "com.sun.jndi.fscontext.RefFSContextFactory");
            props.setProperty(Context.PROVIDER_URL, "file:///tmp");

            // Create the initial context
            Context context = new InitialContext(props);
            
            // Perform the JNDI lookup
            Object result = context.lookup(jndiName);
            
            context.close();
            return result;
        } catch (NamingException e) {
            System.err.println("JNDI Lookup failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        // Note: These are example lookups. In a real environment,
        // you would need proper JNDI resources configured

        // Test case 1: Looking up a datasource
        Object result1 = performJNDILookup("jdbc/MyDataSource");
        System.out.println("Test 1 result: " + (result1 != null ? "Found" : "Not found"));

        // Test case 2: Looking up an EJB
        Object result2 = performJNDILookup("ejb/MyBean");
        System.out.println("Test 2 result: " + (result2 != null ? "Found" : "Not found"));

        // Test case 3: Looking up a JMS queue
        Object result3 = performJNDILookup("jms/MyQueue");
        System.out.println("Test 3 result: " + (result3 != null ? "Found" : "Not found"));

        // Test case 4: Looking up an environment variable
        Object result4 = performJNDILookup("env/MyVariable");
        System.out.println("Test 4 result: " + (result4 != null ? "Found" : "Not found"));

        // Test case 5: Looking up with invalid name
        Object result5 = performJNDILookup("invalid/Resource");
        System.out.println("Test 5 result: " + (result5 != null ? "Found" : "Not found"));
    }
}
