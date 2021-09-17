#include <bits/stdc++.h>
using namespace std;

//https://leetcode.com/problems/pascals-triangle-ii/

//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.


// TC : O(N^2)
// SC : O(N)

class Solution {
public:
    vector<int> getRow(int n) {
        vector<int> y, z;
        
        if(n == 0)
        {
            y.push_back(1);
            return y;
        }
       
        for(int i=1; i<=n+1; i++)
        {
            z = y;
            y.clear();
            y.push_back(1);
            for(int j=1; j<i-1; j++)
                y.push_back(z[j-1]+z[j]);
            y.push_back(1);
        }
        
        return y;
    }
};
