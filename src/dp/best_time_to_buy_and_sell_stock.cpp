#include <bits/stdc++.h>
using namespace std;


// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//approach : find max difference between any element and prefix minimum element.
// TC : O(N)
// SC : O(1)

class Solution {
public:
    int maxProfit(vector<int>& p) {
        int mx = INT_MIN;
        int mn = INT_MAX;
        int x;
        int n = p.size();
        
        for(int i=0; i<n; i++)
        {
            x = p[i];
            mn = min(mn, x);
            mx = max(mx, x-mn);
        }
       
        return mx;
    }
};
