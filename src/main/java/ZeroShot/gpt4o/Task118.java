package ZeroShot.gpt4o;
import java.util.regex.Pattern;

public class Task118 {
    
    public static boolean isValidIPAddress(String ip) {
        String ipv4Pattern = 
                "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        
        Pattern pattern = Pattern.compile(ipv4Pattern);
        return pattern.matcher(ip).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidIPAddress("192.168.1.1"));    // true
        System.out.println(isValidIPAddress("255.255.255.255")); // true
        System.out.println(isValidIPAddress("256.256.256.256")); // false
        System.out.println(isValidIPAddress("192.168.1"));       // false
        System.out.println(isValidIPAddress("192.168.1.01"));    // true
    }
}