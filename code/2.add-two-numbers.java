class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ln = null, curr = null;
        while(l1 != null || l2 != null){
            int v1 = 0, v2 = 0;
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int v = sum % 10;
            if(ln == null){
                ln = new ListNode(v);
                curr = ln;
            }else{
                curr.next = new ListNode(v);
                curr = curr.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return ln;
    }
}