/**
 * Created by chaycao on 2017/11/20.
 * chaycao@163.com
 */
public class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int i = 0;
        int j = len-1;
        int[] result = new int[2];
        while (i < j) {
            int temp = target - numbers[i];
            if (temp == numbers[j]) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            } else if (temp > numbers[j]){
                i++;
                continue;
            } else {
                j--;
                continue;
            }
        }
        return result;
    }
}
