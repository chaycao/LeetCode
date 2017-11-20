import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chaycao on 2017/11/19.
 * chaycao@163.com
 */
public class Solution_weekcontest_59_2 {
    static class MyCalendar {

        private List<List<Integer>> list = new ArrayList<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i).get(0);
                int b = list.get(i).get(1);
                if (!(start >= b || end <= a))
                    return false;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            list.add(temp);
            return true;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        //System.out.println(Collections.binarySearch(list, 15));
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10,20));
        System.out.println(calendar.book(15,25));
        System.out.println(calendar.book(20,30));
        System.out.println(calendar.book(22,23));
    }
    /*
    [97,100]
    [33,51]
    [75,92]
    [19,30]
    [53,63]
     */
}
