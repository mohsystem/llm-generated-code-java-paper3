package Vanilla.codestral;
public class Task110 {
    public static boolean isValidUrl(String url) {
        try {
            new java.net.URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidUrl("http://www.google.com")); // true
        System.out.println(isValidUrl("https://github.com/user")); // true
        System.out.println(isValidUrl("ftp://example.com")); // true
        System.out.println(isValidUrl("invalid url")); // false
        System.out.println(isValidUrl("http://invalid..com")); // false
    }
}