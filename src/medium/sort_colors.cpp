//https://leetcode.com/problems/sort-colors/

// 2 approaches are provided
// Both have O(n) TC and O(1) SC but second one is doubly faster than the first.

class Solution {
public:
    void sortColors(vector<int>& nums) {
        
        //approach 1: count sort
        /*
        int n = nums.size();
        int c0=0, c1=0, c2=0;
        for(int i=0; i<n; i++)
            if(nums[i]==0) c0++;
            else if(nums[i]==1) c1++;
            else c2++;
        
        for(int i=0; i<c0; i++)
            nums[i]=0;
        
        for(int i=c0; i<c0+c1; i++)
            nums[i]=1;
        
        for(int i=c0+c1; i<n; i++)
            nums[i]=2;
        */
        
        
        //approach 2: Dutch National Flag Algorithm
        int n = nums.size();
        int low = 0, mid = 0, high = n-1;
        
        while(mid<=high)
        {
            //cout<<low<<" "<<mid<<" "<<high<<endl;
            if(nums[mid]==0)
            {
                swap(nums[low], nums[mid]);
                low++;
                mid++;
            }
            else if(nums[mid]==1)
                mid++;
            else
            {
                swap(nums[mid], nums[high]);
                high--;
            }
        }
        
    }
};
