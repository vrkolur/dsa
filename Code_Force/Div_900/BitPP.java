package Code_Force.Div_900;

import java.util.Scanner;

public class BitPP {

    private int call() {
        Scanner cin = new Scanner(System.in);
        int n1 = cin.nextInt();
        int n=0;
        for (int i = 0; i < n1; i++) {
            String opr = cin.next();
            if (opr.charAt(0) == '+' || opr.charAt(1) == '+'){
                n++;
                // System.out.println("Hello");
            }
            else
                n--;
        }
        cin.close();
        return n;
    }

    public static void main(String[] args) {
        BitPP ob = new BitPP();
        int res = ob.call();
        System.out.println(res);
    }
}
