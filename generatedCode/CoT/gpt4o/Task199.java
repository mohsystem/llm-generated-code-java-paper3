package CoT.openai;
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = (hours % 24 + 24) % 24;
        this.minutes = (minutes % 60 + 60) % 60;
        addMinutes((hours * 60) + minutes);
    }

    public void addMinutes(int minutesToAdd) {
        int totalMinutes = this.hours * 60 + this.minutes + minutesToAdd;
        this.hours = (totalMinutes / 60) % 24;
        this.minutes = totalMinutes % 60;
    }

    public void subtractMinutes(int minutesToSubtract) {
        addMinutes(-minutesToSubtract);
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
        Task199 clock1 = new Task199(10, 0);
        Task199 clock2 = new Task199(9, 60);
        Task199 clock3 = new Task199(23, 59);
        Task199 clock4 = new Task199(0, 1);
        Task199 clock5 = new Task199(24, 0);

        clock1.addMinutes(20);
        clock2.subtractMinutes(60);
        clock3.addMinutes(2);
        clock4.subtractMinutes(2);
        clock5.addMinutes(-1440);

        System.out.println(clock1); // Should print 10:20
        System.out.println(clock2); // Should print 09:00
        System.out.println(clock3); // Should print 00:01
        System.out.println(clock4); // Should print 23:59
        System.out.println(clock5); // Should print 00:00

        System.out.println(clock1.equals(clock2)); // Should print false
        System.out.println(clock2.equals(new Task199(9, 0))); // Should print true
    }
}