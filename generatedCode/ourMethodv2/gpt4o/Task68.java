package ourMethodv2.gpt4o;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static String searchLDAP(String domainComponent, String username) {
        String result = "";
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");

        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
            String searchFilter = "(&(objectClass=person)(sAMAccountName=" + escapeLDAPSearchFilter(username) + "))";
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String baseDN = "dc=" + domainComponent + ",dc=com";
            
            NamingEnumeration<SearchResult> results = ctx.search(baseDN, searchFilter, searchControls);

            if (results.hasMore()) {
                SearchResult searchResult = results.next();
                Attributes attributes = searchResult.getAttributes();
                result = attributes.toString();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static String escapeLDAPSearchFilter(String filter) {
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
        System.out.println(searchLDAP("example", "john"));
        System.out.println(searchLDAP("test", "doe"));
        System.out.println(searchLDAP("company", "jane"));
        System.out.println(searchLDAP("corporate", "alice"));
        System.out.println(searchLDAP("organization", "bob"));
    }
}