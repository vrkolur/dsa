package String;

import java.util.Arrays;

public class Longest_Common_Prefix {

    private String longestCommonPrefix(String[] strs){
        StringBuilder sb=new StringBuilder();
        Arrays.sort(strs);
        String str1=strs[0];
        String str2=strs[strs.length-1];
        for(int i=0;i<Math.min(str1.length(),str2.length());i++){
            if(str1.charAt(i)!=str2.charAt(i)) return sb.toString();
            else sb.append(str2.charAt(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Longest_Common_Prefix ob=new Longest_Common_Prefix();
        String[] strs={"flower","flow","flight"};
        System.out.println(ob.longestCommonPrefix(strs));
    }
}
