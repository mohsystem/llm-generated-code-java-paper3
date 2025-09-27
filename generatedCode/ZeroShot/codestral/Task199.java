package ZeroShot.codestral;
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = (hours + minutes / 60) % 24;
        this.minutes = minutes % 60;
    }

    public void addMinutes(int minutes) {
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.hours %= 24;
        this.minutes %= 60;
    }

    public void subtractMinutes(int minutes) {
        this.minutes -= minutes;
        if (this.minutes < 0) {
            this.hours += (this.minutes / 60) - 1;
            this.minutes = 60 + (this.minutes % 60);
        }
        this.hours %= 24;
        if (this.hours < 0) this.hours = 24 + this.hours;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task199 clock = (Task199) obj;
        return hours == clock.hours && minutes == clock.minutes;
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(12, 30);
        Task199 clock2 = new Task199(12, 30);
        Task199 clock3 = new Task199(13, 30);

        System.out.println(clock1.equals(clock2)); // true
        System.out.println(clock1.equals(clock3)); // false

        clock1.addMinutes(30);
        System.out.println(clock1.equals(clock3)); // true

        clock1.subtractMinutes(60);
        System.out.println(clock1.equals(clock2)); // true
    }
}