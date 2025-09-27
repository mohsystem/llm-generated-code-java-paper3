package ZeroShot.codestral;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class Task68 {
    public static Attributes searchUser(String dc, String username) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389/" + dc);
        LdapContext ctx = new InitialLdapContext(env, null);
        SearchControls ctls = new SearchControls();
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> answer = ctx.search("", "uid=" + username, ctls);
        if (answer.hasMore()) {
            return answer.next().getAttributes();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(searchUser(args[0], args[1]));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}