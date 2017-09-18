import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/18.
 * 暴力法，还没做出来。。。
 */
public class Solution_weekcontest_50_4 {
    public boolean judgePoint24(int[] nums) {
        List<List<Float>> list = new ArrayList<>();
        int[] flag = {0,0,0,0};
        allSort(list, new ArrayList<>(), flag, nums, 0);
        for (int i = 0 ; i < 4; i++) {
            if (fun(list.get(i), 1, list.get(i).get(0)) == true)
                return true;
        }
        return false;
    }
    public void allSort(List<List<Float>> result, List<Float> list, int[] flag, int[] nums, int index) {
        if (index == 4) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (flag[i] != 1) {
                list.add(((Integer)nums[i]).floatValue());
                flag[i] = 1;
                allSort(result, list, flag, nums, index+1);
                flag[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean fun(List<Float> list, int index, float result) {
        if (index == 4)
        {
            if(Math.abs(result - 24) < 2)
                System.out.println(result);
            if ((int)result == 24)
                return true;
            else
                return false;
        }

        for (int i = 0; i < 4; i++) {
            switch (i){
                case 0:
                    result += list.get(index);
                    if (fun(list, index+1, result) == true)
                        return true;
                    result -= list.get(index);
                    break;
                case 1:
                    result -= list.get(index);
                    if (fun(list, index+1, result) == true)
                        return true;
                    result += list.get(index);
                    break;
                case 2:
                    result *= list.get(index);
                    if (fun(list, index+1, result) == true)
                        return true;
                    result /= list.get(index);
                    break;
                case 3:
                    result /= list.get(index);
                    if (fun(list, index+1, result) == true)
                        return true;
                    result *= list.get(index);
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6};
        System.out.println(new Solution_weekcontest_50_4().judgePoint24(nums));
    }
}
