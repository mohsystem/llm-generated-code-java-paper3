package ourMethod.codestral;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.SimpleBindRequest;
import com.unboundid.ldap.sdk.SearchRequest;

public class Task68 {
    public static void main(String[] args) throws LDAPException {
        if (args.length != 2) {
            System.out.println("Usage: java Task68 <domain> <username>");
            return;
        }
        String domain = args[0];
        String username = args[1];
        String ldapQuery = "uid=" + username + ",dc=" + domain.replace(".", ",dc=");
        LDAPConnection conn = new LDAPConnection("localhost", 389);
        //todo no suitable constructor found for SimpleBindRequest(String)
        //constructor SimpleBindRequest.SimpleBindRequest(DN,String,Control...) is not applicable
        //(argument mismatch; String cannot be converted to DN)
        //constructor SimpleBindRequest.SimpleBindRequest(DN,byte[],Control...) is not applicable
        //(argument mismatch; String cannot be converted to DN)
        //constructor SimpleBindRequest.SimpleBindRequest(DN,PasswordProvider,Control...) is not applicable
        //(argument mismatch; String cannot be converted to DN)
        //constructor SimpleBindRequest.SimpleBindRequest(ASN1OctetString,ASN1OctetString,PasswordProvider,Control...) is not applicable
        //(argument mismatch; String cannot be converted to ASN1OctetString)
//        conn.bind(new SimpleBindRequest("cn=Directory Manager"));
        conn.bind(new SimpleBindRequest("cn=Directory Manager",""));
        SearchResult searchResult = conn.search(ldapQuery, SearchScope.SUB, "(objectclass=*)");
        //cannot find symbol method getEntry(int)
//        System.out.println(searchResult.getEntry(0));
    }
}