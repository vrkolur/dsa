package Binary_Search;

public class Square_Root {

    private int mySqrt(int x) {
        if(x<2) return x;

        int l=0,r=x,mid=-1;

        while(l<=r){
            mid = l+ (r-l)/2;
            if((long)mid*mid > (long)x)
                r=mid-1;
            else if (mid*mid==x) return mid;
            else l=mid+1;
        }
        return r;
    }

    public static void main(String[] args) {
        Square_Root ob = new Square_Root();
        int n = 2147395600;
        System.out.println(ob.mySqrt(n));
    }
}
