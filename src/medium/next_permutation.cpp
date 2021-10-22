//https://leetcode.com/problems/next-permutation

//TC : O(N)
//SC: O(1)

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
     // one line solution using STL function  
    //         cout<<next_permutation(nums.begin(), nums.end());
        
        int n = nums.size(), x = -1, y;
        
        for(int i=n-1; i>0; i--)
            if(nums[i-1]<nums[i])
            {
                x=i-1;
                break;
            }
 
        if(x>=0)
        {
            int i=n-1; 
            while(nums[i]<=nums[x]) 
                    i--;
            y=i; 
            swap(nums[x], nums[y]);
        }
        
        reverse(nums.begin()+x+1, nums.end());
    }
};
