package leetcode;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
 *方法1： 一次扫描
 */
public class CompressStringDemo {
    public String compressString(String S) {
        int len = S.length();
        if(len<3) return S;
        StringBuilder stringBuilder = new StringBuilder(len);
        stringBuilder.append(S.charAt(0));
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(S.charAt(i)==S.charAt(i-1)){
                count++;
            }
            else {
                stringBuilder.append(count);
                stringBuilder.append(S.charAt(i));
                count = 1;
            }
        }
        stringBuilder.append(count);
        return stringBuilder.length()>len? S: stringBuilder.toString();
    }
}
