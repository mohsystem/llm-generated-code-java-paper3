package ourMethod.llama31;
public class Task125 {
    public static void main(String[] args) {
        String[] resources = {"Resource1", "Resource2", "Resource3"};
        String[] accessLevels = {"Admin", "User", "Guest"};

        // Test cases
        String[][] testCases = {
            {"Admin", "Resource1"},
            {"User", "Resource2"},
            {"Guest", "Resource3"},
            {"InvalidUser", "Resource1"}, // Invalid user
            {"Admin", "InvalidResource"}  // Invalid resource
        };

        for (String[] testCase : testCases) {
            System.out.println("User: " + testCase[0] + ", Resource: " + testCase[1]);
            if (accessResource(testCase[0], testCase[1], resources, accessLevels)) {
                System.out.println("Access granted.");
            } else {
                System.out.println("Access denied.");
            }
            System.out.println();
        }
    }

    public static boolean accessResource(String user, String resource, String[] resources, String[] accessLevels) {
        // Check if user and resource are not null
        if (user == null || resource == null) {
            return false;
        }

        // Simulate access control
        for (String res : resources) {
            if (res.equals(resource)) {
                // Simple access control logic for demonstration
                if (user.equals("Admin")) {
                    return true;
                } else if (user.equals("User") && !res.equals("Resource1")) {
                    return true;
                } else if (user.equals("Guest") && !res.equals("Resource1") && !res.equals("Resource2")) {
                    return true;
                }
            }
        }

        return false;
    }
}