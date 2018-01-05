/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-01-05 10:23.
 *
 * 对角线 上的元素。作为分界线
 */
public class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println(n+" "+m);
        if (matrix[0][0] == target)
            return true;
        if (n > m) {
            for (int i = 1; i < m; i++) {
                if (target > matrix[i][i])
                    continue;
                if (target == matrix[i][i])
                    return true;
                if (search(matrix, target, 1, i, i-1) == true)
                    return true;
                if (search(matrix, target, 0, i, i-1) == true)
                    return true;
            }
            for (int i = m; i < n; i++) {
                if (target > matrix[i][m-1]) {
                    continue;
                }
                if (target == matrix[i][m-1])
                    return true;

                if (search(matrix, target, 1, i, m-1) == true)
                    return true;
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (target > matrix[i][i])
                    continue;
                if (target == matrix[i][i])
                    return true;
                if (search(matrix, target, 1, i, i-1) == true)
                    return true;
                if (search(matrix, target, 0, i, i-1) == true)
                    return true;
            }
            for (int i = n; i < m; i++) {
                if (target > matrix[n-1][i]) {
                    continue;
                }
                if (target == matrix[n-1][i])
                    return true;

                if (search(matrix, target, 0, i, n - 1) == true)
                        return true;
                }
        }
        return false;
    }


    public boolean search(int[][] matrix, int target, int flag, int index, int end) {
        int start = 0;
        if (flag == 1) { // 横向
            while (start <= end) {
                int mid = (start + end) / 2;
                if (target == matrix[index][mid])
                    return true;
                else if (target < matrix[index][mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } else { // 竖向
            while (start <= end) {
                int mid = (start + end) / 2;
                if (target == matrix[mid][index])
                    return true;
                else if (target < matrix[mid][index]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
