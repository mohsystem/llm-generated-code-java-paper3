package ourMethod.openai;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class Task130 {
    public static void main(String[] args) {
        Spark.port(4567);
        
        // CORS configuration
        Spark.options("/*", (request, response) -> {
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

        Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // Example API
        Spark.get("/api/data", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                response.type("application/json");
                return "{\"data\":\"CORS example\"}";
            }
        });

        // Test cases
        testCors("/api/data");
    }

    private static void testCors(String path) {
        // Simulate HTTP requests and print responses for testing CORS
        System.out.println("Testing CORS on path: " + path);
        // Please implement actual HTTP request testing if needed.
    }
}