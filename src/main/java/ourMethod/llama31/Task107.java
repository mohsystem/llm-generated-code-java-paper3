package ourMethod.llama31;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {
    public static void main(String[] args) {
        String[] jndiNames = {"SERVICE1", "SERVICE2", "SERVICE3", "SERVICE4", "SERVICE5"};
        for (String jndiName : jndiNames) {
            try {
                // Set a timeout if needed
                Context context = new InitialContext();
                Object service = context.lookup(jndiName);
                System.out.println("Lookup result for " + jndiName + ": " + service);
            } catch (NamingException e) {
                System.out.println("Error looking up " + jndiName + ": " + e.getMessage());
            }
        }
    }
}