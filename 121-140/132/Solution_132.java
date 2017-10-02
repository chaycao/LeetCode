import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chayc on 2017/9/30.
 */
public class Solution_132 {
    public int minCut(String s) {
        return bfs(s);
    }
    public int bfs(String s) {
        if (isPalindrome(s))
            return 0;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        queue.offer(l);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int k = 0; k < size; k++) {
                ArrayList<Integer> list = queue.poll();
                int start = 0;
                if (list.size() != 0)
                    start = list.get(list.size()-1);
                for (int i = start+1; i < s.length(); i++) {
                    int x = 0;
                    if (!list.isEmpty())
                        x = list.get(list.size()-1);
                    if (!isPalindrome(s.substring(x, i)))
                        continue;
                    if (isPalindrome(s.substring(i, s.length())))
                        return result;
                    ArrayList<Integer> new_list = (ArrayList<Integer>)list.clone();
                    new_list.add(i);
                    queue.add(new_list);
                }
            }
        }
        return 0;
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_132().minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }
}
