package Vanilla.llama31;
public class Task199 {
    public static class Clock {
        private int hours;
        private int minutes;

        public Clock(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
            normalize();
        }

        public void addMinutes(int minutes) {
            this.minutes += minutes;
            normalize();
        }

        public void subtractMinutes(int minutes) {
            this.minutes -= minutes;
            normalize();
        }

        private void normalize() {
            hours += minutes / 60;
            minutes %= 60;
            hours %= 24;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Clock clock = (Clock) obj;
            return hours == clock.hours && minutes == clock.minutes;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", hours, minutes);
        }
    }

    public static void main(String[] args) {
        Clock clock1 = new Clock(12, 30);
        Clock clock2 = new Clock(12, 30);
        Clock clock3 = new Clock(12, 31);

        System.out.println(clock1.toString()); // Output: 12:30
        System.out.println(clock2.toString()); // Output: 12:30
        System.out.println(clock3.toString()); // Output: 12:31

        clock1.addMinutes(30);
        System.out.println(clock1.toString()); // Output: 13:00

        clock2.subtractMinutes(60);
        System.out.println(clock2.toString()); // Output: 11:30

        System.out.println(clock1.equals(clock2)); // Output: false
        System.out.println(clock1.equals(clock3)); // Output: false
        System.out.println(clock2.equals(clock3)); // Output: false
        System.out.println(clock1.equals(clock1)); // Output: true
        System.out.println(clock2.equals(clock2)); // Output: true
    }
}