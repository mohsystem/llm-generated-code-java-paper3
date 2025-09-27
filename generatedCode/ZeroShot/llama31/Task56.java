package ZeroShot.llama31;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class Task56 {
    public static String generateToken(String username, String secretKey) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 120000)) // 2 minutes
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static void main(String[] args) {
        String secretKey = "supersecret";
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        for (String username : usernames) {
            String token = generateToken(username, secretKey);
            System.out.println("Token for " + username + ": " + token);
        }
    }
}