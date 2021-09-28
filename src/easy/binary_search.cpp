class Solution {
public:
    int search(vector<int>& v, int n) {
        int st = 0;
        int en = v.size()-1;
        int m;
        
        while(st<=en)
        {
            m = (st+en)/2;
            if(v[m] == n)
                return m;
            if(v[m]>n)
                en = m-1;
            else
                st = m+1;
        }
        
        return -1;
    }
};
