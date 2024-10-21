public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int advance = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + advance;
            advance = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l1, new ListNode(advance));
            else
                cur.next = l1;
        }else if(l2 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l2, new ListNode(advance));
            else
                cur.next = l2;
        }else if(advance != 0){
            cur.next = new ListNode(advance);
        }
        return head.next;
    }
}
