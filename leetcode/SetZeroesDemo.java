package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroesDemo {
    public void setZeroes(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        boolean[] column = new boolean[N];
        boolean row0 = false,column0 = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j]==0){
                    if(i==0){
                        row0 = true;
                    }
                    if(j==0){
                        column0 = true;
                    }
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            if(matrix[i][0]==0){
                for (int j = 1; j < M; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < M; j++) {
            if(matrix[0][j]==0){
                for (int i = 1; i < N; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row0){
            for (int j = 1; j < M; j++) {
                matrix[0][j] = 0;
            }
        }
        if(column0){
            for (int i = 1; i < N; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    /**
     * 方法2  用额外的空间   hashset  O(M+N)
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            //思路;先遍历一下，看哪些行和哪些列需要清0，标记一下,并保存起来，然后再清行，清列
            Set<Integer> rows=new HashSet<>();
            Set<Integer> clos=new HashSet<>();
            int m=matrix.length;
            int n=matrix[0].length;
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    if(matrix[i][j]==0){
                        rows.add(i);
                        clos.add(j);
                    }
                }
            }
            //清行
            for(Integer row:rows){
                Arrays.fill(matrix[row], 0);
            }

            //清列
            for (Integer clo:clos){
                for (int i = 0; i <m ; i++) {
                    matrix[i][clo]=0;
                }
            }
        }

    }
}
