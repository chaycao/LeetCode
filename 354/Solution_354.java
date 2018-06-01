import java.util.Arrays;

/**
 * @author chaycao
 * @description
 * @date 2018-05-31 19:08.
 */
public class Solution_354 {

    public static class Doll implements Comparable<Doll>{
        int width;
        int height;

        public Doll(int width, int height) {
            this.width = width;
            this.height = height;
        }


        @Override
        public int compareTo(Doll o) {
            if (this.width < o.width)
                return -1;
            else if (this.width == o.width)
                return 0;
            else
                return 1;
        }
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        int len = envelopes.length;
        if (len == 1)
            return 1;
        Doll[] dolls = new Doll[len];
        for (int i = 0; i < len; i++) {
            dolls[i] = new Doll(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(dolls);
        int res = 1;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++)
            dp[i] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (dolls[i].compareTo(dolls[j]) != 0) {
                    if (dolls[i].height > dolls[j].height) {
                        dp[i] = dp[i] > (dp[j]+1) ? dp[i] : (dp[j]+1);
                    }
                }
            }
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = {
                {1,3},
                {3,5},
                {6,7},
                {6,8},
                {8,4},
                {9,5}
        };
        System.out.println(maxEnvelopes(envelopes));
    }
}
