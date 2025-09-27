package ourMethod.gemini;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;
import java.util.Properties;

public class Task68 {

    public static String searchUser(String dc, String username) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389"); // Use standard LDAP port
        env.put(Context.SECURITY_AUTHENTICATION, "none"); //  No authentication for this example


        DirContext ctx = new InitialDirContext(env);

        String base = "dc=" + dc;
        String filter = "(cn=" + username + ")"; // Sanitize username

        SearchControls ctls = new SearchControls();
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        ctls.setReturningAttributes(new String[]{"cn", "sn", "givenName", "mail"}); // Specify attributes

        NamingEnumeration<SearchResult> results = ctx.search(base, filter, ctls);

        StringBuilder userInfo = new StringBuilder();
        if (results.hasMoreElements()) {
            SearchResult sr = results.next();
            Attributes attrs = sr.getAttributes();
            if (attrs != null) {
                for (NamingEnumeration<?> ae = attrs.getAll(); ae.hasMore(); ) {
                    javax.naming.directory.Attribute attr = (javax.naming.directory.Attribute) ae.next();
                    for (NamingEnumeration<?> e = attr.getAll(); e.hasMore(); ) {
                        userInfo.append(attr.getID()).append(": ").append(e.next()).append("\n");
                    }
                }
            }
        }
        ctx.close();
        return userInfo.toString().trim();

    }

    public static void main(String[] args) throws NamingException {

        // Test cases
        System.out.println("Test Case 1:");
        System.out.println(searchUser("example,com", "testuser"));


        System.out.println("\nTest Case 2:");
        System.out.println(searchUser("mydomain,org", "johnDoe"));


        System.out.println("\nTest Case 3:");
        System.out.println(searchUser("example,com", "user123"));


        System.out.println("\nTest Case 4:");
        System.out.println(searchUser("domain,net", "adminUser"));



        System.out.println("\nTest Case 5:");
        System.out.println(searchUser("test,com", "newUser"));


    }
}