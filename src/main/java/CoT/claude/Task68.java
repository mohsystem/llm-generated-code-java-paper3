package CoT.claude;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;

public class Task68 {

    private static String sanitizeLdapInput(String input) {
        if (input == null) {
            return "";
        }
        // Escape LDAP special characters to prevent injection
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '\\':
                    sb.append("\\\\5c");
                    break;
                case '*':
                    sb.append("\\\\2a");
                    break;
                case '(':
                    sb.append("\\28");
                    break;
                case ')':
                    sb.append("\\29");
                    break;
                case '\0':
                    sb.append("\00");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String sanitizeDN(String input) {
        if (input == null) {
            return "";
        }
        // Escape DN special characters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '\\':
                case ',':
                case '+':
                case '"':
                case '<':
                case '>':
                case ';':
                case '=':
                    sb.append('\\').append(c);
                    break;
                case '#':
                    if (i == 0) {
                        sb.append('\\').append(c);
                    } else {
                        sb.append(c);
                    }
                    break;
                case ' ':
                    if (i == 0 || i == input.length() - 1) {
                        sb.append('\\').append(c);
                    } else {
                        sb.append(c);
                    }
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static Map<String, String> searchUser(String username, String dc) {
        Map<String, String> userInfo = new HashMap<>();
        // Validate inputs
        if (username == null || username.trim().isEmpty()) {
            userInfo.put("error", "Username cannot be empty");
            return userInfo;
        }
        if (dc == null || dc.trim().isEmpty()) {
            userInfo.put("error", "Domain component cannot be empty");
            return userInfo;
        }
        // Sanitize inputs to prevent LDAP injection
        String sanitizedUsername = sanitizeLdapInput(username.trim());
        String sanitizedDC = sanitizeDN(dc.trim());
        // Validate DC format (should be like "example,com")
        if (!sanitizedDC.matches("^[a-zA-Z0-9\\-,]+$")) {
            userInfo.put("error", "Invalid domain component format");
            return userInfo;
        }
        DirContext ctx = null;
        try {
            // Setup LDAP connection properties
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            env.put(Context.SECURITY_AUTHENTICATION, "none");
            // For demo purposes
            // Create initial context
            ctx = new InitialDirContext(env);
            // Construct base DN safely
            String[] dcParts = sanitizedDC.split(",");
            StringBuilder baseDN = new StringBuilder();
            for (int i = 0; i < dcParts.length; i++) {
                if (i > 0) baseDN.append(",");
                baseDN.append("dc=").append(dcParts[i].trim());
            }
            // Create search filter using sanitized input
            String searchFilter = "(uid=" + sanitizedUsername + ")";
            // Setup search controls
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            searchControls.setCountLimit(1);
            // Limit results
            searchControls.setTimeLimit(5000);
            // 5 second timeout
            // Perform search
            NamingEnumeration<SearchResult> results = ctx.search(baseDN.toString(), searchFilter, searchControls);
            if (results.hasMore()) {
                SearchResult searchResult = results.next();
                Attributes attributes = searchResult.getAttributes();
                userInfo.put("dn", searchResult.getNameInNamespace());
                // Extract common attributes safely
                NamingEnumeration<? extends Attribute> attrs = attributes.getAll();
                while (attrs.hasMore()) {
                    Attribute attr = attrs.next();
                    String attrId = attr.getID();
                    Object value = attr.get();
                    userInfo.put(attrId, value != null ? value.toString() : "");
                }
                userInfo.put("status", "User found");
            } else {
                userInfo.put("status", "User not found");
            }
        } catch (NamingException e) {
            userInfo.put("error", "LDAP error: " + e.getMessage());
        } catch (Exception e) {
            userInfo.put("error", "Unexpected error: " + e.getMessage());
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    // Log error
                }
            }
        }
        return userInfo;
    }

    public static void main(String[] args) {
        System.out.println("=== LDAP User Search Program ===");
        // Test cases
        String[][] testCases = {{"jdoe", "example,com"},
                {"alice", "test,org"}, {"bob123", "company,local"},
                {"user*", "example,com"},
                // Test injection attempt
                {"admin", "corp,internal"}};
        if (args.length >= 2) {
            // Use command line arguments
            String username = args[0];
            String dc = args[1];
            System.out.println("Searching for user: " + username + " in domain: " + dc);
            Map<String, String> result = searchUser(username, dc);
            printResult(result);
        } else {
            // Run test cases
            System.out.println("No command line arguments provided. Running test cases...");
            for (int i = 0; i < testCases.length; i++) {
                System.out.println("Test Case " + (i + 1) + ":");
                System.out.println("Username: " + testCases[i][0]);
                System.out.println("DC: " + testCases[i][1]);
                Map<String, String> result = searchUser(testCases[i][0], testCases[i][1]);
                printResult(result);
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void printResult(Map<String, String> result) {
        System.out.println("Result:");
        for (Map.Entry<String, String> entry : result.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
