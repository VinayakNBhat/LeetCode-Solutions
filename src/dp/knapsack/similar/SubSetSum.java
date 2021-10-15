package dp.knapsack.similar;

/**
 * Given a set of non negative numbers and a total, find if there exists a subset in this set whose sum is same as total.
 *
 * In this program we find if there is a subset that sums to the given target.
 */
public class SubSetSum {
    public static void main(String[] args) {

        final int TARGET = 11;

        int[] set = {2, 3, 7, 8, 10};

        boolean hasSubSet = hasSubSet(set, TARGET);

        System.out.print(hasSubSet);
    }

    static boolean hasSubSet(int[] set, final int TARGET) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][TARGET + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= TARGET; j++) {
                if (set[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j-set[i]];
                }

                if(j == TARGET && dp[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
