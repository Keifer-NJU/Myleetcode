package leetcode;

/**
 * 面试题 01.05. 一次编辑   字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 理解题意：两个字符串长度相差只能小于等于 1   这就是和题"最少编辑距离” 的解题不同   变简单了
 */
public class OneEditAwayDemo {
    public boolean oneEditAway(String first, String second) {
        int len_long = first.length()>second.length()?first.length():second.length();
        int len_short = first.length()>second.length()?second.length():first.length();
        if(len_long-len_short>1)return false;
        boolean mask = false;
        if(first.length()<second.length()){
            String temp = first;
            first = second;
            second = temp;
        }
        for (int i_l = 0,i_s = 0; i_s < len_short; i_l++) {
            if(first.charAt(i_l)!=second.charAt(i_s)){
                if(mask) return false;
                else {
                    mask = true;
                    i_s += (len_long-len_short==1)?0:1;
                }
            }
            else i_s++;
        }
        return true;
    }
}
