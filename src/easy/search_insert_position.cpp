//https://leetcode.com/problems/search-insert-position

//used C++ STL std::lower_bound function that uses binary search algorithm

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        return lower_bound(nums.begin(), nums.end(), target)-nums.begin();
    }
};
