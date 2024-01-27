package Code_Force.Div_1100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Sike Prblem
public class Dragons {

    private static void sort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1,
                    final int[] entry2) {
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int s = cin.nextInt();
        int n = cin.nextInt();
        boolean flag = false;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i][0] < s) {
                s += arr[i][1];
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");

        cin.close();
    }
}
