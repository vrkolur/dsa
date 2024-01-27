package Others;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array {

    private static List<Integer> solution(int[] arr) {
        int index = 0;
        List<Integer> out_arr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                out_arr.add(index + 1);
            } else {
                arr[index] = -arr[index];
            }
        }
        return out_arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        System.out.println(solution(arr));
    }
}
