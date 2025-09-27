package Vanilla.gemini;
import java.util.UUID;

class Task84 {
    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        Task84 task84 = new Task84();
        System.out.println(task84.generateSessionId());
        System.out.println(task84.generateSessionId());
        System.out.println(task84.generateSessionId());
        System.out.println(task84.generateSessionId());
        System.out.println(task84.generateSessionId());
    }
}