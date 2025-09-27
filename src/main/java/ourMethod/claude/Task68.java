package ourMethod.claude;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    private static final String LDAP_URL = "ldap://localhost:389";
    private static final String ADMIN_DN = "cn=admin,dc=example,dc=com"; 
    private static final String ADMIN_PASSWORD = "admin123";
    
    public static SearchResult searchUser(String dc, String username) throws NamingException {
        if (dc == null || dc.isEmpty() || username == null || username.isEmpty()) {
            throw new IllegalArgumentException("DC and username cannot be null or empty");
        }

        // Validate input
        if (!dc.matches("^[a-zA-Z0-9.-]+$") || !username.matches("^[a-zA-Z0-9._-]+$")) {
            throw new IllegalArgumentException("Invalid characters in DC or username");
        }

        // Initialize LDAP environment
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ADMIN_DN);
        env.put(Context.SECURITY_CREDENTIALS, ADMIN_PASSWORD);

        DirContext ctx = null;
        try {
            // Establish connection
            ctx = new InitialDirContext(env);

            // Create search controls
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            // Construct safe LDAP query
            String searchBase = "dc=" + dc + ",dc=com";
            String searchFilter = "(&(objectClass=person)(uid=" + escapeSpecialChars(username) + "))";

            // Perform search
            NamingEnumeration<SearchResult> results = 
                ctx.search(searchBase, searchFilter, searchControls);

            if (results.hasMore()) {
                return results.next();
            }
            
            return null;
            
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    // Log error
                }
            }
        }
    }

    private static String escapeSpecialChars(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '\\': sb.append("\\\\5c"); break;
                case '*': sb.append("\\\\2a"); break;
                case '(': sb.append("\\\\28"); break;
                case ')': sb.append("\\\\29"); break;
                case '\u0000': sb.append("\\\\00"); break;
                case '/': sb.append("\\\\2f"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            // Test cases
            System.out.println("Test Case 1:");
            printUserInfo("example", "jsmith");

            System.out.println("\\nTest Case 2:");
            printUserInfo("company", "mjones");

            System.out.println("\\nTest Case 3:");
            printUserInfo("org", "admin");

            System.out.println("\\nTest Case 4:");
            printUserInfo("test", "user1");

            System.out.println("\\nTest Case 5:");
            printUserInfo("local", "guest");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void printUserInfo(String dc, String username) {
        try {
            SearchResult result = searchUser(dc, username);
            if (result != null) {
                System.out.println("Found user: " + result.getNameInNamespace());
                Attributes attrs = result.getAttributes();
                NamingEnumeration<? extends Attribute> ae = attrs.getAll();
                while (ae.hasMore()) {
                    Attribute attr = ae.next();
                    System.out.println(attr.getID() + ": " + attr.get());
                }
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.err.println("Error searching for user: " + e.getMessage());
        }
    }
}
