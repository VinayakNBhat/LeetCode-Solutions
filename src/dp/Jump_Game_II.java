package dp;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 */
public class Jump_Game_II {
    /**
     * We start the iteration from n-2.
     * See if the nums[i] >= (n-i) If yes the move can be done to reach the last index.
     * If not, we need to check from i+1 till i+nums[i] and find the min value.
     * Add 1 to the min value and store at dp[i] because that's the place which min + 1 moves to reach the end.
     */
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length - 1;
            int[] dp = new int[n + 1];

            for(int i = n-1; i >= 0; i--) {

                if(nums[i] == 0) {
                    dp[i] = 10005;
                    continue;
                }

                if (nums[i] >= (n - i)) {
                    dp[i] = 1;
                } else {
                    int j = i + 1;
                    int min = 10005;
                    while(j <= n && j <= i + nums[i]) {
                        min = Math.min(min, dp[j]);
                        if (dp[j] == 1) break;
                        j++;
                    }
                    dp[i] = min + 1;
                }
            }

            return dp[0];
        }
    }
}
