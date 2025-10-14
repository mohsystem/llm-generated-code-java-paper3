package ourMethod.claude;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;
import java.util.regex.*;

public class Task68 {
    private static final String LDAP_URL = "ldap://localhost:389";
    private static final int MAX_INPUT_LENGTH = 256;
    private static final Pattern DC_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]+$");

    public static String searchUser(String dcInput, String username) {
        if (dcInput == null || username == null) {
            return "Error: Input cannot be null";
        }

        if (dcInput.length() > MAX_INPUT_LENGTH || username.length() > MAX_INPUT_LENGTH) {
            return "Error: Input exceeds maximum length";
        }

        if (dcInput.isEmpty() || username.isEmpty()) {
            return "Error: Input cannot be empty";
        }

        if (!USERNAME_PATTERN.matcher(username).matches()) {
            return "Error: Invalid username format";
        }

        String[] dcComponents = dcInput.split("\\\\.");
        if (dcComponents.length == 0 || dcComponents.length > 10) {
            return "Error: Invalid domain component format";
        }

        for (String dc : dcComponents) {
            if (!DC_PATTERN.matcher(dc).matches()) {
                return "Error: Invalid domain component: " + dc;
            }
        }

        StringBuilder baseDN = new StringBuilder();
        for (int i = 0; i < dcComponents.length; i++) {
            if (i > 0) {
                baseDN.append(",");
            }
            baseDN.append("dc=").append(dcComponents[i]);
        }

        String sanitizedUsername = username.replace("\\", "\\\\5c")
                .replace("*", "\\\\2a")
                .replace("(", "\\\\28")
                .replace(")", "\\\\29")
                .replace("\\0", "\\\\00");

        String filter = "(uid=" + sanitizedUsername + ")";

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "none");
        env.put("com.sun.jndi.ldap.connect.timeout", "5000");
        env.put("com.sun.jndi.ldap.read.timeout", "5000");

        DirContext ctx = null;
        NamingEnumeration<SearchResult> results = null;

        try {
            ctx = new InitialDirContext(env);

            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            controls.setCountLimit(10);
            controls.setTimeLimit(5000);
            controls.setReturningAttributes(new String[]{"uid", "cn", "mail"});

            results = ctx.search(baseDN.toString(), filter, controls);

            StringBuilder result = new StringBuilder();
            int count = 0;

            while (results.hasMore() && count < 10) {
                SearchResult searchResult = results.next();
                Attributes attrs = searchResult.getAttributes();

                if (count > 0) {
                    result.append("---\n");
                }

                result.append("DN: ").append(searchResult.getNameInNamespace()).append("\n");

                NamingEnumeration<? extends Attribute> allAttrs = attrs.getAll();
                while (allAttrs.hasMore()) {
                    Attribute attr = allAttrs.next();
                    result.append(attr.getID()).append(": ").append(attr.get()).append("\n");
                }

                count++;
            }

            if (count == 0) {
                return "No user found";
            }

            return result.toString();

        } catch (NamingException e) {
            return "Error: LDAP operation failed - " + e.getClass().getSimpleName();
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (ctx != null) {
                    ctx.close();
                }
            } catch (NamingException e) {
                // Ignore cleanup errors
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1: Valid input");
        System.out.println(searchUser("example.com", "testuser"));
        System.out.println();

        System.out.println("Test 2: Invalid username with special chars");
        System.out.println(searchUser("example.com", "test*user"));
        System.out.println();

        System.out.println("Test 3: Null input");
        System.out.println(searchUser(null, "testuser"));
        System.out.println();

        System.out.println("Test 4: Empty input");
        System.out.println(searchUser("", "testuser"));
        System.out.println();

        System.out.println("Test 5: Invalid domain component");
        System.out.println(searchUser("exam ple.com", "testuser"));
    }
}
