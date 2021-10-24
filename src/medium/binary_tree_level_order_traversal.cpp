https://leetcode.com/problems/binary-tree-level-order-traversal

//using Queue

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> v;
        vector<int> x;
        
        if(!root)
            return v;
        
        q.push(root);
        
        while(!q.empty())
        {
            int c = q.size();
            
            while(c--)
            {
                TreeNode* y = q.front();
                x.push_back(y->val);
                
                if(y->left) 
                    q.push(y->left);
                
                if(y->right) 
                    q.push(y->right);
                
                q.pop();
            }
             
            v.push_back(x);
            x.clear();
        }
        
        
        return v;
    }
};
