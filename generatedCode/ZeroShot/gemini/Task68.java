package ZeroShot.gemini;
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

    public static Attributes searchUser(String domainComponent, String username) throws NamingException {
        // Secure LDAP connection using SSL
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldaps://localhost:636"); // Use ldaps for SSL
        env.put(Context.SECURITY_AUTHENTICATION, "simple"); // Or other appropriate authentication method
        env.put(Context.SECURITY_PRINCIPAL, ""); // Bind DN or username if required
        env.put(Context.SECURITY_CREDENTIALS, ""); // Password if required
        
        // Create initial context
        DirContext ctx = new InitialDirContext(env);

        String baseDN = "dc=" + domainComponent.replace(".", ",dc=");
        String searchFilter = "(sAMAccountName=" + username + ")";
        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> answer = ctx.search(baseDN, searchFilter, searchCtls);

        if (answer.hasMoreElements()) {
            SearchResult sr = (SearchResult) answer.next();
            Attributes attrs = sr.getAttributes();
            ctx.close();
            return attrs;
        } else {
            ctx.close();
            return null; // Or throw an exception
        }

    }

    public static void main(String[] args) throws NamingException {

        if (args.length < 2) {
            System.out.println("Usage: java Task68 <domainComponent> <username>");
            return;
        }

        String dc = args[0];
        String username = args[1];


        // Test cases
        Attributes user1 = searchUser(dc, username);
        System.out.println(user1);
        //Attributes user2 = searchUser("example.com", "testuser2");
        //Attributes user3 = searchUser("example.net", "testuser3");
        //Attributes user4 = searchUser("example.org", "testuser4");
        //Attributes user5 = searchUser("example.com", "testuser5");
    }

}