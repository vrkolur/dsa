package Dynamic_Programming;

public class Subset_Sum {

    // This is the recursive approach
    private boolean subset(int idx, int target, int[] nums) {
        if (target == 0)
            return true;
        if (idx == 0)
            return (target == nums[0]);
        // Not take it
        boolean notTake = subset(idx - 1, target, nums);
        boolean take = false;
        if (target >= nums[idx]) {
            take = subset(idx - 1, target - nums[idx], nums) || subset(idx - 1, target, nums);
        }

        return (notTake || take);
    }

    //Do the memotization approach on your own 


    //Tabulation approach is as follows.
    private boolean subset(int[] nums,int target){
        int n=nums.length;
        boolean[][] t=new boolean[n+1][target+1];

        // base cases
        for(int i=1;i<=target;i++){
            t[0][i]=false;
        }
        for(int i=0;i<=n;i++){
            t[i][0]=true;
        }

        //Now start from i=1 and target=1 till n and target.
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j)
                    t[i][j]=t[i-1][j-nums[i-1]] || t[i-1][j];
                else 
                    t[i][j]=t[i-1][j];
            }
        }
        return t[n][target];
    }

    public static void main(String[] args) {
        Subset_Sum ob = new Subset_Sum();
        int[] arr = { 2, 3, 7, 12, 10 };
        int sum = 14;
        System.out.println(ob.subset(arr.length - 1, sum, arr));
        System.out.println(ob.subset(arr, sum));
        System.gc();
    }
}
