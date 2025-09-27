package Vanilla.gemini;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {

    public static String ldapSearch(String username, String dc) throws NamingException {
        String ldapUrl = "ldap://localhost:389";
        String baseDn = "dc=" + dc.replace(".", ",dc=");
        String searchFilter = "(&(objectClass=user)(sAMAccountName=" + username + "))";

        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);

        DirContext ctx = new InitialDirContext(env);
        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> answer = ctx.search(baseDn, searchFilter, searchCtls);

        StringBuilder result = new StringBuilder();
        if (answer.hasMoreElements()) {
            SearchResult sr = answer.next();
            Attributes attrs = sr.getAttributes();
            if (attrs != null) {
                for (NamingEnumeration<? extends Attribute> ae = attrs.getAll(); ae.hasMore();) {
                    Attribute attr = ae.next();
                    result.append(attr.getID()).append(": ");
                    for (NamingEnumeration<?> e = attr.getAll(); e.hasMore(); ) {
                        result.append(e.next()).append(", ");
                    }
                    result.append("\n");
                }
            }
        }
        ctx.close();
        return result.toString();
    }


    public static void main(String[] args) throws NamingException {
        System.out.println(ldapSearch("user1", "example.com")); // Replace with actual values
        System.out.println(ldapSearch("user2", "test.local")); // Replace with actual values
        System.out.println(ldapSearch("admin", "example.com")); // Replace with actual values
        System.out.println(ldapSearch("guest", "test.local")); // Replace with actual values
        System.out.println(ldapSearch("user3", "example.net")); // Replace with actual values
    }
}