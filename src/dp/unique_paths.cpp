#include<bits/stdc++.h>
using namespace std;

//https://leetcode.com/problems/unique-paths/

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?
    
//simple dp top-down approach


class Solution {
public:
    int uniquePaths(int m, int n) {
        int t[m+1][n+1];
        
        for(int i=0; i<m; i++)
            t[i][0]=1;
        
        for(int j=0; j<n; j++)
            t[0][j]=1;
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }
        
        return t[m-1][n-1];
    }
};
