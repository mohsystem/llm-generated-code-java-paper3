package CoT.llama31;
public class Task199 {
    public static class Clock {
        private int minutes;

        public Clock(int minutes) {
            this.minutes = minutes;
        }

        public void addMinutes(int minutes) {
            this.minutes = (this.minutes + minutes) % 1440; // 1440 minutes in a day
        }

        public void subtractMinutes(int minutes) {
            this.minutes = (this.minutes - minutes + 1440) % 1440; // Handle negative values
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Clock other = (Clock) obj;
            return minutes == other.minutes;
        }

        @Override
        public String toString() {
            int hours = minutes / 60;
            int mins = minutes % 60;
            return String.format("%02d:%02d", hours, mins);
        }
    }

    public static void main(String[] args) {
        Clock clock1 = new Clock(120); // 2:00
        Clock clock2 = new Clock(120); // 2:00
        Clock clock3 = new Clock(121); // 2:01

        System.out.println("Clock1: " + clock1);
        System.out.println("Clock2: " + clock2);
        System.out.println("Clock3: " + clock3);

        clock1.addMinutes(30);
        System.out.println("Clock1 after adding 30 minutes: " + clock1);

        clock2.subtractMinutes(30);
        System.out.println("Clock2 after subtracting 30 minutes: " + clock2);

        System.out.println("Are Clock1 and Clock2 equal? " + clock1.equals(clock2));
        System.out.println("Are Clock1 and Clock3 equal? " + clock1.equals(clock3));
    }
}