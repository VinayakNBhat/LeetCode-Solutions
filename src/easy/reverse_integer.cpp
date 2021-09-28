class Solution {
public:
    int reverse(int x) {
        int y = abs(x);
        int z = max(x, y);
        long s = 0;
        while(y)
        {
            s = s*10 + y%10;
            y/=10;
        }
        if(z!=x)
            s*=-1;
        if(s>INT_MAX || s<INT_MIN)
            return 0;
        return int(s);
    }
};
