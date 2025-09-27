package Vanilla.claude;

class Task199 {
    static class Clock {
        private int hours;
        private int minutes;

        public Clock(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
            normalize();
        }

        private void normalize() {
            while (minutes < 0) {
                minutes += 60;
                hours--;
            }
            while (minutes >= 60) {
                minutes -= 60;
                hours++;
            }
            while (hours < 0) {
                hours += 24;
            }
            hours = hours % 24;
        }

        public void addMinutes(int minutesToAdd) {
            minutes += minutesToAdd;
            normalize();
        }

        public void subtractMinutes(int minutesToSubtract) {
            minutes -= minutesToSubtract;
            normalize();
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
        Clock clock2 = new Clock(8, 0);
        clock2.addMinutes(65);
        System.out.println("Test 2: " + clock2); // Should print 09:05

        // Test case 3: Subtracting minutes
        Clock clock3 = new Clock(8, 0);
        clock3.subtractMinutes(65);
        System.out.println("Test 3: " + clock3); // Should print 06:55

        // Test case 4: Equality check
        Clock clock4a = new Clock(14, 30);
        Clock clock4b = new Clock(14, 30);
        System.out.println("Test 4: " + clock4a.equals(clock4b)); // Should print true

        // Test case 5: Wrapping around midnight
        Clock clock5 = new Clock(23, 45);
        clock5.addMinutes(30);
        System.out.println("Test 5: " + clock5); // Should print 00:15
    }
}
