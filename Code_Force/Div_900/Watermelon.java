package Code_Force.Div_900;

import java.util.Scanner;

public class Watermelon {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        if (n>2 && n%2==0)
            System.out.println("YES");
        else
            System.out.println("NO");
        cin.close();
    }
}
