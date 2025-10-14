package Vanilla.openai;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide domain component and username.");
            return;
        }
        String dc = args[0];
        String username = args[1];
        String result = ldapSearch(dc, username);
        System.out.println(result);
    }

    public static String ldapSearch(String dc, String username) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");

        try {
            DirContext ctx = new InitialDirContext(env);
            String searchFilter = "(uid=" + username + ")";
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search("dc=" + dc + ",dc=com", searchFilter, controls);
            if (results.hasMore()) {
                SearchResult result = results.next();
                return result.getNameInNamespace();
            }
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return "User not found";
    }
}