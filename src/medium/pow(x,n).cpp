class Solution {
public:
    double myPow(double x, long n) {
        if(x==1 || n==0)  return 1;
        
          if(n>0)
          {
              if(n%2==1)
                  return x*myPow(x*x, (n-1)/2);
              else
                  return myPow(x*x, n/2);
          }
          else
          {
           
            if((-1*n)%2==1)
                  return (1/x)*myPow(x, n+1);
              else
                  return myPow(1/(x*x), -1*n/2);
          }
    }
};
