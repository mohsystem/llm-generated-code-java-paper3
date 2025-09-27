package CoT.codestral;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class Task68 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task68 <domain_component> <username>");
            return;
        }

        String domainComponent = args[0];
        String username = args[1];

        try {
            String ldapUrl = "ldap://localhost:389";
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, ldapUrl);

            DirContext ctx = new InitialDirContext(env);

            String searchFilter = "(&(objectClass=*)(uid=" + username + "))";
            String searchBase = "dc=" + domainComponent;

            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(searchBase, searchFilter, searchCtls);

            if (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();

                System.out.println("User Information:");
                NamingEnumeration<?> attributeIds = attributes.getIDs();
                while (attributeIds.hasMore()) {
                    String id = (String) attributeIds.next();
                    Attribute attribute = attributes.get(id);
                    System.out.println(id + ": " + attribute.get());
                }
            } else {
                System.out.println("User not found.");
            }

            ctx.close();
        } catch (NamingException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}