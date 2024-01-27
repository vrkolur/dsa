package Code_Force.Div_900;

import java.util.Scanner;

public class Kefa_and_First_Steps {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int prev = cin.nextInt();
        int res = 1, count = 1;
        boolean flag = false;
        if (n < 2) {
            flag = false;
            System.out.println(n);
        } else
            flag = true;
        for (int i = 1; i < n; i++) {
            int curr = cin.nextInt();
            if (curr >= prev) {
                count++;
                res = Math.max(count, res);
                prev = curr;
            } else {
                count = 1;
                prev = curr;
            }
        }
        if (flag)
            System.out.println(res);
        cin.close();
    }
}
