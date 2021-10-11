//https://leetcode.com/problems/trapping-rain-water

class Solution {
public:
    int trap(vector<int>& h) {
        int n = h.size();
        
        if(n<3)
            return 0;
        
        int x = h[0], y, s=0;
        vector<int> v;
        int mx[n];
        
        mx[n-1]=INT_MIN;
        
        for(int i=n-1; i>0; i--)
            mx[i-1] = max(mx[i], h[i]);
        
        int j=1;
        
        while(x <= h[j])
        {
            x = h[j];
            j++;
        }
        
        for(int i=j; i<n; i++)
        {
            if(h[i]<x and h[i]<mx[i])
                v.push_back(h[i]);
            else
            {
                y = x;
                x = h[i];
                int mn = min(x, y);
                s -= accumulate(v.begin(), v.end(), -mn*v.size());
                v.clear();
            }
        }
        return s;
    }
};
