//https://leetcode.com/problems/peak-index-in-a-mountain-array

//binary search

class Solution {
public:
    int peakIndexInMountainArray(vector<int>& a) {
        int n = a.size();
        
        int st=0, en=n-1, mid;
        
        while(st<en)
        {
            mid = st + (en-st)/2;
            
            if(a[mid]>a[mid+1])
                en = mid;
            
            else 
                st=mid+1;
        }
        
        return st;
    }
};
