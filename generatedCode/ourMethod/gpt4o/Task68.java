package ourMethod.openai;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class Task68 {
    public static String searchLDAP(String domainComponent, String username) {
        String ldapURL = "ldap://localhost:389";
        String baseDN = "dc=" + domainComponent;
        String filter = "(&(objectClass=person)(uid=" + username + "))";

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapURL);

        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, searchControls);
            if (results.hasMore()) {
                SearchResult result = results.next();
                return result.getNameInNamespace();
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(searchLDAP("example", "user1"));
        System.out.println(searchLDAP("example", "user2"));
        System.out.println(searchLDAP("example", "user3"));
        System.out.println(searchLDAP("example", "user4"));
        System.out.println(searchLDAP("example", "user5"));
    }
}