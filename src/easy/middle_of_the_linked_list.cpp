//https://leetcode.com/problems/middle-of-the-linked-list

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

//two pointer method
//TC: O(n) //:n/2
//SC: O(1)

class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* temp = head->next;
        
        if(!temp)
            return head;
        
        while(temp)
        {
            temp = temp->next;
            head = head->next;
            if(temp)
                temp = temp->next;
        }
        
        return head;
    }
};
