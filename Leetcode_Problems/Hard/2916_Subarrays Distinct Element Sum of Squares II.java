public class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] sumVal;
    private long[] sumSq;
    private long[] lazy;
    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumVal = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        long totalSumSquares = 0;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        for (int r = 0; r < n; r++) {
            int l = lastSeen.containsKey(nums[r]) ? lastSeen.get(nums[r]) + 1 : 0;
            updateRange(1, 0, n-1, l, r, 1);
            lastSeen.put(nums[r], r);
            totalSumSquares = (totalSumSquares + sumSq[1]) % MOD;
        }

        return (int) totalSumSquares;
    }

    private void pushLazy(int node, int start, int end) {
        if (lazy[node] == 0) return;

        long val = lazy[node];
        long rangeSize = end - start + 1;
        sumSq[node] = (sumSq[node] + 2 * val % MOD * sumVal[node] % MOD + val * val % MOD * rangeSize % MOD) % MOD;
        sumVal[node] = (sumVal[node] + rangeSize * val) % MOD;
        if (start != end) {
            lazy[2 * node] = (lazy[2 * node] + val) % MOD;
            lazy[2 * node + 1] = (lazy[2 * node + 1] + val) % MOD;
        }

        lazy[node] = 0;
    }

    private void updateRange(int node, int start, int end, int queryL, int queryR, int val) {
        pushLazy(node, start, end);

        if (start > queryR || end < queryL) return;
        if (start >= queryL && end <= queryR) {
            long rangeSize = end - start + 1;
            sumSq[node] = (sumSq[node] + 2 * val % MOD * sumVal[node] % MOD + (long) val * val % MOD * rangeSize % MOD) % MOD;
            sumVal[node] = (sumVal[node] + rangeSize * val) % MOD;

            if (start != end) {
                lazy[2 * node] = (lazy[2 * node] + val) % MOD;
                lazy[2 * node + 1] = (lazy[2 * node + 1] + val) % MOD;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        updateRange(2 * node, start, mid, queryL, queryR, val);
        updateRange(2 * node + 1, mid + 1, end, queryL, queryR, val);
        sumVal[node] = (sumVal[2 * node] + sumVal[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }
}
