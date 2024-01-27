package Code_Force.Div_900;

import java.util.Scanner;

public class Game_With_Sticks {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int m = cin.nextInt();
        int n = cin.nextInt();
        n = Math.min(m, n);
        if (n % 2 == 0)
            System.out.println("Malvika");
        else
            System.out.println("Akshat");
        cin.close();
    }
}
