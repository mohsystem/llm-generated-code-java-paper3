package Vanilla.gpt4o;
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = (hours + minutes / 60) % 24;
        if (this.hours < 0) this.hours += 24;
        this.minutes = minutes % 60;
        if (this.minutes < 0) this.minutes += 60;
    }

    public Task199 addMinutes(int minutesToAdd) {
        return new Task199(this.hours, this.minutes + minutesToAdd);
    }

    public Task199 subtractMinutes(int minutesToSubtract) {
        return new Task199(this.hours, this.minutes - minutesToSubtract);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task199 clock = (Task199) obj;
        return hours == clock.hours && minutes == clock.minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(10, 30);
        Task199 clock2 = new Task199(10, 30);
        Task199 clock3 = clock1.addMinutes(45);
        Task199 clock4 = clock1.subtractMinutes(75);
        Task199 clock5 = new Task199(23, 59).addMinutes(2);

        System.out.println(clock1.equals(clock2)); // true
        System.out.println(clock3); // 11:15
        System.out.println(clock4); // 08:45
        System.out.println(clock5); // 00:01
        System.out.println(clock1.equals(clock3)); // false
    }
}