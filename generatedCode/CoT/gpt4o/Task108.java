package CoT.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task108 {
    private Map<String, Object> objects = new HashMap<>();

    public synchronized void addObject(String key, Object obj) {
        objects.put(key, obj);
    }

    public synchronized Object getObject(String key) {
        return objects.get(key);
    }

    public synchronized void removeObject(String key) {
        objects.remove(key);
    }

    public static void main(String[] args) {
        Task108 server = new Task108();
        
        server.addObject("1", "Object1");
        System.out.println(server.getObject("1"));

        server.addObject("2", 12345);
        System.out.println(server.getObject("2"));

        server.addObject("3", 67.89);
        System.out.println(server.getObject("3"));

        server.removeObject("1");
        System.out.println(server.getObject("1"));

        server.addObject("4", new int[]{1, 2, 3});
        int[] array = (int[]) server.getObject("4");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}