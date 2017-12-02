import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaycao on 2017/12/2.
 * chaycao@163.com
 */
public class Solution_212 {
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList[] lists = new ArrayList[26];
        ArrayList<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words.length == 0)
            return result;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lists[board[i][j]-'a'].add(i*m+j);
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0)
                continue;
            int index = words[i].charAt(0) - 'a';
            if (lists[index].size() == 0)
                continue;
            for (int j = 0; j < lists[index].size(); j++) {
                int x = (int) lists[index].get(j);
                if (helper(board, words[i], 0, new boolean[n][m], x / m, x % m) == true) {
                    if (!result.contains(words[i])) {
                        result.add(words[i]);
                    }
                    System.out.println(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public boolean helper(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        if (board[i][j] == word.charAt(index)) {
            if (index == word.length()-1) //最后一个字母，返回true
                return true;
            visited[i][j] = true;
            // 继续检查
            if (i != 0 && visited[i-1][j] != true) { //上
                if (helper(board, word, index+1, visited, i-1, j) == true)
                    return true;
            }
            if (i != board.length-1 && visited[i+1][j] != true) { //下
                if (helper(board, word, index+1, visited, i+1, j) == true)
                    return true;
            }
            if (j != 0 && visited[i][j-1] != true) { //左
                if (helper(board, word, index+1, visited, i, j-1) == true)
                    return true;
            }
            if (j != board[0].length-1 && visited[i][j+1] != true) { //右
                if (helper(board, word, index+1, visited, i, j+1) == true)
                    return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
