/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        //Cal the size of the LL.
        int size = 0;
        ListNode tem = head;
        while(tem!= null){
            tem = tem.next;
            size++;
        }
        
        if(size == n){
            head = head.next;
            return head;
        }
        ListNode curr = head;
        int i = 1;
        while(i<size-n){
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }
}