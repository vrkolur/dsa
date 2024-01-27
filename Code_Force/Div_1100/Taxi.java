package Code_Force.Div_1100;

import java.util.Scanner;

//Specia Problem
public class Taxi {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] count = new int[5];
        for (int i = 0; i < n; i++) {
            int j = cin.nextInt();
            count[j]++;
        }
        int res = count[4] + count[3] + count[2] / 2;
        count[1] -= count[3];
        if (count[2] % 2 == 1) {
            res += 1;
            count[1] -= 2;
        }
        if (count[1] > 0) {
            res += (count[1] + 3) / 4;
        }
        System.out.println(res);
        cin.close();
    }
}
