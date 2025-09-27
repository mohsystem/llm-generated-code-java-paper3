package ourMethod.gemini;
import java.util.Objects;

class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        add(hours * 60 + minutes);
    }


    public void add(int minutes) {
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.hours %= 24;
        this.minutes %= 60;
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours--;
            if (this.hours < 0) {
                this.hours += 24;
            }
        }
    }

    public void subtract(int minutes) {
        add(-minutes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task199 clock = (Task199) obj;
        return hours == clock.hours && minutes == clock.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }


    public String toString() {
        String h = String.format("%02d", hours);
        String m = String.format("%02d", minutes);
        return h + ":" + m;
    }


    public static void main(String[] args) {
        Task199 clock1 = new Task199(10, 30);
        System.out.println(clock1); // Output: 10:30
        clock1.add(20);
        System.out.println(clock1); // Output: 10:50

        Task199 clock2 = new Task199(23, 50);
        System.out.println(clock2); // Output: 23:50
        clock2.add(20);
        System.out.println(clock2); // Output: 00:10

        Task199 clock3 = new Task199(10, 30);
        System.out.println(clock3.equals(clock1)); // false

        Task199 clock4 = new Task199(10, 30);
        clock4.add(150);
        System.out.println(clock4);

        Task199 clock5 = new Task199(1, 30);
        clock5.subtract(90);
        System.out.println(clock5);

    }
}