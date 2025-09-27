package ourMethod.gpt4o;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Task120 {
    public String displayInputOnWebPage(String userInput) {
        return Jsoup.clean(userInput, Whitelist.basic());
    }

    public static void main(String[] args) {
        Task120 task = new Task120();
        System.out.println(task.displayInputOnWebPage("<script>alert('test')</script>")); // XSS attempt
        System.out.println(task.displayInputOnWebPage("<b>Hello</b>")); // Bold text
        System.out.println(task.displayInputOnWebPage("Plain text")); // Plain text
        System.out.println(task.displayInputOnWebPage("<img src='x' onerror='alert(1)'>")); // XSS attempt
        System.out.println(task.displayInputOnWebPage("<a href='http://example.com'>Link</a>")); // Link
    }
}