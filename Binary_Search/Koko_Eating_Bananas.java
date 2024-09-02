package Binary_Search;

public class Koko_Eating_Bananas {

    private int minEatingSpeed(int[] arr, int h) {
        int l = 1, r = -1;
        for (int x : arr)
            if (x > r) r = x;
        int mid;
        while (l <= r) {
            mid = l + (r-l)/ 2;
            int totalHr = countHours(arr, mid);
            if ((long)totalHr <= (long)h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int countHours(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % k == 0) count += arr[i] / k;
            else count = count + arr[i] / k + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Koko_Eating_Bananas ob = new Koko_Eating_Bananas();
        int[] arr = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(ob.minEatingSpeed(arr, h));
    }
}
