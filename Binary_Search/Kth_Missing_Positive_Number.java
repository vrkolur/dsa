package Binary_Search;

public class Kth_Missing_Positive_Number {

    //This is the solution  with O(n) time complexity
    private int findKthPositive(int[] arr, int k) {
        for (int value : arr) {
            if (value <= k)
                k++;
            else break;
        }
        return k;
    }

    public static void main(String[] args) {
        Kth_Missing_Positive_Number ob = new Kth_Missing_Positive_Number();
//        int[] arr = {2, 3, 4, 7, 11};
        int[] arr ={1, 2, 3, 4};
        int k = 2;
        System.out.println(ob.findKthPositive(arr, k));
    }
}
