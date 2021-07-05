package dp.knapsack.similar;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumExtended {

    public static void main(String[] args) {

        final int TARGET = 11;

        int[] set = {2, 3, 7, 8, 10};

        List<Integer> list = findSubSet(set, TARGET);

        System.out.print(list);
    }

    static List<Integer> findSubSet(int[] set, final int TARGET) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][TARGET + 1];
        List<Integer> list = new ArrayList<>();

        // The first column expects zero sum from the subset which is always possible. Hence, setting to true.
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
                    int iTemp = i;
                    int jTemp = j;
                    while(iTemp > 0 && jTemp > 0) {
                        if (dp[i][j]) {
                            if (dp[i-1][j]) {
                                iTemp--;
                            } else {
                                list.add(set[iTemp]);
                                jTemp -= set[iTemp--];
                            }
                        }
                    }
                    return list;
                }
            }
        }

        return list;
    }
}
