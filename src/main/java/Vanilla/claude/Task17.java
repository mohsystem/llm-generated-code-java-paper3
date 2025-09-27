package Vanilla.claude;

public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals("")) return null;
        
        String[] words = phrase.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() > 0) {
                result.append(Character.toUpperCase(words[i].charAt(0)))
                      .append(words[i].substring(1));
            }
            if(i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("school is the tool to brainwash the youth"));
        System.out.println(toJadenCase("if everybody in the world dropped out of school we would have a much more intelligent society"));
        System.out.println(toJadenCase(""));
        System.out.println(toJadenCase("trees are never sad look at them every once in awhile they're quite beautiful"));
    }
}
