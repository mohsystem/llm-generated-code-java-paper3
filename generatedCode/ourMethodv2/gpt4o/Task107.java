package ourMethodv2.gpt4o;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class Task107 {

    public Object performJndiLookup(String jndiName) {
        try {
            Context context = new InitialContext();
            return context.lookup(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Task107 task = new Task107();
        
        // Test cases
        Object result1 = task.performJndiLookup("java:comp/env/jdbc/MyDB");
        System.out.println(result1);
        
        Object result2 = task.performJndiLookup("java:comp/env/mail/Session");
        System.out.println(result2);
        
        Object result3 = task.performJndiLookup("java:comp/env/ejb/MyEJB");
        System.out.println(result3);
        
        Object result4 = task.performJndiLookup("java:comp/env/queue/MyQueue");
        System.out.println(result4);
        
        Object result5 = task.performJndiLookup("java:comp/env/topic/MyTopic");
        System.out.println(result5);
    }
}