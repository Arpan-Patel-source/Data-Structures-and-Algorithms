class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k)
    {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        int r = n-1;
        Deque<long[]> dq = new ArrayDeque<>();

        for (int l = n - 1; l >= 0; l--)
        {
            long val = nums[l];
            long cnt = 1;

            while (!dq.isEmpty() && dq.peekFirst()[0] <= val)
            {
                long[] prev = dq.pollFirst();
                cost += (val - prev[0]) * prev[1];
                cnt += prev[1];
            }

            dq.addFirst(new long[]{val, cnt});

            while (cost > k) {
                cost -= dq.peekLast()[0] - nums[r];
                dq.peekLast()[1]--;
                if (dq.peekLast()[1] == 0) {
                    dq.pollLast();
                }
                r--;
            }

            ans += r - l + 1;
        }
        return ans;
    }
}