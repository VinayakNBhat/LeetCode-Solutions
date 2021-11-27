package easy;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class Find_the_Town_Judge {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] arr = new int[n + 1];
            for(int[] a : trust) {
                arr[a[0]]--;
                arr[a[1]]++;
            }

            for(int i = 1; i < n+1; i++) {
                if (arr[i] == n-1) return i;
            }

            return -1;
        }
    }
}
