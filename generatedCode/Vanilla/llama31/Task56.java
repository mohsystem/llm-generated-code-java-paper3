package Vanilla.llama31;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class Task56 {
    public static String generateToken(String username, String secret, int expireTime) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(username);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + expireTime * 1000));
        builder.signWith(SignatureAlgorithm.HS256, secret);
        return builder.compact();
    }

    public static void main(String[] args) {
        String secret = "supersecret";
        int expireTime = 120; // 2 minutes
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        for (String username : usernames) {
            String token = generateToken(username, secret, expireTime);
            System.out.println("Token for " + username + ": " + token);
        }
    }
}