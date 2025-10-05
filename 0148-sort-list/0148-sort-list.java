class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next=null;
        ListNode Ls = sortList(head);
        ListNode Rs = sortList(right);
        return merge(Ls,Rs);
    }
    ListNode merge(ListNode l,ListNode r){
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        while(l!=null && r!=null){
            if(l.val<r.val){
                tail.next = l;
                l = l.next;
            }else{
                tail.next = r;
                r = r.next;
            }tail = tail.next;
        }if(l!=null)tail.next=l;
        if(r!=null)tail.next=r;
        return dummy.next;

    }
    ListNode getMid(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }return slow;
    }
}