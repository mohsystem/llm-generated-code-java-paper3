package CoT.llama31;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Task107 {
    public static void main(String[] args) {
        // Test cases
        String[] names = {"java:comp/env/jdbc/datasource", "java:comp/env/myObject", "java:comp/env/anotherResource"};

        for (String name : names) {
            try {
                Context ctx = new InitialContext();
                Object obj = ctx.lookup(name);
                System.out.println("Lookup result for " + name + ": " + obj);
            } catch (NamingException e) {
                System.out.println("Error looking up " + name + ": " + e.getMessage());
            }
        }
    }
}