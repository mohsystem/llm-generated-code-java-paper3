package Vanilla.codestral;
// Java
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = (hours + minutes / 60) % 24;
        this.minutes = minutes % 60;
    }

    public void addMinutes(int minutes) {
        this.hours = (this.hours + (this.minutes + minutes) / 60) % 24;
        this.minutes = (this.minutes + minutes) % 60;
    }

    public void subtractMinutes(int minutes) {
        this.hours = (this.hours + (this.minutes - minutes) / 60) % 24;
        this.minutes = (this.minutes - minutes) % 60;
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours--;
            if (this.hours < 0) this.hours += 24;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task199 task199 = (Task199) obj;
        return hours == task199.hours && minutes == task199.minutes;
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(10, 30);
        Task199 clock2 = new Task199(10, 30);
        Task199 clock3 = new Task199(11, 30);
        System.out.println(clock1.equals(clock2)); // true
        System.out.println(clock1.equals(clock3)); // false
        clock1.addMinutes(60);
        System.out.println(clock1.equals(clock3)); // true
        clock1.subtractMinutes(120);
        System.out.println(clock1.equals(clock2)); // true
    }
}