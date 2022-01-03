/**
//https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 TC:O(n)
 SC: O(1)
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        ListNode* temp = head;
        ListNode* temp1 = head;
        
        while(temp1 && n--)
            temp1 = temp1->next;
        
        if(!temp1)
        {
            head = head->next;
            delete(temp);
            return head; 
        } 
        
        while(temp1->next)
        {
            temp = temp->next;
            temp1 = temp1->next;
        }
        
        temp1 = temp->next;
        
        if(temp->next)
            temp->next = temp->next->next;
        
        delete(temp1);
        
        return head;
    }
};
