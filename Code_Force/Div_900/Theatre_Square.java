package Code_Force.Div_900;

import java.util.Scanner;

public class Theatre_Square {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        long n = cin.nextInt();
        long m = cin.nextInt();
        long a = cin.nextInt();

        long res = ((n + a - 1) / a) * ((m + a - 1) / a);
        System.out.println(res);

        cin.close();
    }
}
