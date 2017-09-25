import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chayc on 2017/9/25.
 */
public class Solution_126 {


    private int min_size = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int len = wordList.size();
        int[][] flag = new int[len][len];
        int begin = len-1; //放在最后一个
        int end = -1;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (canTrans(wordList.get(i), wordList.get(j))) {
                    flag[i][j] = 1;
                    flag[j][i] = 1;
                }
            }
            if (wordList.get(i).equals(endWord))
                end = i;
        }
        if (end == -1)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(len-1);
        helper(result, stack, wordList, flag, begin, end, len);

        List<List<String>> result_final = new ArrayList<>();

        for (int i = 0; i < result.size(); i++)
        {
            if (result.get(i).size() == min_size)
                result_final.add(result.get(i));
        }

        return result_final;
    }

    public boolean canTrans(String a, String b) {
        int n = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                n++;
            }
            if (n > 1)
                return false;
        }
        return true;
    }



    public void helper(List<List<String>> result, Stack<Integer> stack, List<String> wordList, int[][] flag, int n, int end, int len) {
        if (n == end) {
            List<String> list_s = new ArrayList<>();
            for (int i = 0; i < stack.size(); i++)
                list_s.add(wordList.get(stack.get(i)));
            result.add(new ArrayList<>(list_s));
            if (list_s.size() < min_size)
                min_size = list_s.size();
            System.out.println(min_size);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (flag[n][i] == 1) {
                if (!stack.contains(i)) { //不包含
                    if (stack.size() + 1 > min_size)
                        continue;
                    stack.push(i);
                    if(i == end)
                        System.out.println("x");
                    helper(result, stack, wordList, flag, i, end, len);
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        String begin = "qa";
        String end = "sq";
        List<String> list = new ArrayList<>();
        list.add("ta");
        list.add("sq");
        list.add("sc");
        list.add("tc");
        list.add("sc");
        list.add("ta");
    }
}
