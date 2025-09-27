package ZeroShot.gemini;
class Task17 {
    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split(" ");
        StringBuilder jadenCase = new StringBuilder();
        for (String word : words) {
            jadenCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return jadenCase.toString().trim();
    }

    public static void main(String[] args) {
        Task17 task17 = new Task17();
        System.out.println(task17.toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(task17.toJadenCase("most trees are blue"));
        System.out.println(task17.toJadenCase(""));
        System.out.println(task17.toJadenCase(null));
        System.out.println(task17.toJadenCase("there is no spoon"));


    }
}