package CoT.gpt4o;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static String searchLDAP(String dc, String username) {
        String ldapQuery = String.format("(&(dc=%s)(uid=%s))", dc, username);
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        
        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> results = ctx.search("", ldapQuery, controls);
            
            if (results.hasMore()) {
                SearchResult result = results.next();
                return result.toString();
            }
            
            ctx.close();
        } catch (NamingException e) {
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