/**
 * @author chaycao
 * @description
 * @date 2018-05-22 19:25.
 */
public class Solution_304 {
    static class NumMatrix {

        private int[][] temp;

        private int n = 0;

        private int m = 0;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return;
            n = matrix.length; //row
            m = matrix[0].length; //col
            temp = new int[n][(1+m)*m/2];
            for (int i = 0; i < n; i++) {
                int index = 0;
                for (int j = 0; j < m; j++) {
                    temp[i][index++] = matrix[i][j];
                    int sum = matrix[i][j];
                    for (int k = j+1; k < m; k++) {
                        sum += matrix[i][k];
                        temp[i][index++] = sum;
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row2 >= n || col2 >= m)
                return 0;
            int res = 0;
            for (int i = row1; i <= row2; i++) {
                res += temp[i][(2*m-col1+1)*(col1)/2 + col2 - col1];
            }
            return res;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };
        int[][] matrix = {};
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(1,2,2,4);
        System.out.println(param_1);
    }
}
