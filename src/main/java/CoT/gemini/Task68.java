package CoT.gemini;
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

    public static String searchUser(String username, String domainComponent) throws NamingException {
        // Input validation to prevent LDAP injection
        if (!username.matches("^[a-zA-Z0-9._-]+$") || !domainComponent.matches("^[a-zA-Z0-9.-]+$")) {
            return "Invalid username or domain component";
        }


        String ldapUrl = "ldap://localhost:389"; // Use a secure port (e.g., 636 for LDAPS) in production
        String baseDn = "dc=" + domainComponent; // Construct the base DN safely
        String searchFilter = "(sAMAccountName=" + username + ")"; // Construct the search filter safely


        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "none"); // Use appropriate authentication in production

        DirContext ctx = new InitialDirContext(env);

        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> results = ctx.search(baseDn, searchFilter, searchCtls);

        StringBuilder userInfo = new StringBuilder();

        if (results.hasMore()) {
            SearchResult sr = results.next();
            Attributes attrs = sr.getAttributes();
            NamingEnumeration<? extends javax.naming.directory.Attribute> all = attrs.getAll();
            while (all.hasMore()) {
                javax.naming.directory.Attribute attr = all.next();
                userInfo.append(attr.getID()).append(": ").append(attr.get()).append("\n");
            }

        }
        ctx.close();

        return userInfo.toString();

    }

    public static void main(String[] args) throws NamingException {
        // Test cases
        System.out.println(searchUser("testuser", "example.com"));
        System.out.println(searchUser("user123", "mydomain.net"));
        System.out.println(searchUser("john.doe", "company.org"));
        System.out.println(searchUser("invalid/user", "example.com")); // Test for LDAP injection
        System.out.println(searchUser("testuser", "example;com"));   // Test for LDAP injection

    }
}