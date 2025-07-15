class Solution {
    int ans,cnt;
    public int getDecimalValue(ListNode head) {
        helper(head);
        return ans;
    }
    void helper(ListNode h){
        if(h==null)return;
        helper(h.next);
        ans+=Math.pow(2,cnt++)*h.val;
    }
}