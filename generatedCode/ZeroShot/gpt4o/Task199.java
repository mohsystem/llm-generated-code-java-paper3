package ZeroShot.openai;
public class Task199 {
    private int minutes;

    public Task199(int hours, int minutes) {
        this.minutes = (hours * 60 + minutes) % 1440;
        if (this.minutes < 0) {
            this.minutes += 1440;
        }
    }

    public Task199 addMinutes(int minutesToAdd) {
        return new Task199(0, this.minutes + minutesToAdd);
    }

    public Task199 subtractMinutes(int minutesToSubtract) {
        return new Task199(0, this.minutes - minutesToSubtract);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task199)) return false;
        Task199 other = (Task199) obj;
        return this.minutes == other.minutes;
    }

    @Override
    public String toString() {
        int hours = (minutes / 60) % 24;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(10, 0);
        Task199 clock2 = clock1.addMinutes(150);
        Task199 clock3 = clock1.subtractMinutes(60);
        Task199 clock4 = new Task199(12, 30);
        Task199 clock5 = new Task199(10, 0);

        System.out.println(clock1); // 10:00
        System.out.println(clock2); // 12:30
        System.out.println(clock3); // 09:00
        System.out.println(clock1.equals(clock5)); // true
        System.out.println(clock1.equals(clock4)); // false
    }
}