package Code_Force.Div_900;

import java.util.Arrays;
import java.util.Scanner;

public class Puzzles {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = cin.nextInt();
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE-98765;
        for (int k = 0; k <= m - n; k++) {
            res = Math.min(res, arr[k + n - 1] - arr[k]);
        }
        if(res==Integer.MAX_VALUE-98765)
            System.out.println(0);
        else 
            System.out.println(res);
        cin.close();
    }
}
