package Arrays;

public class Container_With_Most_Water {

    // Brut force

    private int maxArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j)
                    continue;
                int res = Math.min(heights[i], heights[j]) * (j - i);
                max = Math.max(res, max);
            }
        }
        return max;
    }

    // Sike method
    private int maxArea1(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n - 1;
        int maxArea = 0;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Container_With_Most_Water ob = new Container_With_Most_Water();
        int heights[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(ob.maxArea(heights));
        System.out.println(ob.maxArea1(heights));
    }
}
