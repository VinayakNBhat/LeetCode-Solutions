//https://leetcode.com/problems/add-two-numbers


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* l = new ListNode(0);
        ListNode* head = l, *temp=l;
        int x;
        
        while(l1!=NULL && l2!=NULL)
        {
            x = l->val + l1->val + l2->val;
            l->val = x%10;
            l->next = new ListNode(x/10);
            temp = l;
            l = l->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        while(l1!=NULL)
        {
            x = l->val + l1->val;
            l->val = x%10;
            l->next = new ListNode(x/10);
            temp = l;
            l = l->next;
            l1 = l1->next;
        }
        
        while(l2!=NULL)
        {
            x = l->val + l2->val;
            l->val = x%10;
            temp = l;
            l->next = new ListNode(x/10);
            l = l->next;
            l2 = l2->next;
        }
        
        if(l->val == 0)
            temp->next = NULL;
        
        return head;
    }
};
