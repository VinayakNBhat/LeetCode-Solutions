#include<bits/stdc++.h>
using namespace std;

// https://leetcode.com/problems/maximum-subarray/
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.


// Kadane's algorithm

// TC : O(N)
// SC : O(1)


class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size(), x;
        int m = INT_MIN;
        int mx = -32767;
        
        for(int i=0; i<n; i++)
        {
            x = nums[i];
            mx = max(x, mx + x);
            m = max(m, mx);
        }
        
        return m;
    }
};

