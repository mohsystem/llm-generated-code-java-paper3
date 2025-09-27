package ourMethod.gpt4o;
public class Task23 {
    public static int findNb(long m) {
        long volume = 0;
        int n = 0;
        
        while (volume < m) {
            n++;
            volume += (long) n * n * n;
        }
        
        return volume == m ? n : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(findNb(1071225)); // 45
        System.out.println(findNb(91716553919377L)); // -1
        System.out.println(findNb(4183059834009L)); // 2022
        System.out.println(findNb(24723578342962L)); // -1
        System.out.println(findNb(135440716410000L)); // 4824
    }
}