//https://leetcode.com/problems/missing-number

//TC: O(N) 
//SC: O(1)

//method 1: (implemented here) using xor 

//method 2: sum of first n natural numbers - sum of given n numbers (be careful about overflows)

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int x = 0;
        
        for(int i=0; i<nums.size(); i++)
            x = x xor nums[i] xor i+1;
        
        return x;
    }
};
