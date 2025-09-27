package ourMethod.codestral;
import javax.naming.*;
import java.util.Hashtable;

public class Task107 {
    public static Object performJNDILookup(String jndiName) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:1389/dc=example,dc=com");
        Context ctx = new InitialContext(env);
        return ctx.lookup(jndiName);
    }

    public static void main(String[] args) {
        try {
            Object obj = performJNDILookup("name1");
            System.out.println("Object retrieved: " + obj);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}