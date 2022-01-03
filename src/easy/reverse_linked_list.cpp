
//https://leetcode.com/problems/reverse-linked-list
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 
 method 1: iterative (slightly more efficient)
 method 2: recursive 
 TC: O(n)
 SC: O(1)
 */

class Solution {
public:
    ListNode* rev(ListNode* cur)
    {
        if(cur == NULL)    
            return cur;
        
        ListNode* t;
        ListNode* l = cur->next;
        cur->next = NULL;
        
        while(l != NULL)
        {
            t = l->next;
            l->next = cur;
            cur = l;
            l = t;
        }
        
        return cur;
        
        // if(cur == NULL || cur->next == NULL)    return cur;
        // ListNode* h = rev(cur->next);
        // cur->next->next = cur;
        // cur->next = NULL;
        // return h;
    }
    
    ListNode* reverseList(ListNode* head) {
       return rev(head);  
    }
};
