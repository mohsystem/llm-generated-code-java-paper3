package ZeroShot.claude;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.util.Properties;

public class Task68 {
    public static String searchLDAP(String domain, String username) {
        if (domain == null || username == null || domain.isEmpty() || username.isEmpty()) {
            return "Invalid input parameters";
        }

        // Sanitize inputs
        domain = domain.replaceAll("[^a-zA-Z0-9.-]", "");
        username = username.replaceAll("[^a-zA-Z0-9._-]", "");

        StringBuilder result = new StringBuilder();
        DirContext context = null;

        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            
            // Use proper authentication
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=" + domain);
            env.put(Context.SECURITY_CREDENTIALS, "admin_password");

            context = new InitialDirContext(env);

            // Create search controls
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            // Construct safe LDAP filter
            String searchFilter = "(&(objectClass=person)(uid=" + escapeSpecialChars(username) + "))";
            String searchBase = "dc=" + domain;

            // Perform search
            NamingEnumeration<SearchResult> searchResults = 
                context.search(searchBase, searchFilter, searchControls);

            while (searchResults.hasMore()) {
                SearchResult sr = searchResults.next();
                Attributes attrs = sr.getAttributes();
                result.append("DN: ").append(sr.getNameInNamespace()).append("\\n");
                
                NamingEnumeration<? extends Attribute> attributes = attrs.getAll();
                while(attributes.hasMore()) {
                    Attribute attr = attributes.next();
                    result.append(attr.getID()).append(": ").append(attr.get()).append("\\n");
                }
            }

        } catch (Exception e) {
            return "Error during LDAP search: " + e.getMessage();
        } finally {
            if (context != null) {
                try {
                    context.close();
                } catch (Exception e) {
                    // Log error
                }
            }
        }

        return result.length() > 0 ? result.toString() : "No results found";
    }

    private static String escapeSpecialChars(String input) {
        return input.replace("\\", "\\\\\\\")\n                   .replace("*", "\\\\2a")\n                   .replace("(", "\\\\28")\n                   .replace(")", "\\\\29")\n                   .replace("\\u0000", "\\\\00");\n    }\n\n    public static void main(String[] args) {\n        // Test cases\n        System.out.println("Test Case 1:");\n        System.out.println(searchLDAP("example.com", "john.doe"));\n\n        System.out.println("\
Test Case 2:");\n        System.out.println(searchLDAP("company.local", "admin"));\n\n        System.out.println("\
Test Case 3:");\n        System.out.println(searchLDAP("", "user")); // Invalid input\n\n        System.out.println("\
Test Case 4:");\n        System.out.println(searchLDAP("test.com", "")); // Invalid input\n\n        System.out.println("\
Test Case 5:");\n        System.out.println(searchLDAP("domain.com", "user*")); // Special character handling
    }
}
