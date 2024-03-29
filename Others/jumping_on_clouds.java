package Others;

// import java.io.*;
import java.util.*;

public class jumping_on_clouds {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int d = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        int ans = solve(n, d, a);
        System.out.println(ans);

        cin.close();
    }

    private static int solve(int n, int d, int[] a) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        int r = 0;
        for (int i = 0; i < n; i++) {
            if (m2.containsKey(a[i])) {
                int c = m2.remove(a[i]);
                r += c;
            }
            if (m1.containsKey(a[i])) {
                int c = m1.remove(a[i]);
                m2.put(a[i] + d, c);
            }
            add(m1, a[i] + d);
        }
        return r;
    }

    private static void add(Map<Integer, Integer> map, int key) {
        Integer old = map.get(key);
        if (old == null) {
            old = 0;
        }
        old++;
        map.put(key, old);
    }

}