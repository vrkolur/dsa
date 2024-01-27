package Code_Force.Div_900;

import java.util.Scanner;

public class Team {
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        // int[] temp = new int[3];
        int res = 0,count=0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                int num = cin.nextInt();
                if (num == 1)
                    count++;
            }
            if (count > 1)
                res++;
        }
        System.out.println(res);
        cin.close();
    }
}
