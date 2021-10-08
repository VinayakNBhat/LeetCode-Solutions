//https://leetcode.com/problems/find-smallest-letter-greater-than-target

//binary search

class Solution {
public:
    char nextGreatestLetter(vector<char>& s, char target) {
        int n = s.size();
        
        int st=0, en=n-1, mid;
        
        if(target>=s[n-1])
            return s[0];
        
        while(st<=en)
        {
            mid = st + (en-st)/2;
            
            if(s[mid]<=target)
                st = mid+1;
            else
                en = mid-1;
        }
        
        return s[st];
    }
};
