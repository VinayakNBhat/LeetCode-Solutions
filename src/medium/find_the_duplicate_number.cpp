//https://leetcode.com/problems/find-the-duplicate-number

//TC: O(N)
//SC: O(1)

//using slow pointer and fast pointer
//explanation: https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=3

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int sp, fp;
        
        sp = fp = nums[0];
        
        do {
            sp = nums[sp];
            fp = nums[nums[fp]];
        } while(sp!=fp);
        
        fp=nums[0];
        while(sp!=fp)
        {
            sp = nums[sp];
            fp = nums[fp];
        }
        
        return sp;
    }
};
