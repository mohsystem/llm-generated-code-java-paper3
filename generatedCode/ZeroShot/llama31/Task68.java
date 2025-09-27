package ZeroShot.llama31;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class Task68 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task68 <username> <domainComponent>");
            return;
        }

        String username = args[0];
        String domainComponent = args[1];

        // Escape user input
        String safeUsername = escapeLDAPSearchFilter(username);
        String safeDomainComponent = escapeLDAPSearchFilter(domainComponent);

        // Construct LDAP query
        String baseDN = "dc=" + safeDomainComponent + ",dc=com";
        String filter = "(cn=" + safeUsername + ")";

        // Establish LDAP connection and search
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, controls);
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();
                System.out.println("User Information:");
                for (NamingEnumeration<?> ae = attributes.getAll(); ae.hasMore(); ) {
                    Attribute attribute = (Attribute) ae.next();
                    System.out.println(attribute.getID() + ": " + attribute.get());
                }
            }
            ctx.close();
        } catch (NamingException e) {
            System.out.println("LDAP Error: " + e.getMessage());
        }
    }

    public static String escapeLDAPSearchFilter(String filter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filter.length(); i++) {
            char curChar = filter.charAt(i);
            switch (curChar) {
                case '\\':
                    sb.append("\\5c");
                    break;
                case '*':
                    sb.append("\\2a");
                    break;
                case '(':
                    sb.append("\\28");
                    break;
                case ')':
                    sb.append("\\29");
                    break;
                case '\u0000':
                    sb.append("\\00");
                    break;
                default:
                    sb.append(curChar);
            }
        }
        return sb.toString();
    }
}