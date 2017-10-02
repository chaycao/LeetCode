/**
 * Created by chayc on 2017/10/2.
 */
public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] val = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            val[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            if (helper(val, i) == true)
                return i;
        }
        return -1;
    }
    public boolean helper(int[] val, int n) {
        int all = 0;
        int end = val.length;
        for (int i = n; i < end; i++) {
            all += val[i];
            System.out.println(all);
            if (all < 0)
                return false;
            if (i == val.length-1) {
                i = -1;
                end = n;
            }
        }
        return true;
    }
}
