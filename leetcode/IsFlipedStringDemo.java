package leetcode;

public class IsFlipedStringDemo {
    /**
     * 方法1  执行用时 3 ms, 在所有 Java 提交中击败了25.12%的用户内存消耗 :42 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(""))return true;
        int len = s1.length();
        for (int i = 1; i <= len; i++) {
            if(s1.substring(0,i).equals(s2.substring(len-i,len))){
                if(i==len) return true;
                else if(s1.substring(i,len).equals(s2.substring(0,len-i))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString1(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(""))return true;
        s2 += s2;
        return s2.contains(s1);
    }
}
