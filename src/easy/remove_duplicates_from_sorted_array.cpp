//https://leetcode.com/problems/remove-duplicates-from-sorted-array

//using simple inequality condition and counter

//TC: O(n)
//SC: O(1)

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        
        if(n==0)
            return 0;
        
        int c=1;
        
        for(int i=1; i<n; i++)
            if(nums[i]!=nums[i-1])
            {
                nums[c]=nums[i];
                c++; 
            }
        
        return c;
    }
};
