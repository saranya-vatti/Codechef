import java.util.*;
public class Main {
    private static boolean isValid(int[] ratings, int N, int R) {
        if(N<=2) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sortedRatings = ratings.clone();
        Arrays.sort(sortedRatings);
        for(int i=0;i<N;i++) {
            map.put(sortedRatings[i], i);
        }
        int visitedLow = -1;
        int visitedHigh = N;
        for(int i=0;i<N-1;i++) {
            int curr = map.get(ratings[i]);
//            System.out.printf("curr=%d, visitedLow = %d, visitedHigh=%d\n", curr,
//                    visitedLow, visitedHigh);
            if(visitedLow < curr && curr < visitedHigh) {
                if(ratings[i] > ratings[i+1]) {
                    if(map.get(ratings[i+1]) < visitedLow) return false;
                    visitedHigh = curr;
                } else {
                    if(map.get(ratings[i+1]) > visitedHigh) return false;
                    visitedLow = curr;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0) {
            int N = in.nextInt();
            int R= in.nextInt();
            int[] ratings = new int[N];
            for(int i=0;i<N;i++) {
                ratings[i] = in.nextInt();
            }
            System.out.println(isValid(ratings, N, R) ? "YES" : "NO");
        }
    }
}