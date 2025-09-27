package ZeroShot.llama31;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {
    public static void main(String[] args) {
        String[] testCases = {"jdbc/myDB", "jms/myQueue", "ldap://localhost:389/ou=people,dc=example,dc=com"};
        for (String testCase : testCases) {
            try {
                Context ctx = new InitialContext();
                Object obj = ctx.lookup(testCase);
                System.out.println("Lookup result for " + testCase + ": " + obj);
            } catch (NamingException e) {
                System.out.println("Error looking up " + testCase + ": " + e.getMessage());
            }
        }
    }
}