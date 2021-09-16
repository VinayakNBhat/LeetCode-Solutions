#include <bits/stdc++.h>
using namespace std;

//https://leetcode.com/problems/pascals-triangle/

//Given an integer numRows, return the first numRows of Pascal's triangle.

//TC : O(N^2)
//SC : O(N^2)


class Solution {
public:
    vector<vector<int>> generate(int n) {
        vector<vector<int>> v;
        vector<int> x;
        x.push_back(1);
        v.push_back(x);
        
        if(n == 1)
        {
            return v;
        }
       
        for(int i=2; i<=n; i++)
        {
            vector<int> y;
            vector<int> z = v.back();
            y.push_back(1);
            for(int j=1; j<i-1; j++)
                y.push_back(z[j-1]+z[j]);
            y.push_back(1);
            v.push_back(y);
        }
        
        return v;
    }
};
