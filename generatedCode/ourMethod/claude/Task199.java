package ourMethod.claude;

public class Task199 {
    static class Clock {
        private int hours;
        private int minutes;
        
        public Clock(int hours, int minutes) {
            this.setTime(hours, minutes);
        }
        
        private void setTime(int hours, int minutes) {
            int totalMinutes = hours * 60 + minutes;
            
            // Handle negative time
            while (totalMinutes < 0) {
                totalMinutes += 24 * 60;
            }
            
            totalMinutes = totalMinutes % (24 * 60);
            this.hours = (totalMinutes / 60) % 24;
            this.minutes = totalMinutes % 60;
        }
        
        public void addMinutes(int minutes) {
            setTime(this.hours, this.minutes + minutes);
        }
        
        public void subtractMinutes(int minutes) {
            setTime(this.hours, this.minutes - minutes);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
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
        // Test case 1: Basic initialization
        Clock clock1 = new Clock(8, 0);
        System.out.println("Test 1: " + clock1); // Should print 08:00
        
        // Test case 2: Add minutes
        Clock clock2 = new Clock(8, 0);
        clock2.addMinutes(30);
        System.out.println("Test 2: " + clock2); // Should print 08:30
        
        // Test case 3: Subtract minutes
        Clock clock3 = new Clock(8, 0);
        clock3.subtractMinutes(30);
        System.out.println("Test 3: " + clock3); // Should print 07:30
        
        // Test case 4: Equality test
        Clock clock4a = new Clock(9, 30);
        Clock clock4b = new Clock(9, 30);
        System.out.println("Test 4: " + clock4a.equals(clock4b)); // Should print true
        
        // Test case 5: Wrap around midnight
        Clock clock5 = new Clock(23, 45);
        clock5.addMinutes(30);
        System.out.println("Test 5: " + clock5); // Should print 00:15
    }
}
