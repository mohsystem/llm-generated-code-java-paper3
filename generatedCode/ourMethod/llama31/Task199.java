package ourMethod.llama31;
public class Task199 {
    private int hours;
    private int minutes;

    public Task199(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalizeTime();
    }

    public void addMinutes(int minutes) {
        this.minutes += minutes;
        normalizeTime();
    }

    public void subtractMinutes(int minutes) {
        this.minutes -= minutes;
        normalizeTime();
    }

    private void normalizeTime() {
        hours += minutes / 60;
        minutes %= 60;
        if (minutes < 0) {
            minutes += 60;
            hours--;
        }
        hours %= 24;
        if (hours < 0) {
            hours += 24;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task199 other = (Task199) obj;
        return hours == other.hours && minutes == other.minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(12, 30);
        Task199 clock2 = new Task199(12, 30);
        Task199 clock3 = new Task199(13, 0);

        System.out.println("Clock1: " + clock1);
        System.out.println("Clock2: " + clock2);
        System.out.println("Clock3: " + clock3);

        System.out.println("Are Clock1 and Clock2 equal? " + clock1.equals(clock2));
        System.out.println("Are Clock1 and Clock3 equal? " + clock1.equals(clock3));

        clock1.addMinutes(30);
        System.out.println("Clock1 after adding 30 minutes: " + clock1);

        clock1.subtractMinutes(60);
        System.out.println("Clock1 after subtracting 60 minutes: " + clock1);
    }
}