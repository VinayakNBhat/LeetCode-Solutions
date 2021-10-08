//https://leetcode.com/problems/rotate-image

//1.transpose 
//2.reverse rows

class Solution {
public:
    void rotate(vector<vector<int>>& a) {
        int n = a.size();
        
        for(int i=0; i<n; i++)
            for(int j=i; j<n; j++)
            {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        
       for(int i=0; i<n; i++)
           reverse(a[i].begin(), a[i].end());
        
    }
};
