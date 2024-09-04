package Binary_Search;

public class Find_the_Smallest_Divisor_Given_a_Threshold {

    private int smallestDivisor(int[] arr, int threshold) {
        int l = 1, r = -1;
        for (int x : arr) if (x > r) r = x;
        int mid;

        while(l<=r){
            mid = (l+r)/2;
            int countThreshold = countValue(arr,mid);
            if(countThreshold<=threshold){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private int countValue(int[] arr, int k){
        int count=0;
        for(int value: arr){
            if(value%k==0) count+= value/k;
            else count = count + value/k +1;
        }
        return count;
    }

    public static void main(String[] args) {
        Find_the_Smallest_Divisor_Given_a_Threshold ob = new Find_the_Smallest_Divisor_Given_a_Threshold();
//        int[] arr = {1, 2, 5, 9};
        int[] arr = {44,22,33,11,1};
        int threshold = 5;

        System.out.println(ob.smallestDivisor(arr, threshold));
    }
}
