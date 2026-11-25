class Solution {
    private static final long BASE1 = 100003L;
    private static final long MOD1 = 1000000007L;
    private static final long BASE2 = 100019L;
    private static final long MOD2 = 1000000009L;
    public int smallestUniqueSubarray(int[] nums)
    {
        int n = nums.length;
        long[] h1 = new long[n+1];
        long[] p1 = new long[n+1];
        long[] h2 = new long[n+1];
        long[] p2 = new long[n+1];
        p1[0] = 1;
        p2[0] = 1;
        for (int i = 0; i < n; i++) {
            long val = nums[i] + 1000000001L;
            h1[i + 1] = (h1[i] * BASE1 + val) % MOD1;
            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + val) % MOD2;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;
        }
        int low = 1, high = n, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueSubarray(mid, n, h1, p1, h2, p2)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean hasUniqueSubarray(int len, int n, long[] h1, long[] p1, long[] h2, long[] p2) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i <= n - len; i++) {
            long hash1 = (h1[i + len] - (h1[i] * p1[len]) % MOD1 + MOD1) % MOD1;
            long hash2 = (h2[i + len] - (h2[i] * p2[len]) % MOD2 + MOD2) % MOD2;
            long combinedHash = (hash1 << 32) | hash2;
            freq.put(combinedHash, freq.getOrDefault(combinedHash, 0) + 1);
        }

        for (int count : freq.values())
            if (count == 1)
                return true;

        return false;
    }
}