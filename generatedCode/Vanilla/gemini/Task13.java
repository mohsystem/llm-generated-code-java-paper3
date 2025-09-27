package Vanilla.gemini;
class Task13 {
    public boolean isValidWalk(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int x = 0, y = 0;
        for (char c : walk) {
            switch (c) {
                case 'n': y++; break;
                case 's': y--; break;
                case 'e': x++; break;
                case 'w': x--; break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Task13 task13 = new Task13();
        System.out.println(task13.isValidWalk(new char[]{'n','s','n','s','n','s','n','s','n','s'})); // true
        System.out.println(task13.isValidWalk(new char[]{'w','e','w','e','w','e','w','e','w','e','w','e'})); // false
        System.out.println(task13.isValidWalk(new char[]{'w'})); // false
        System.out.println(task13.isValidWalk(new char[]{'n','n','n','s','n','s','n','s','n','s'})); // false
        System.out.println(task13.isValidWalk(new char[]{'e','w','e','w','n','s','n','s','e','w'})); // true

    }
}