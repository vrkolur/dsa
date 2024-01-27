package Code_Force.Div_900;

import java.util.Scanner;

public class String_Task {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        s = s.toLowerCase();
        String it = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u' || s.charAt(i) == 'y') {
                continue;
            } else
                it += s.charAt(i);
        }
        for (int i = 0; i < it.length(); i++) {
            System.out.print('.');
            System.out.print(it.charAt(i));
        }
        cin.close();

    }
}
