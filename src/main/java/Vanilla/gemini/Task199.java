package Vanilla.gemini;
class Task199 {
    private int minutes;

    public Task199(int hours, int minutes) {
        this.minutes = (hours * 60 + minutes) % (24 * 60);
        if (this.minutes < 0) {
            this.minutes += 24 * 60;
        }
    }

    public Task199(int minutes) {
        this.minutes = minutes % (24 * 60);
        if (this.minutes < 0) {
            this.minutes += 24 * 60;
        }
    }



    public void add(int minutes) {
        this.minutes = (this.minutes + minutes) % (24 * 60);
        if (this.minutes < 0) {
            this.minutes += 24 * 60;
        }
    }

    public void subtract(int minutes) {
        this.minutes = (this.minutes - minutes) % (24 * 60);
        if (this.minutes < 0) {
            this.minutes += 24 * 60;
        }
    }

    public int getHours() {
        return (minutes / 60) % 24;
    }

    public int getMinutes() {
        return minutes % 60;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task199 clock = (Task199) obj;
        return minutes == clock.minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", getHours(), getMinutes());
    }

    public static void main(String[] args) {
        Task199 clock1 = new Task199(10, 30);
        clock1.add(30);
        System.out.println(clock1); // Output: 11:00

        Task199 clock2 = new Task199(23, 59);
        clock2.add(1);
        System.out.println(clock2); // Output: 00:00

        Task199 clock3 = new Task199(0, 0);
        clock3.subtract(1);
        System.out.println(clock3); // Output: 23:59

        Task199 clock4 = new Task199(12, 0);
        Task199 clock5 = new Task199(0, 720); // 12 hours * 60 = 720 minutes

        System.out.println(clock4.equals(clock5)); //true
        System.out.println(clock4); //12:00
        System.out.println(clock5); //12:00


    }
}