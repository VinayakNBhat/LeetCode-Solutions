#include<bits/stdc++.h>
using namespace std;

//https://leetcode.com/problems/climbing-stairs/

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//observe that this problem states the problem of fibonacci sequences in a slightly different manner

class Solution {
public:
    int climbStairs(int n) {
        if(n<=3)
            return n;
        
        int t[n+1];
        t[0]=0;
        t[1]=1;
        t[2]=2;
        t[3]=3;
        
        for(int i=4; i<=n; i++)
            t[i] = t[i-1] + t[i-2];
        
        return t[n];
    }
};
