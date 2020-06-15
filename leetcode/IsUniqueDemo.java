package leetcode;

import java.util.HashMap;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。   0 <= len(s) <= 100    如果你不使用额外的数据结构，会很加分。
 *  1、解法1  散列表  hashmap
 *  2、 解法2 数组 标记法， 根据示例我判断字符串中出现的字符应该在['a','z']之间，使用bool数组的做法是定义一个长度为26的初始值全为0 bool数组，
 *      逐个字符遍历astr，如果bool数组中对应的下标（'a'->0, ..., 'z'->25）的值为1则重复出现，返回false，否则设置对应下标值为1。
 *  3、 解法3   位运算方法
 *  4、 string.indexof(char c, int fromindex)
 *
 */
public class IsUniqueDemo {
    // 散列表方案
    public boolean isUnique(String astr) {
        HashMap<Character,Integer> strHashMap = new HashMap();
        for (int i = 0; i < astr.length(); i++) {
            if(strHashMap.put(astr.charAt(i),1)!=null){
                return false;
            }
        }
        astr.indexOf('a',10);
        return true;
    }
    // 位向量运算方案
    public boolean isUniqueBit(String astr) {
        //因为都是有符号的，所以排除最高位，最多只能表示63位：32~94
        long mask32_94 = 0L;
        long mask95_126 = 0L;
        int threod;
        for (int i = 0; i < astr.length(); i++) {
            threod = astr.charAt(i);
            if (threod < 95) {
                if ((mask32_94 & (1 << (threod - 32))) !=0) {
                    return false;
                }
                mask32_94 |= (1 << (threod - 32));
            } else {
                if ((mask95_126 & (1 << (threod - 95))) != 0) {
                    return false;
                }
                mask95_126 |= (1 << (threod - 95));
            }
        }
        return true;
    }
    public static String getType(Object o){
        return o.getClass().toString();
    }
    public static void main(String[] args) {
        long test = 10;
        System.out.println(getType(test));
    }
}

