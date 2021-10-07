//https://leetcode.com/problems/valid-parentheses

// using STL Stacks

class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        int n = s.size();
        char c;
        
        for(int i=0; i<n; i++)
        {
            c = s[i];
            if(c=='(' or c=='[' or c=='{')
                st.push(s[i]);
            else
            {
                if(c==')')
                {
                    if(st.empty() or st.top()!='(')
                        return false;
                    st.pop();
                }
                if(c==']')
                {
                    if(st.empty() or st.top()!='[')
                        return false;
                    st.pop();
                }
                if(c=='}')
                {
                    if(st.empty() or st.top()!='{')
                        return false;
                    st.pop();
                }
            }
        }
        if(st.empty())
            return true;
        return false;
    }
};
