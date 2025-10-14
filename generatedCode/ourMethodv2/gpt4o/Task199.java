package ourMethodv2.gpt4o;
public class Task199 {
    public static class Clock {
        private int hours;
        private int minutes;

        public Clock(int hours, int minutes) {
            this.hours = (hours + minutes / 60) % 24;
            this.minutes = minutes % 60;
            if (this.minutes < 0) {
                this.minutes += 60;
                this.hours = (this.hours - 1 + 24) % 24;
            }
            if (this.hours < 0) {
                this.hours += 24;
            }
        }

        public void addMinutes(int minutesToAdd) {
            int totalMinutes = this.hours * 60 + this.minutes + minutesToAdd;
            this.hours = ((totalMinutes / 60) % 24 + 24) % 24;
            this.minutes = (totalMinutes % 60 + 60) % 60;
        }

        public void subtractMinutes(int minutesToSubtract) {
            addMinutes(-minutesToSubtract);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Clock clock = (Clock) obj;
            return hours == clock.hours && minutes == clock.minutes;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", hours, minutes);
        }
    }

    public static void main(String[] args) {
        Clock clock1 = new Clock(10, 30);
        Clock clock2 = new Clock(25, 90);
        Clock clock3 = new Clock(10, 30);
        Clock clock4 = new Clock(-2, -90);
        Clock clock5 = new Clock(23, 60);

        System.out.println(clock1); // 10:30
        System.out.println(clock2); // 02:30
        System.out.println(clock1.equals(clock3)); // true
        System.out.println(clock4); // 21:30
        System.out.println(clock5); // 00:00

        clock1.addMinutes(90);
        System.out.println(clock1); // 12:00

        clock2.subtractMinutes(150);
        System.out.println(clock2); // 00:00
    }
}