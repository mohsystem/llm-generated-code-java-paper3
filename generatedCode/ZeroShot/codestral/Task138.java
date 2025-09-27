package ZeroShot.codestral;
import java.util.HashSet;
import java.util.Set;

class User {
    private String name;
    private Set<String> privileges;

    public User(String name) {
        this.name = name;
        this.privileges = new HashSet<>();
    }

    public void addPrivilege(String privilege) {
        privileges.add(privilege);
    }

    public boolean hasPrivilege(String privilege) {
        return privileges.contains(privilege);
    }
}

public class Task138 {
    public static void main(String[] args) {
        User user1 = new User("User1");
        user1.addPrivilege("READ");
        user1.addPrivilege("WRITE");

        System.out.println(user1.hasPrivilege("READ"));  // true
        System.out.println(user1.hasPrivilege("DELETE"));  // false
    }
}