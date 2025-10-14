package ourMethodv2.gpt4o;
public class Task130 {
    public static void main(String[] args) {
        // Testing the CORS function with 5 different origin inputs
        System.out.println(handleCors("http://example.com")); // Expected: true
        System.out.println(handleCors("http://notallowed.com")); // Expected: false
        System.out.println(handleCors("https://example.com")); // Expected: true
        System.out.println(handleCors("http://another.com")); // Expected: false
        System.out.println(handleCors("http://example.com:8080")); // Expected: true
    }

    // Function to handle CORS
    public static boolean handleCors(String origin) {
        // Allowed origins
        String[] allowedOrigins = { "http://example.com", "https://example.com", "http://example.com:8080" };
        for (String allowedOrigin : allowedOrigins) {
            if (allowedOrigin.equals(origin)) {
                return true;
            }
        }
        return false;
    }
}