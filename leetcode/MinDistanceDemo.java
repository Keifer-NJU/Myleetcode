/**
 * 72. 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 解题总结：
 *  1、d_ij[i][j] 语义解释：代表word1的前i个字符，与word2的前j个字符的编辑距离
 *  2、d_ij[i][j] 能从d[i-1][j-1]、d[i][j-1]、d[i-1][j] 状态，操作一次后得到。
 *      思路：找到操作之前状态不是d_ij[i][j], 完成一次操作(不操作即相等、修改、删除、插入）后，变到状态d_ij[i][j]的状态
 *      如，操作前是d_ij[i-1][j], 然后删除word1[i-1]后，下次比较就是word1[i]和word2[j]，也就是d_ij[i][j]
 *  3、边界条件：需要思考边界条件，也就是d_ij[0][j], d_ij[i][0]的初值；代表的是空字符串与非空字符串的编辑距离
 *  4、你可能还会问，这里只求出了最小的编辑距离，那具体的操作是什么？
 *      你之前举的修改公众号文章的例子，只有一个最小编辑距离肯定不够，还得知道具体怎么修改才行。
 *      这个其实很简单，代码稍加修改，给 dp 数组增加额外的信息即可：
 *  5、优化？
 */
public class MinDistanceDemo {
    public int min(int a, int b, int c){
        return (a<b)?(a<c?a:c):(b<c?b:c);
    }
    public int minDistance(String word1, String word2) {
        char[] word1Char = word1.toCharArray();
        char[] word2char = word2.toCharArray();
        int word1Length = word1Char.length;
        int word2Length = word2char.length;
        int[][] p_ij  = new int[word1Length+1][word2Length+1];
        // 考虑空字符串 所以得+1
        for (int i = 0; i < word1Length+1; i++) {
            p_ij[i][0] = i;
        }
        for (int j = 0; j < word2Length+1; j++) {
            p_ij[j][0] = j;
        }
        for (int i = 1; i <word1Length+1 ; i++) {
            for (int j = 1; j < word2Length+1 ; j++) {
                if(word1Char[i-1]==word2char[j-1]){
                    p_ij[i][j] = Math.min(p_ij[i-1][j-1], Math.min(p_ij[i][j-1]+1, p_ij[i-1][j-1]+1));
                }
                else{
                    p_ij[i][j] = Math.min(p_ij[i-1][j-1]+1, Math.min(p_ij[i][j-1]+1, p_ij[i-1][j-1]+1));
                }
            }
        }
        return p_ij[word1Length][word2Length];
    }
}
