package ourMethod.llama31;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
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

        // Validate inputs to prevent injection attacks
        if (username.contains("*") || username.contains("(") || username.contains(")")) {
            System.out.println("Invalid username");
            return;
        }
        if (domain.contains("*") || domain.contains("(") || domain.contains(")")) {
            System.out.println("Invalid domain");
            return;
        }

        // Construct LDAP query
        String ldapQuery = "(&(objectClass=user)(sAMAccountName=" + username + ")(dc=" + domain + "))";

        // Set up LDAP connection properties
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://localhost:389");
        props.put(Context.SECURITY_AUTHENTICATION, "simple");
        props.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=" + domain);
        props.put(Context.SECURITY_CREDENTIALS, "password"); // Replace with actual password

        try {
            // Establish LDAP connection
            DirContext ctx = new InitialDirContext(props);

            // Search for user
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> results = ctx.search("dc=" + domain, ldapQuery, controls);

            // Process search results
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attrs = result.getAttributes();
                Attribute attr = attrs.get("cn");
                if (attr != null) {
                    System.out.println("User found: " + attr.get());
                }
            }

            // Close LDAP connection
            ctx.close();
        } catch (NamingException e) {
            System.out.println("LDAP error: " + e.getMessage());
        }
    }
}