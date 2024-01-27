package Code_Force.Div_900;

import java.util.Scanner;

public class Domino_piling {
    
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int m=cin.nextInt();
        int n=cin.nextInt();
        long res=m*n;
        System.out.println(res/2);
        cin.close();
    }
}
