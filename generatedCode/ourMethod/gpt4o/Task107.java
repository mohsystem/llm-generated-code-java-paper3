package ourMethod.openai;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {

    public Object performJNDILookup(String jndiName) {
        Object result = null;
        try {
            Context ctx = new InitialContext();
            result = ctx.lookup(jndiName);
        } catch (NamingException e) {
            System.err.println("JNDI Lookup failed: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        Task107 task = new Task107();
        // Test cases
        Object result1 = task.performJNDILookup("java:comp/env/jdbc/DataSource1");
        Object result2 = task.performJNDILookup("java:comp/env/jdbc/DataSource2");
        Object result3 = task.performJNDILookup("java:comp/env/jdbc/Invalid");
        Object result4 = task.performJNDILookup("java:comp/env/jdbc/DataSource3");
        Object result5 = task.performJNDILookup("java:comp/env/jdbc/DataSource4");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}