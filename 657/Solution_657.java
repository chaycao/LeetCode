/**
 * Created by chaycao on 2017/10/30.
 * chaycao@163.com
 */
public class Solution_657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        if (x==0 && y==0)
            return true;
        return false;
    }
}
