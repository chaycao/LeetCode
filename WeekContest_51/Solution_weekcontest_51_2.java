import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chayc on 2017/9/24.
 * 分两种情况
 * 1. 小时不用动，可以改变分钟
 * 2. 小时需要动，分钟尽可能小
 *      a.当天，时间大于当前小时，尽可能小
 *      b.第二天，时间尽可能小
 */
public class Solution_weekcontest_51_2 {
    public String nextClosestTime(String time) {
        int[] a = new int[4];
        a[0] = time.charAt(0)- 48;
        a[1] = time.charAt(1)- 48;
        a[2] = time.charAt(3)- 48;
        a[3] = time.charAt(4)- 48;
        List<Integer> nums = new ArrayList<>();
        nums.add(time.charAt(0)- 48);
        nums.add(time.charAt(1)- 48);
        nums.add(time.charAt(3)- 48);
        nums.add(time.charAt(4)- 48);
        Collections.sort(nums);

        // 小时不动，改变分钟
        if (a[3] < 9) { // 改变分钟的个位数
            for (int i = 0; i < 4; i++) {
                if (nums.get(i) > a[3]) {
                    return ""+a[0]+a[1]+":"+a[2]+nums.get(i);
                }
            }
        }

        // 改变分钟的十位数
        if (a[2] < 5) {
            for (int i = 0; i < 4; i++) {
                if (nums.get(i) > a[2] && nums.get(i) < 6) {
                    return ""+a[0]+a[1]+":"+nums.get(i)+nums.get(0);
                }
            }
        }

        // 改变小时。当天
        // 小时的个位数
        if (a[0] < 2) {
            if (a[1] < 9) {
                for (int i = 0; i < 4; i++) {
                    if (nums.get(i) > a[1]) {
                        return ""+a[0]+nums.get(i)+":"+nums.get(0)+nums.get(0);
                    }
                }
            }
        }

        // a[0] == 2
        if (a[1] < 3) {
            for (int i = 0; i < 4; i++) {
                if (nums.get(i) > a[1] && nums.get(i) < 4) {
                    return ""+a[0]+nums.get(i)+":"+nums.get(0)+nums.get(0);
                }
            }
        }

        // 第二天
        return "" + nums.get(0)+nums.get(0)+":"+ nums.get(0)+nums.get(0);

    }

    public static void main(String[] args) {
        String s = new Solution_weekcontest_51_2().nextClosestTime("20:48");
        System.out.println(s);
    }

    public void bubbleSort(int[] a) {
        int temp=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
