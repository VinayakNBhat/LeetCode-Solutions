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
            int jumps = 0;
            int currentFarthest = 0;
            int currentEnd = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                currentFarthest = Math.max(currentFarthest, i + nums[i]);
                if (i == currentEnd) {
                    jumps++;
                    currentEnd = currentFarthest;
                }

            }

            return jumps;
        }
    }
}
