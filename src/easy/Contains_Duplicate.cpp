#include<bits/stdc++.h>
using namespace std;

// https:leetcode.com/problems/contains-duplicate/

// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// approach 1 : set stores only unique elements in the vector. So if it's size is less than that of vector's, then it contains duplicates
// TC : O(N)
// SC : O(N)

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        return set<int>(nums.begin(),nums.end()).size()<nums.size();
    }
};


// approach 2 : use map. If element being visited found already before, return true
// TC : O(N)
// SC : O(N)

// class Solution {
// public:
//     bool containsDuplicate(vector<int>& nums) {
//         map<int, bool> mp;
//         for(int i=0; i<nums.size(); i++)
//         {
//             if(mp[nums[i]])
//                 return true;
//             mp[nums[i]] = true;
//         }
//     }
// };