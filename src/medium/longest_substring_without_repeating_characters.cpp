//https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> v(130, -1);
        
        int n = s.size();
        int st=0, mx=0;
        
        for(int i=0; i<n; i++)
        {
            if(v[s[i]]>=st)
            {
                mx = max(i-st, mx);
                st = v[s[i]]+1;
            }
            v[s[i]]=i;
        }
        mx = max(n-st, mx);
        return mx;
    }
};
