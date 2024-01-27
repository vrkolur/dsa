package Code_Force.Div_900;

import java.util.Scanner;

public class Next_Round {

    private int solve() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();

        int a=0;
        for (int i = 0; i < k; i++) {
            a = cin.nextInt();
            if (a == 0) {
                System.out.println(i);
                cin.close();
                return 0;
            }
        }
        int b=0;
        for (int i = k; i < n; i++) {
            b = cin.nextInt();
            if (a != b) {
                System.out.println(i);
                cin.close();
                return 0;
            }
        }
        System.out.println(n);
        cin.close();
        return 0;
    }

    public static void main(String[] args) {
        Next_Round ob = new Next_Round();
        Scanner cin = new Scanner(System.in);
        cin.close();
        ob.solve();
    }
}
