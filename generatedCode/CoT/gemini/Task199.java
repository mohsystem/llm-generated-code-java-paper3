package CoT.gemini;
import java.util.Objects;

class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        add(hours * 60 + minutes);
    }

    public void add(int minutes) {
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.minutes %= 60;
        this.hours %= 24;
        if (this.hours < 0) {
            this.hours += 24;
        }
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours--;
            if (this.hours < 0) {
                this.hours += 24;
            }
        }

    }


    public String toString() {
        String h = String.format("%02d", this.hours);
        String m = String.format("%02d", this.minutes);

        return h + ":" + m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return hours == clock.hours && minutes == clock.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }


    public static void main(String[] args) {
        Clock c1 = new Clock(10, 30);
        System.out.println(c1); // Output: 10:30
        c1.add(30);
        System.out.println(c1); // Output: 11:00

        Clock c2 = new Clock(23, 59);
        c2.add(1);
        System.out.println(c2); // Output: 00:00


        Clock c3 = new Clock(10, 30);
        Clock c4 = new Clock(10, 30);
        System.out.println(c3.equals(c4)); // Output: true


        Clock c5 = new Clock(0, 0);
        c5.add(-1);
        System.out.println(c5); // Output: 23:59


    }
}