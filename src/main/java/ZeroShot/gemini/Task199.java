package ZeroShot.gemini;
import java.util.Objects;

class Task199 {

    static class Clock {
        private int minutes;

        public Clock(int hours, int minutes) {
            this.minutes = (hours * 60 + minutes) % 1440;
            if (this.minutes < 0) {
                this.minutes += 1440;
            }
        }

        public void add(int minutes) {
            this.minutes = (this.minutes + minutes) % 1440;
            if (this.minutes < 0) {
                this.minutes += 1440;
            }
        }

        public void subtract(int minutes) {
            add(-minutes);
        }

        public String toString() {
            int hours = (minutes / 60) % 24;
            int mins = minutes % 60;
            return String.format("%02d:%02d", hours, mins);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Clock clock = (Clock) o;
            return minutes == clock.minutes;
        }

        @Override
        public int hashCode() {
            return Objects.hash(minutes);
        }
    }

    public static void main(String[] args) {
        Clock clock1 = new Clock(10, 30);
        Clock clock2 = new Clock(10, 30);
        System.out.println(clock1.equals(clock2)); // true

        clock1.add(30);
        System.out.println(clock1); // 11:00

        clock1.subtract(60);
        System.out.println(clock1); // 10:00

        Clock clock3 = new Clock(23, 59);
        clock3.add(1);
        System.out.println(clock3); // 00:00


        Clock clock4 = new Clock(0, 0);
        clock4.subtract(1);
        System.out.println(clock4); // 23:59
    }
}