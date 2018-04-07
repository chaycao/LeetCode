/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-04-07 09:08.
 */
public class Solution_278 {

    public static boolean isBadVersion(int i) {
        if (i >= 1702766719)
            return true;
        else
            return false;
    }

    public static int firstBadVersion(int n) {
        int i = (n-1)/2+1;
        int start = 1;
        int end = n;
        while (i > 0 && i <= n) {
            //System.out.println("start:"+start+"; end:"+end+"; i:"+i);
            if (isBadVersion(i)) {
                if (i > 1) {
                    if(!isBadVersion(i-1))
                        break;
                    else {
                        end = i-1;
                    }
                } else
                    break;
            } else {
                start = i+1;
            }
            i = (end-start)/2+start;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
