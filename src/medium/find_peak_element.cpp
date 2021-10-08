//https://leetcode.com/problems/find-peak-element

//binary search 

class Solution {
public:
    int findPeakElement(vector<int>& a) {
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
