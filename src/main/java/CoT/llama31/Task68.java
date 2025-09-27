package CoT.llama31;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Properties;

public class Task68 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task68 <username> <domain>");
            return;
        }

        String username = args[0];
        String domain = args[1];

        // Extract dc components from domain
        String[] dcComponents = domain.split("\\.");

        // Construct LDAP query
        String ldapQuery = "uid=" + username + ",dc=" + dcComponents[0] + ",dc=" + dcComponents[1];

        // Establish LDAP connection and search
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://localhost:389");
        try {
            DirContext ctx = new InitialDirContext(props);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> results = ctx.search("dc=" + dcComponents[0] + ",dc=" + dcComponents[1], ldapQuery, controls);
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attrs = result.getAttributes();
                System.out.println("User Information:");
                NamingEnumeration<?> attrsEnum = attrs.getAll();
                while (attrsEnum.hasMore()) {
                    System.out.println(attrsEnum.next());
                }
            }
            ctx.close();
        } catch (NamingException e) {
            System.out.println("LDAP Exception: " + e.getMessage());
        }
    }
}