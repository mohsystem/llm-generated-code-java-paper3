package ZeroShot.codestral;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Task107 {
    public static Object performLookup(String jndiName) throws NamingException {
        Context ctx = new InitialContext();
        return ctx.lookup(jndiName);
    }

    public static void main(String[] args) {
        try {
            System.out.println(performLookup("jndiName1"));
            System.out.println(performLookup("jndiName2"));
            System.out.println(performLookup("jndiName3"));
            System.out.println(performLookup("jndiName4"));
            System.out.println(performLookup("jndiName5"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}