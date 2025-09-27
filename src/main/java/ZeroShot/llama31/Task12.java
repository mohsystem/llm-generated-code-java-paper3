package ZeroShot.llama31;
public class Task12 {
    public static String high(String str) {
        String[] wordArray = str.split(" ");
        int highestScore = 0;
        String highestScoreWord = wordArray[0];

        for (String word : wordArray) {
            int currentWordScore = 0;
            for (char letter : word.toCharArray()) {
                currentWordScore += letter - 'a' + 1;
            }
            if (currentWordScore > highestScore) {
                highestScore = currentWordScore;
                highestScoreWord = word;
            }
        }
        return highestScoreWord;
    }

    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud")); // taxi
        System.out.println(high("what time are we climbing up the volcano")); // volcano
        System.out.println(high("take me to semynak")); // semynak
        System.out.println(high("aa b")); // aa
        System.out.println(high("bb d")); // bb
    }
}