package leetcode;

/**
 * 面试题 01.04. 回文排列
 * 方法1、数组、hash   O(n)  O(n)
 * 方法2、位向量    O(n)    O(1)(k空间）
 */
public class CanPermutePalindromeDemo {
    public boolean canPermutePalindrome(String s) {
        long mask32_94 = 0L;
        long mask95_126 = 0L;
        long charBit = 1L;
        int count = 0;
        int threshold = 0;
        for (int i = 0; i < s.length(); i++) {
            threshold = s.charAt(i)-32;
            if(threshold<95){
                /**
                 * 原来的  1<<threshold   表示的int，只有32位， 与long(mask32_94...)做位运算   得不到预期结果
                 */
//                (mask32_94 & (1<<threshold))==0? count++:count--;
//                if ((mask32_94 & (1 << threshold)) == 0) {
                if ((mask32_94 & (charBit << threshold)) == 0) {
                    count++;
                    mask32_94 |= (charBit<<threshold);
                } else {
                    count--;
                    mask32_94 &= (~(charBit<<threshold));
                }
            }
            else {
                if ((mask95_126 & (charBit << threshold)) == 0) {
                    count++;
                    mask95_126 |= (charBit<<threshold);
                } else {
                    count--;
                    mask95_126 &= (~(charBit<<threshold));
                }
            }
        }
        return ((count==1||count==0)?true:false);
    }
}
