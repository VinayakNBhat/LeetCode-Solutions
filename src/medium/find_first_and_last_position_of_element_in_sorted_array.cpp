//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

//binary search, STL

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> v;
        
        if(!binary_search(nums.begin(), nums.end(), target))
        {
            v.push_back(-1);
            v.push_back(-1);
            return v;
        }
        
        int x = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        int y = upper_bound(nums.begin(), nums.end(), target) - nums.begin() - 1;
        
        v.push_back(x);
        v.push_back(y);
        return v;
    }
};
