package ZeroShot.llama31;
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
            int totalMinutes = hours * 60 + minutes;
            hours = totalMinutes / 60 % 24;
            minutes = totalMinutes % 60;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Clock other = (Clock) obj;
            return hours == other.hours && minutes == other.minutes;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", hours, minutes);
        }

        public static void main(String[] args) {
            Clock clock1 = new Clock(12, 30);
            Clock clock2 = new Clock(12, 30);
            Clock clock3 = new Clock(12, 45);

            System.out.println(clock1.toString()); // Output: 12:30
            clock1.addMinutes(15);
            System.out.println(clock1.toString()); // Output: 12:45
            clock1.subtractMinutes(15);
            System.out.println(clock1.toString()); // Output: 12:30

            System.out.println(clock1.equals(clock2)); // Output: true
            System.out.println(clock1.equals(clock3)); // Output: false
        }
    }
}