package easy;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *
 */
class VersionControl {
    public boolean isBadVersion(int n) {
        return true;
    }
}
public class First_Bad_Version {
    public class Solution extends VersionControl {
        int isBadVersionSearch(long low, long high) {
            if(low > high)
                return Integer.MAX_VALUE;

            if(isBadVersion(Math.toIntExact(low)))
                return Math.toIntExact(low);

            if(!isBadVersion(Math.toIntExact(high)))
                return Integer.MAX_VALUE;

            long mid = (low + high) / 2;

            if(isBadVersion(Math.toIntExact(mid))) {
                return Math.toIntExact(Math.min(isBadVersionSearch(low, mid-1), mid));
            } else {
                return isBadVersionSearch(mid+1, high);
            }
        }

        public int firstBadVersion(int n) {
            return isBadVersionSearch(1L, (long)n);
        }
    }
}
