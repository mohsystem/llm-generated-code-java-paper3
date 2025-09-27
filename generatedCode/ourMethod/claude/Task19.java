package ourMethod.claude;

public class Task19 {
    public String spinWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                result.append(new StringBuilder(words[i]).reverse());
            } else {
                result.append(words[i]); 
            }
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Task19 task = new Task19();
        
        // Test cases
        System.out.println(task.spinWords("Hey fellow warriors")); // Hey wollef sroirraw
        System.out.println(task.spinWords("This is a test")); // This is a test
        System.out.println(task.spinWords("This is another test")); // This is rehtona test
        System.out.println(task.spinWords("Welcome")); // emocleW
        System.out.println(task.spinWords("")); // ""
    }
}
