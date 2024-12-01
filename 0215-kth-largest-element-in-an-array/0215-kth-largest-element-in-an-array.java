class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums)heap.add(i);
        for(int i=0;i<k-1;i++)heap.remove();
        return heap.remove();
    }
}