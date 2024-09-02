package Binary_Search;

public class Lower_Upper_Bound_withDuplicates {

    private int lowerBound(int[] arr, int key) {
        int l = 0, r = arr.length - 1, mid = -1, ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if(arr[mid]<=key){
                l=mid+1;
                ans=mid;
            }else{
                r=mid-1;
            }
        }
        return r;
    }

    private int upperBound(int[] arr, int key) {
        int l = 0, r = arr.length - 1, mid = -1, ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if(arr[mid]>=key){
                r=mid-1;
                ans=mid;
            }else{
                l=mid+1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Lower_Upper_Bound_withDuplicates ob = new Lower_Upper_Bound_withDuplicates();
        int[] arr = { 1, 2, 3, 3, 4, 5, 5, 8, 8, 10, 11, 12 };
        System.out.println(ob.lowerBound(arr, 6));
        System.out.println(ob.upperBound(arr, 9));
    }
}
