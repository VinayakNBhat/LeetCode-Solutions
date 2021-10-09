//https://leetcode.com/problems/max-consecutive-ones

//TC: O(n)
//SC: O(1)

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int n = nums.size();
        int c=0, mx=0;
        
        for(int i=0; i<n; i++)
        {
            if(nums[i]==1)
                c++;
            else
                c=0;
            mx = max(mx, c);
        }
        
        return mx;
    }
};
