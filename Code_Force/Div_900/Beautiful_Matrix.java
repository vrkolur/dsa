package Code_Force.Div_900;

import java.util.Scanner;

public class Beautiful_Matrix {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        // int[][] grid=new int[5][5];
        int r = 0, c = 0;
        int num = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                num = cin.nextInt();
                if (num == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        int res = Math.abs(2 - r) + Math.abs(2 - c);
        System.out.println(res);
        cin.close();
    }
}
