package ZeroShot.claude;

class Task199 {
    static class Clock {
        private int hours;
        private int minutes;
        
        public Clock(int hours, int minutes) {
            setTime(hours, minutes);
        }
        
        private void setTime(int hours, int minutes) {
            int totalMinutes = hours * 60 + minutes;
            
            // Handle negative time
            while (totalMinutes < 0) {
                totalMinutes += 24 * 60;
            }
            
            totalMinutes = totalMinutes % (24 * 60);
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
        
        public void addMinutes(int minutes) {
            setTime(this.hours, this.minutes + minutes);
        }
        
        public void subtractMinutes(int minutes) {
            addMinutes(-minutes);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Clock)) {
                return false;
            }
            Clock other = (Clock) obj;
            return this.hours == other.hours && this.minutes == other.minutes;
        }
        
        @Override
        public String toString() {
            return String.format("%02d:%02d", hours, minutes);
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Basic clock creation
        Clock clock1 = new Clock(10, 30);
        System.out.println("Test 1: " + clock1); // Should print 10:30
        
        // Test case 2: Adding minutes
        Clock clock2 = new Clock(10, 30);
        clock2.addMinutes(60);
        System.out.println("Test 2: " + clock2); // Should print 11:30
        
        // Test case 3: Subtracting minutes
        Clock clock3 = new Clock(10, 30);
        clock3.subtractMinutes(60);
        System.out.println("Test 3: " + clock3); // Should print 09:30
        
        // Test case 4: Handling overflow
        Clock clock4 = new Clock(23, 45);
        clock4.addMinutes(20);
        System.out.println("Test 4: " + clock4); // Should print 00:05
        
        // Test case 5: Equality test
        Clock clock5a = new Clock(10, 30);
        Clock clock5b = new Clock(10, 30);
        System.out.println("Test 5: " + clock5a.equals(clock5b)); // Should print true
    }
}
