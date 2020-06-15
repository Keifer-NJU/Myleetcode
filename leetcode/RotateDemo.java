package leetcode;

/**
 * 面试题 01.07. 旋转矩阵  中等
 *给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
 * 不占用额外内存空间能否做到？
 */
public class RotateDemo {
    /**
     * 方法1 一次旋转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int N = matrix[0].length;
        int temp = 0, count = 0;
        for (int i = 0; i < N/2; i++) {
            for (int j = i; j < N-i-1; j++) {
                // 逆时针交换 优化(交换次数少1，且不用怕覆盖问题)、 swap用异或交换优化（不适用额外空间temp），java不能引用传递，所以交换不能用函数封装
//                swap(matrix[i][j],matrix[N-j-1][i]);
//                swap(matrix[N-j-1][i],matrix[N-i-1][N-j-1]);
//                swap(matrix[N-i-1][N-j-1],matrix[j][N-i-1]);
                int temp_i = i;
                int tem_j = j;
                int temp_swap = 0;
                count = 0;
                while(count<3){
                    matrix[temp_i][tem_j] ^= matrix[N-tem_j-1][temp_i];
                    matrix[N-tem_j-1][temp_i] ^= matrix[temp_i][tem_j];
                    matrix[temp_i][tem_j] ^= matrix[N-tem_j-1][temp_i];
                    temp_swap = temp_i;
                    temp_i = N-tem_j-1;
                    tem_j = temp_swap;
                    count++;
                }

                //下面注释的为优化前的程序：顺时针、交换用额外变量
//                int temp_i = i;
//                int tem_j = j;
//                int temp_swap = 0;
//                count = 0;
//                temp = matrix[temp_i][tem_j];
//                int temp2 = 0;
//                while(count<4){
//                    temp2 = matrix[tem_j][N-temp_i-1];
//                    matrix[tem_j][N-temp_i-1] = temp;
//                    temp = temp2;
//                    temp_swap = tem_j;
//                    tem_j = N - temp_i-1;
//                    temp_i = temp_swap;
//                    count++;
//                }
            }
        }
    }
    public void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

}
