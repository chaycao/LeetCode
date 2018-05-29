/**
 * @author chaycao
 * @description
 * @date 2018-05-29 22:31.
 */
public class Solution_374 {
    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = ((right-left)>>1) + left;
            int res = guess((int)mid);
            if (res == 0) {
                return (int)mid;
            } else if (res == -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)left;
    }

    public static int guess(int num) {
        if (num < 1702766719)
            return -1;
        else if (num > 1702766719){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }
}
