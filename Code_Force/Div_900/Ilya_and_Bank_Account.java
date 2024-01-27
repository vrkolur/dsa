package Code_Force.Div_900;

import java.util.Scanner;

public class Ilya_and_Bank_Account {

    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        String s=cin.next();
        if (s.charAt(0) == '-') {
            int n = s.length();
            String res = "";
            if (s.charAt(n - 1) > s.charAt(n - 2)) {
                res = s.substring(0, n - 1);
            } else
                res = s.substring(0, n - 2) + s.charAt(n - 1);
            if(s.length()==3&&res.charAt(1)=='0'){
                System.out.println(0);
            }else 
                System.out.println(res);
        } else
            System.out.println(s);
        cin.close();
    }
}
