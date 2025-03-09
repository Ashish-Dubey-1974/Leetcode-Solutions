class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length==0)return null;
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for(ListNode head : lists){
        while(head!=null){
            q.add(head.val);
            head=head.next;
        }
    }
    if(q.size()==0)return null;
    ListNode head = new ListNode(q.poll());
    ListNode temp = head;
    while(!q.isEmpty()){
        ListNode nn = new ListNode(q.poll());
        temp.next = nn;
        temp = nn;
    }
    return head;
  }
}