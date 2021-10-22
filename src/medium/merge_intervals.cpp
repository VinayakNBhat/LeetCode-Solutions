//https://leetcode.com/problems/merge-intervals

//TC: O(N)

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& v) {
        int n = v.size();
        int mx = 0, j=0;
        vector<vector<int>> v2;
        
        sort(v.begin(), v.end());
        v2.push_back(v[0]);
        
        
        for(int i=1; i<n; i++)
        {   
            if(v[i][0]<=v2[j][1])
                v2[j][1] = max(v[i][1], v2[j][1]);
            
            else
            {
                v2.push_back(v[i]);
                j++;
            }
        }
        
        return v2;
    }
};
