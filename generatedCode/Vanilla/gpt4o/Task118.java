package Vanilla.openai;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task118 {
    public static boolean validateIPAddress(String ipAddress) {
        String ipPattern = 
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" + 
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "192.168.1.1",
            "255.255.255.255",
            "256.256.256.256",
            "192.168.1",
            "abc.def.ghi.jkl"
        };
        
        for (String ip : testCases) {
            System.out.println(ip + " is valid: " + validateIPAddress(ip));
        }
    }
}