package ZeroShot.llama31;
public class Task125 {
    public static void main(String[] args) {
        // Test cases
        String[] resourceIds = {"R1", "R2", "R3", "R4", "R5"};
        String[] resources = {"Resource 1", "Resource 2", "Resource 3", "Resource 4", "Resource 5"};

        for (String resourceId : resourceIds) {
            System.out.println("Accessing resource with ID: " + resourceId);
            String resource = getResource(resourceId, resources);
            System.out.println(resource);
            System.out.println();
        }
    }

    public static String getResource(String resourceId, String[] resources) {
        for (int i = 0; i < resources.length; i++) {
            if ("R" + (i + 1).equals(resourceId)) {
                return resources[i];
            }
        }
        return "Resource not found";
    }
}