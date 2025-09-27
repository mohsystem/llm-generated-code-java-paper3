package Vanilla.claude;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static String searchLDAP(String username, String domain) {
        String result = "";
        try {
            // Set up environment for creating initial context
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            
            // Create initial context
            DirContext ctx = new InitialDirContext(env);
            
            // Construct LDAP query
            String searchFilter = "(&(objectClass=person)(uid=" + username + "))";
            String searchBase = "dc=" + domain.replace(".", ",dc=");
            
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            // Perform search
            NamingEnumeration<SearchResult> results = ctx.search(searchBase, searchFilter, searchControls);
            
            if (results.hasMore()) {
                SearchResult searchResult = results.next();
                Attributes attrs = searchResult.getAttributes();
                result = "User found: " + attrs.get("cn") + ", " + attrs.get("mail");
            } else {
                result = "User not found";
            }
            
            ctx.close();
            
        } catch (Exception e) {
            result = "Error: " + e.getMessage();
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(searchLDAP("john.doe", "example.com"));
        System.out.println(searchLDAP("jane.smith", "company.org"));
        System.out.println(searchLDAP("admin", "local.net"));
        System.out.println(searchLDAP("user1", "test.com"));
        System.out.println(searchLDAP("guest", "domain.com"));
    }
}
