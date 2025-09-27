package ourMethod.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task118 {

    public boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String regex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }



    public static void main(String[] args) {
        Task118 ipValidator = new Task118();

        String[] testCases = {
                "192.168.1.1",
                "256.256.256.256",
                "10.0.0.1",
                "172.16.0.0",
                "2001:0db8:85a3:0000:0000:8a2e:0370:7334"
        };

        for (String testCase : testCases) {
            boolean isValid = ipValidator.isValidIP(testCase);
            System.out.println(testCase + ": " + isValid);
        }
    }
}