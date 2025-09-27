package ZeroShot.codestral;
public class Task126 {
    public static void main(String[] args) {
        redirectUser("page1");
        redirectUser("page2");
        redirectUser("unknown");
    }

    public static void redirectUser(String userInput) {
        switch (userInput) {
            case "page1":
                System.out.println("Redirecting to page1");
                break;
            case "page2":
                System.out.println("Redirecting to page2");
                break;
            default:
                System.out.println("Redirecting to default page");
        }
    }
}