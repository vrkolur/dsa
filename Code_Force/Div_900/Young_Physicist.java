package Code_Force.Div_900;

import java.util.Scanner;

public class Young_Physicist {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] t = new int[n][3];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                t[i][j] = cin.nextInt();
                if (i > 0) {
                    t[i][j] = t[i][j] + t[i - 1][j];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (t[n-1][i] != 0) {
                flag = false;
                System.out.println("NO");
                break;
            }
        }
        if (flag)
            System.out.println("YES");
        cin.close();
    }
}

