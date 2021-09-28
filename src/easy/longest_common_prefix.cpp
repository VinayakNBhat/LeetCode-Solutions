class Solution {
public:
    string longestCommonPrefix(vector<string>& ss) {
        int n = ss.size();
        string s = ss[0];
        auto m = s.size();
        
        for(int i=1; i<n; i++)
        {
            int j=0;
            m = min(m, ss[i].size());
            while(j<m && s[j]==ss[i][j])
                j++;
            s = s.erase(j);
        }
        return s;
    }
};
