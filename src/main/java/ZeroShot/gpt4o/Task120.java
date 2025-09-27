package ZeroShot.gpt4o;
public class Task120 {
    public static void main(String[] args) {
        System.out.println(displayInput("Hello, World!"));
        System.out.println(displayInput("<script>alert('XSS')</script>"));
        System.out.println(displayInput("Welcome to the site"));
        System.out.println(displayInput("John & Jane's Adventure"));
        System.out.println(displayInput("<b>Bold Text</b>"));
    }

    public static String displayInput(String input) {
        return escapeHtml(input);
    }

    private static String escapeHtml(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder escaped = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<':
                    escaped.append("&lt;");
                    break;
                case '>':
                    escaped.append("&gt;");
                    break;
                case '&':
                    escaped.append("&amp;");
                    break;
                case '"':
                    escaped.append("&quot;");
                    break;
                case '\'':
                    escaped.append("&#39;");
                    break;
                default:
                    escaped.append(c);
            }
        }
        return escaped.toString();
    }
}