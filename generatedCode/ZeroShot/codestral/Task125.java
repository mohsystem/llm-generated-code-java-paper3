package ZeroShot.codestral;
public class Task125 {
    private static String[] resources = {"Resource1", "Resource2", "Resource3"};
    private static int[] roles = {1, 2, 1};

    public static String accessResource(int userRole, int resourceIndex) {
        if(resourceIndex >= 0 && resourceIndex < resources.length) {
            if(userRole == roles[resourceIndex]) {
                return resources[resourceIndex];
            } else {
                return "Access Denied";
            }
        } else {
            return "Resource Not Found";
        }
    }

    public static void main(String[] args) {
        System.out.println(accessResource(1, 0)); // "Resource1"
        System.out.println(accessResource(2, 1)); // "Resource2"
        System.out.println(accessResource(1, 1)); // "Access Denied"
        System.out.println(accessResource(1, 3)); // "Resource Not Found"
        System.out.println(accessResource(2, -1)); // "Resource Not Found"
    }
}