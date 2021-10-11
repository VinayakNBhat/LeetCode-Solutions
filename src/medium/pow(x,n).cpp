//https://leetcode.com/problems/powx-n

//squared exponentiation

//TC : O(lg n)
//SC: O(1)

class Solution {
public:
    double myPow(double x, int n) {
        if(x==1.000 || n==0)  
            return 1;
        
        int y = abs(n);
        double z;
        
        if(y%2==1)
            z = x*myPow(x*x, (y-1)/2);
        else
            z = myPow(x*x, y/2);
        
        return n>0 ? z : 1/z;
    }
};
