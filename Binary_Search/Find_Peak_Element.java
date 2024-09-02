package Binary_Search;

public class Find_Peak_Element {

    // With one Peak
    private int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        //What if first and last element are the peek
        if (arr[0] > arr[1]) return arr[0];
        if (arr[n - 1] > arr[n - 2]) return arr[n - 1];

        int l = 1, r = n - 2;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) return arr[mid];
            //Left SIde
            if (arr[mid - 1] < arr[mid]) l = mid + 1;
            else r = mid - 1;
        }
        //Hypothetical return statement.
        return -1;
    }

    public static void main(String[] args) {
        Find_Peak_Element ob = new Find_Peak_Element();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
//        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(ob.findPeakElement(arr));
    }
}
