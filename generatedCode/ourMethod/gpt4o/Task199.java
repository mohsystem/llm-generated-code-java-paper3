package ourMethod.openai;
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = (hours + (minutes / 60)) % 24;
        this.minutes = minutes % 60;
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours = (this.hours - 1 + 24) % 24;
        }
    }

    public void addMinutes(int minutesToAdd) {
        int totalMinutes = this.hours * 60 + this.minutes + minutesToAdd;
        this.hours = (totalMinutes / 60) % 24;
        this.minutes = totalMinutes % 60;
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours = (this.hours - 1 + 24) % 24;
        }
    }

    public void subtractMinutes(int minutesToSubtract) {
        addMinutes(-minutesToSubtract);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task199 other = (Task199) obj;
        return hours == other.hours && minutes == other.minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(14, 45);
        Task199 clock2 = new Task199(14, 45);
        Task199 clock3 = new Task199(23, 59);
        Task199 clock4 = new Task199(0, 0);
        Task199 clock5 = new Task199(12, 30);

        System.out.println(clock1.equals(clock2)); // true
        System.out.println(clock1.equals(clock3)); // false

        clock3.addMinutes(2);
        System.out.println(clock3.toString()); // 00:01

        clock4.subtractMinutes(1);
        System.out.println(clock4.toString()); // 23:59

        clock5.addMinutes(90);
        System.out.println(clock5.toString()); // 14:00
    }
}