package Binary_Search;

public class MinimizeMaxDistanceToGasStation {

    private double minimizeMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n];
        for(int gasStation = 0; gasStation <=k; gasStation++) {
             double maxSection = -1;
            int maxInd = -1;
            for(int i=0;i<n-1;i++){
                 double diff = arr[i+1] - arr[i];
                 double sectionLength = diff / (double)(howMany[i]+1);
                 if(sectionLength > maxSection){
                     maxSection = sectionLength;
                     maxInd = i;
                 }
            }
            howMany[maxInd]++;
        }
        double maxAns = -1;
        for(int i=0;i<n-1;i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff / (double)howMany[i];
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        MinimizeMaxDistanceToGasStation ob = new MinimizeMaxDistanceToGasStation();
        int[] arr = { 1,13,17,23 };
        int k = 5;
        System.out.println(ob.minimizeMaxDistance(arr, k));
    }
}
