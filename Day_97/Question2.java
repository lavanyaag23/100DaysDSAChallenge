/* GFG — Meeting Rooms II */
import java.util.*;

public class Question2 {

    static int minMeetingRooms(int[] start, int[] end) {
        int n = start.length;

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int rooms = 0;
        int maxRooms = 0;

        while (i < n) {
            if (start[i] < end[j]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            } else {
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }

        System.out.println(minMeetingRooms(start, end));

        sc.close();
    }
}