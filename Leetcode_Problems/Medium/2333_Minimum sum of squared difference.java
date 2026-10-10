class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2)
    {
        long totalMoves = (long) k1 + k2;
        int n = nums1.length;
        int[] diffs = new int[n];
        int maxDiff = 0;
        long sumOfDiffs = 0;
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            sumOfDiffs += diffs[i];
            if (diffs[i] > maxDiff) {
                maxDiff = diffs[i];
            }
        }
        if (sumOfDiffs <= totalMoves) {
            return 0;
        }
        int[] counts = new int[maxDiff + 1];
        for (int d : diffs) {
            counts[d]++;
        }
        for (int size = maxDiff; size > 0; size--) {
            if (counts[size] == 0) continue;
            long movesUsed = Math.min(totalMoves, (long) counts[size]);

            counts[size] -= movesUsed;
            counts[size - 1] += movesUsed;

            totalMoves -= movesUsed;

            if (totalMoves == 0) {
                break;
            }
        }

        long totalResult = 0;
        for (int size = 1; size <= maxDiff; size++) {
            if (counts[size] > 0) {
                totalResult += (long) counts[size] * size * size;
            }
        }
        return totalResult;
    }
}
