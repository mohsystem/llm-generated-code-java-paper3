package CoT.claude;

public class Task199 {
    static class Clock {
        private int hours;
        private int minutes;
        
        public Clock(int hours, int minutes) {
            setTime(hours, minutes);
        }
        
        private void setTime(int hours, int minutes) {
            int totalMinutes = ((hours * 60 + minutes) % (24 * 60));
            if (totalMinutes < 0) {
                totalMinutes += 24 * 60;
            }
            this.hours = (totalMinutes / 60) % 24;
            this.minutes = totalMinutes % 60;
        }
        
        public void addMinutes(int minutes) {
            setTime(hours, this.minutes + minutes);
        }
        
        public void subtractMinutes(int minutes) {
            addMinutes(-minutes);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Clock)) return false;
            Clock other = (Clock) obj;
            return hours == other.hours && minutes == other.minutes;
        }
        
        @Override
        public String toString() {
            return String.format("%02d:%02d", hours, minutes);
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Basic clock creation
        Clock clock1 = new Clock(8, 0);
        System.out.println("Test 1: " + clock1); // Should print 08:00
        
        // Test case 2: Adding minutes
        Clock clock2 = new Clock(11, 9);
        clock2.addMinutes(200);
        System.out.println("Test 2: " + clock2); // Should print 14:29
        
        // Test case 3: Subtracting minutes
        Clock clock3 = new Clock(10, 30);
        clock3.subtractMinutes(90);
        System.out.println("Test 3: " + clock3); // Should print 09:00
        
        // Test case 4: Equality test
        Clock clock4a = new Clock(23, 59);
        Clock clock4b = new Clock(23, 59);
        System.out.println("Test 4: " + clock4a.equals(clock4b)); // Should print true
        
        // Test case 5: Handling negative values
        Clock clock5 = new Clock(-1, -40);
        System.out.println("Test 5: " + clock5); // Should print 22:20
    }
}
