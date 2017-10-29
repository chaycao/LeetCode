import java.util.*;

/**
 * Created by chaycao on 2017/10/29.
 * chaycao@163.com
 */
public class Solution_weekcontest_56_4 {
    public int smallestDistancePair(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            list.add(nums[i]);
        }
        Collections.sort(list);
        List<Integer> distance = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if((j+i) < list.size())
                {
                    int d = Math.abs((Integer) list.get(j) - (Integer) list.get(j+i));
                    distance.add(d);
                }
            }
//            if (distance.size() > k)
//            {
//                Collections.sort(distance);
//                return distance.get(k-1);
//            }
        }
        Collections.sort(distance);
        return distance.get(k-1);
    }

    public static void main(String[] args) {
        int[] n = {10,6,2,10,5,4,0,1,5,2,5,5,5,0,4,9,8,6,7,9,1,10,4,8,6,3,6,2,1,7,5,0,2,6,10,10,0,3,9,0,8,3,5,9,4,4,5,2,2,7};
        System.out.println(new Solution_weekcontest_56_4().smallestDistancePair(n, 444));
    }
}
