package leetcode;

/**
 * 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 *
 *
 */
public class ReplaceSpacesDemo {
    public String replaceSpaces(String S, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if(S.charAt(i)==' ')spaceCount++;
        }
        char[] ch = new char[length+spaceCount*2];
        for (int i = 0, j= 0; i < length; i++) {
            char temp = S.charAt(i);
            if(temp ==' '){
                ch[j++] = '%';
                ch[j++] = '2';
                ch[j++] = '0';
            }
            else ch[j++] = temp;
        }
        return new String(ch);
    }

    /**
     *方法2 ：  和方法1类似，只是用了java内置的StringBuilder
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces1(String S, int length){
        StringBuilder stringBuilder = new StringBuilder(S);
        for (int i = 0; i < length; i++) {
            if (S.charAt(i)==' ')stringBuilder.append("%20");
            else stringBuilder.append(S.charAt(i));
        }
        return stringBuilder.toString();
    }
    /**
     * 方法3
     */
    public String replaceSpaces2(String S, int length){
        return S.substring(0,length).replaceAll(" ","%20");
    }
}
