package Code_Force.Div_1100;

import java.util.Scanner;

public class Chat_room {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        String str = "hello";
        s = s.toLowerCase();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < str.length() && s.charAt(i) == str.charAt(j)) {
                j++;
                // System.out.println(i + " " + j);
            }
        }
        // System.out.println(str.length()+" "+j);
        if (j == str.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        cin.close();
    }
}
