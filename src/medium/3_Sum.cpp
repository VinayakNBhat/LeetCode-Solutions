https://leetcode.com/problems/3sum

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        set<vector<int>> s;
        
        sort(nums.begin(), nums.end());
        
        for(int i=0; i<n-2; i++)
        {
            int j=i+1, k=n-1;
           
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    vector<int> x;
                    x.push_back(nums[i]);
                    x.push_back(nums[j]);
                    x.push_back(nums[k]);
                    s.insert(x);
                }
                if(nums[j]+nums[k]>-nums[i])
                    k--;
                else
                    j++;
            }
            
            while(i<n-1 && nums[i]==nums[i+1])
                i++;
        }
        
        vector<vector<int>> v(s.begin(), s.end());
        return v;
    }
};
