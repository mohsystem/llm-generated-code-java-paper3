package ZeroShot.openai;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static String searchLdap(String domainComponent, String username) {
        String ldapUrl = "ldap://localhost:389";
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);

        String filter = "(&(objectClass=person)(uid=" + escapeLdapSearchFilter(username) + "))";
        String searchBase = "dc=" + escapeLdapSearchFilter(domainComponent) + ",dc=com";

        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> results = ctx.search(searchBase, filter, controls);

            if (results.hasMore()) {
                SearchResult result = results.next();
                return result.getNameInNamespace();
            }
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String escapeLdapSearchFilter(String filter) {
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

    public static void main(String[] args) {
        System.out.println(searchLdap("example", "john.doe"));
        System.out.println(searchLdap("example", "jane.smith"));
        System.out.println(searchLdap("example", "bob.jones"));
        System.out.println(searchLdap("example", "alice.brown"));
        System.out.println(searchLdap("example", "charlie.black"));
    }
}