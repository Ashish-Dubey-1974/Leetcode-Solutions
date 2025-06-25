class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        ListNode temp = head;
        while(temp!=null){
            q.add(temp.val);
            temp=temp.next;
        }
        temp = head;
        while(temp!=null){
            temp.val=q.poll();
            temp=temp.next;
        }return head;

    }
}