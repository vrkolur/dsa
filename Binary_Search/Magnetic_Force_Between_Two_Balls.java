package Binary_Search;

import java.util.Arrays;

//This Problem also known as Aggressive Cows Problem.
// https://leetcode.com/problems/magnetic-force-between-two-balls
public class Magnetic_Force_Between_Two_Balls {

    private int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1] - position[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(position, mid, m)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    /**
     * Checks if it's possible to place m balls in the given positions with a minimum distance of dist.
     *
     * @param position an array of positions where balls can be placed
     * @param dist     the minimum distance required between two balls
     * @param m        the number of balls to be placed
     * @return true if it's possible to place m balls with the given distance, false otherwise
     */
    private boolean check(int[] position, int dist, int m) {
        int cowsCount = 1, last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= dist) {
                cowsCount++;
                last = position[i];
                if (cowsCount >= m) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Magnetic_Force_Between_Two_Balls ob = new Magnetic_Force_Between_Two_Balls();
//        int[] position = {1, 2, 3, 4, 7};
        int[] position = {79,74,57,22};
        int m = 4;
        System.out.println(ob.maxDistance(position, m));
    }
}
