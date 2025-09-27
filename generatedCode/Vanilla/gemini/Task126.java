package Vanilla.gemini;
import java.util.Scanner;

class Task126 {
    public String redirect(String input) {
        switch (input) {
            case "home":
                return "/home";
            case "about":
                return "/about";
            case "contact":
                return "/contact";
            default:
                return "/404";
        }
    }

    public static void main(String[] args) {
        Task126 task = new Task126();
        Scanner scanner = new Scanner(System.in);

        System.out.println(task.redirect("home"));
        System.out.println(task.redirect("about"));
        System.out.println(task.redirect("contact"));
        System.out.println(task.redirect("blog"));
        System.out.println(task.redirect("products"));


    }
}