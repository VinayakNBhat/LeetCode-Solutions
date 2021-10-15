package dp;

/**
 * https://leetcode.com/problems/best-sightseeing-pair/
 *
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 * YouTube Reference: https://www.youtube.com/watch?v=acZLDtayXlU
 */

public class Best_Sightseeing_Pair {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int maxI = A[0];
            int ans = 0;
            for(int i = 1; i < A.length; i++) {
                ans = Math.max(ans, maxI + A[i] - i);
                maxI = Math.max(maxI, A[i] + i);
            }
            return ans;
        }
    }
}
