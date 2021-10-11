//https://leetcode.com/problems/single-element-in-a-sorted-array

//binary search application

class Solution {
public:
    int singleNonDuplicate(vector<int>& v) {
        int n = v.size();
        
        if(n<3)
            return v[0];
        
        int st=0, en=n-1, mid;
        
        while(st<=en)
        {
            mid = st + (en-st)/2;
            
            if(mid == 0 || mid == n-1 || v[mid]!=v[mid-1] && v[mid]!=v[mid+1])
                return v[mid];
            
            if((mid%2==0 && v[mid]==v[mid-1]) || (mid%2==1 && v[mid]==v[mid+1]))
                en = mid-1;
            else
                st = mid+1;    
        }
        
        return -1;
    }
};
