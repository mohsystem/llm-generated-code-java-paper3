package CoT.claude;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static String searchLDAP(String username, String domain) {
        if (username == null || domain == null || username.isEmpty() || domain.isEmpty()) {
            return "Invalid input parameters";
        }

        // Sanitize inputs
        username = username.replaceAll("[^a-zA-Z0-9]", "");
        domain = domain.replaceAll("[^a-zA-Z0-9.]", "");

        StringBuilder result = new StringBuilder();
        
        try {
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            
            // Create secure connection
            DirContext ctx = new InitialDirContext(env);
            
            // Construct safe LDAP query
            String searchFilter = "(&(objectClass=person)(uid=" + username + "))";
            String searchBase = "dc=" + domain.replace(".", ",dc=");
            
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            // Perform search with timeout
            searchControls.setTimeLimit(5000);
            NamingEnumeration<SearchResult> results = ctx.search(searchBase, searchFilter, searchControls);
            
            while (results != null && results.hasMore()) {
                SearchResult entry = results.next();
                Attributes attrs = entry.getAttributes();
                
                if (attrs != null) {
                    result.append("DN: ").append(entry.getNameInNamespace()).append("\\n");
                    NamingEnumeration<? extends Attribute> ae = attrs.getAll();
                    while (ae.hasMore()) {
                        Attribute attr = ae.next();
                        result.append(attr.getID()).append(": ").append(attr.get()).append("\\n");
                    }
                }
            }
            
            ctx.close();
            
        } catch (Exception e) {
            return "Error during LDAP search: " + e.getMessage();
        }
        
        return result.length() > 0 ? result.toString() : "No results found";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1:");
        System.out.println(searchLDAP("john", "example.com"));
        
        System.out.println("\\nTest Case 2:");
        System.out.println(searchLDAP("alice", "company.local"));
        
        System.out.println("\\nTest Case 3:");
        System.out.println(searchLDAP("", "domain.com"));
        
        System.out.println("\\nTest Case 4:");
        System.out.println(searchLDAP("bob", ""));
        
        System.out.println("\\nTest Case 5:");
        System.out.println(searchLDAP("admin", "test.org"));
    }
}
