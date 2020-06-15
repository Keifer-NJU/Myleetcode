package leetcode;

import java.util.Arrays;

public class CheckPermutationDemo {
    /**
     * 方法1：散列表（数组代替）
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length()!=s2.length())return false;
        int[] hashArray = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hashArray[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            hashArray[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26 ; i++) {
            if (hashArray[i]<0)return false;
        }
        return true;
    }
    /**
     * 方法2：排序+比较
     *
     */
    public static boolean CheckPermutation1(String s1, String s2){
        if(s1.length()!=s2.length())return false;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return new String(s1Array).equals(new String(s2Array));
    }

    public static void main(String[] args) {
        boolean result = CheckPermutation1("abc","cba");
        System.out.println(result);
    }
}
