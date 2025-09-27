package Vanilla.claude;

public class Task126 {
    public static String getRedirectPage(int choice) {
        switch(choice) {
            case 1:
                return "home.html";
            case 2: 
                return "about.html";
            case 3:
                return "contact.html"; 
            case 4:
                return "products.html";
            default:
                return "404.html";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getRedirectPage(1)); // Should print home.html
        System.out.println(getRedirectPage(2)); // Should print about.html
        System.out.println(getRedirectPage(3)); // Should print contact.html
        System.out.println(getRedirectPage(4)); // Should print products.html
        System.out.println(getRedirectPage(5)); // Should print 404.html
    }
}
