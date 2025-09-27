package CoT.codestral;
public class Task1 {
    public static int countPeople(int[][] busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }
}