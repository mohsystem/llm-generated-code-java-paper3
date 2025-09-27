package Vanilla.llama31;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class Task68 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task68 <username> <domain>");
            return;
        }

        String username = args[0];
        String domain = args[1];

        searchLDAP(username, domain);
    }

    public static void searchLDAP(String username, String domain) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.SECURITY_AUTHENTICATION, "none"); // Anonymous bind

        try {
            DirContext ctx = new InitialDirContext(env);
            //todo no suitable method found for replace(char,String)
            //method String.replace(char,char) is not applicable
            //(argument mismatch; String cannot be converted to char)
            //method String.replace(CharSequence,CharSequence) is not applicable
            //(argument mismatch; char cannot be converted to CharSequence)
//            String baseDN = "dc=" + domain.replace('.', ",dc=");
            String baseDN = "dc=" + domain.replace(".", ",dc=");
            String filter = "(uid=" + username + ")";

            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, controls);

            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();
                for (NamingEnumeration<? extends Attribute> ae = attributes.getAll(); ae.hasMore(); ) {
                    Attribute attribute = ae.next();
                    for (NamingEnumeration<?> ve = attribute.getAll(); ve.hasMore(); ) {
                        System.out.println(attribute.getID() + ": " + ve.next());
                    }
                }
            }
        } catch (NamingException e) {
            System.out.println("LDAP Error: " + e.getMessage());
        }
    }
}