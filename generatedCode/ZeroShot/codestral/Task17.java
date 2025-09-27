package ZeroShot.codestral;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals(""))
            return null;

        String[] words = phrase.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("i'm grateful for every single thing that i've been blessed with"));
        System.out.println(toJadenCase("don't trust nobody and don't be afraid to use your head"));
        System.out.println(toJadenCase("it's easier to ask for forgiveness than it is to get permission"));
        System.out.println(toJadenCase(""));
    }
}