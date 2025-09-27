package Vanilla.codestral;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class Task68 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task68 <domain> <username>");
            return;
        }
        String domain = args[0];
        String username = args[1];
        String ldapQuery = "(&(objectClass=person)(dc=" + domain + ")(uid=" + username + "))";
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> answer = ctx.search("", ldapQuery, ctls);
            while (answer.hasMoreElements()) {
                SearchResult result = answer.nextElement();
                System.out.println(result.getAttributes());
            }
            ctx.close();
        } catch (NamingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}