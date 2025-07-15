class Solution {
    static int ans;
    static int cnt;
    public int getDecimalValue(ListNode head) {
        ans=0;
        cnt=0;
        helper(head);
        return ans;
    }
    void helper(ListNode h){
        if(h==null)return;
        helper(h.next);
        ans+=Math.pow(2,cnt++)*h.val;
    }
}