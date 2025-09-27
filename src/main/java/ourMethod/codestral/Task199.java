package ourMethod.codestral;
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    public void add(int minutes) {
        this.minutes += minutes;
        normalize();
    }

    public void subtract(int minutes) {
        this.minutes -= minutes;
        normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task199 clock = (Task199) o;
        return hours == clock.hours &&
                minutes == clock.minutes;
    }

    private void normalize() {
        while (minutes < 0) {
            minutes += 60;
            hours--;
        }
        while (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
        hours = (hours % 24 + 24) % 24;
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(10, 30);
        Task199 clock2 = new Task199(10, 30);
        Task199 clock3 = new Task199(11, 30);

        clock1.add(30);
        clock2.subtract(15);

        System.out.println(clock1.equals(clock2)); // true
        System.out.println(clock1.equals(clock3)); // false
    }
}