package Dynamic_Programming;

public class Delete_Operation_for_Two_Strings {

    private int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                } else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        int res = (m + n) - (2 * t[m][n]);

        return res;
    }
    

    public static void main(String[] args) {
        Delete_Operation_for_Two_Strings ob = new Delete_Operation_for_Two_Strings();
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(ob.minDistance(word1, word2));
    }
}
