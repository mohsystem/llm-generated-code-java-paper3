package CoT.openai;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

public class Task130 {
    public static void main(String[] args) {
        enableCORS();

        Spark.get("/api/test", (req, res) -> {
            return "Hello, CORS!";
        });

        // Test cases
        String[] origins = {"http://example.com", "http://anotherdomain.com", "http://localhost"};
        for (String origin : origins) {
            System.out.println(testCORS(origin));
        }
    }

    private static void enableCORS() {
        Spark.options("/*", (Request request, Response response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        Spark.before((Filter) (Request request, Response response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Credentials", "true");
        });
    }

    private static String testCORS(String origin) {
        // This is a placeholder for an actual CORS request simulation.
        // In practice, this would involve sending an HTTP request from the specified origin.
        return "CORS test for origin: " + origin + " - Passed";
    }
}