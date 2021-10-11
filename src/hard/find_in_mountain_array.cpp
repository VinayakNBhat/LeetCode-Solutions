//https://leetcode.com/problems/find-in-mountain-array

//binary search

/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int index);
 *     int length();
 * };
 */

class Solution {
public:
    int findInMountainArray(int target, MountainArray &a) {
        int n = a.length();
        
        int st=0, en=n-1, mid;
        
        while(st<en)
        {
            mid = (st+en)/2;
            
            if(a.get(mid) > a.get(mid+1))
                en = mid;
            
            else if(a.get(mid) < a.get(mid+1))
                st = mid+1;
        }
        
        int peak=st;
        //peak at st
        
            en = st;
            st = 0;
            while(st<=en)
            {
                mid = (st+en)/2;
                
                if(a.get(mid) == target)
                    return mid;
                
                if(a.get(mid)<target)
                    st = mid+1;
                
                else
                    en = mid-1;
            }
        
            st = peak+1;
            en = n-1;
            while(st<=en)
            {
                mid = (st+en)/2;
                cout<<st<<" "<<mid<<" "<<en<<endl;
                
                if(a.get(mid) == target)
                    return mid;
                
                if(a.get(mid)<target)
                    en = mid-1;
                
                else
                    st = mid+1;
            }
        
        return -1;
        
    }
};
