package dp;

public class Knapsack_0_1_Memorization {
    public static void main(String[] args) {
        int[] wt =  {10,20,30};// {1,3,4,5};
        int[] val = {60,100,120};//  {1,4,5,7};
        int W = 50;//7; //50;

        int n = wt.length;

        int max = 0;

        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(val[i] + dp[i-1][j - wt[i]], dp[i-1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print("Maximised value: " + max);
    }
}
