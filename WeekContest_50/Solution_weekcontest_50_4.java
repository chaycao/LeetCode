import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayc on 2017/9/18.
 * 26ms,暴力法
 * 总结下来觉得 直接从括号出发，更为简单
 * ((A B) C) D)
 * (A (B C)) D
 * A ((B C) D)
 * A (B (C D))
 * (A B) (C D)
 * 这5种 每个 4*4*4 再乘上24
 * 7680次
 */
public class Solution_weekcontest_50_4 {
    public boolean judgePoint24(int[] nums) {
        List<List<Float>> list = new ArrayList<>();
        int[] flag = {0,0,0,0};
        allSort(list, new ArrayList<>(), flag, nums, 0);
        for (int i = 0 ; i < 24; i++) {
            if (fun(list.get(i), 1, list.get(i).get(0)) == true)
                return true;
            if (fun_2(list.get(i)) == true)
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

    // 应对大部分情况
    public boolean fun(List<Float> list, int index, float result) {
        if (index == 4)
        {
            if (result < 24.1 && result > 23.9)
            {
                System.out.println(result);
                return true;
            }

            else
                return false;
        }

        for (int i = 0; i < 6; i++) {
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
                case 4:
                    float temp = result;
                    result = list.get(index) - result;
                    if (fun(list, index+1, result) == true)
                        return true;
                    result = temp;
                    break;
                case 5:
                    float temp_1 = result;
                    result = list.get(index) / result;
                    if (fun(list, index+1, result) == true)
                        return true;
                    result = temp_1;
                    break;
            }
        }
        return false;
    }

    // 应对(A B) (C D)形式，填运算符
    public boolean fun_2(List<Float> list) {
        float result_left = 0;
        float result_right = 0;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    result_left = list.get(0) + list.get(1);
                    break;
                case 1:
                    result_left = list.get(0) - list.get(1);
                    break;
                case 2:
                    result_left = list.get(0) * list.get(1);
                    break;
                case 3:
                    result_left = list.get(0) / list.get(1);
                    break;
            }
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        result_right = list.get(2) + list.get(3);
                        break;
                    case 1:
                        result_right = list.get(2) - list.get(3);
                        break;
                    case 2:
                        result_right = list.get(2) * list.get(3);
                        break;
                    case 3:
                        result_right = list.get(2) / list.get(3);
                        break;

                }
                for (int k = 0; k < 4; k++) {
                    switch (k) {
                        case 0:
                            if ((result_left + result_right) < 24.1 && (result_left + result_right) > 23.9)
                                return true;
                        case 1:
                            if ((result_left - result_right) < 24.1 && (result_left - result_right) > 23.9)
                                return true;
                        case 2:
                            if ((result_left * result_right) < 24.1 && (result_left * result_right) > 23.9)
                                return true;
                        case 3:
                            if ((result_left / result_right) < 24.1 && (result_left / result_right) > 23.9)
                                return true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7};
        System.out.println(new Solution_weekcontest_50_4().judgePoint24(nums));
    }
}
