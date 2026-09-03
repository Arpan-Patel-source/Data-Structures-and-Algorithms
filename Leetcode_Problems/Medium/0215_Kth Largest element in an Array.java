class Solution {
    public int findKthLargest(int[] nums, int k) {
        int val=0;
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) pq.add(num);
        while(k!=0)
        {val = pq.poll();
        k--;
        }
        return val;
    }
}