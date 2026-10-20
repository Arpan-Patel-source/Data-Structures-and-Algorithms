class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int k = 1; k <= n; k++)
            if (n % k == 0)
                if (isValidDivisor(nums, k)) sum += k;
        return sum;
    }
    private boolean isValidDivisor(int[] nums, int k)
    {
        int lastMax = Integer.MIN_VALUE;
        int n = nums.length;
        int numBlocks = n / k;
        for (int block = 0; block < numBlocks; block++) {
            int start = block * k;
            int drops = 0;
            int dropIdx = -1;
            for (int i = 0; i < k; i++) {
                int currIdx = start + i;
                int nextIdx = start + (i + 1) % k;
                if (nums[currIdx] > nums[nextIdx]) {
                    drops++;
                    dropIdx = i;
                }
            }
            if (drops > 1) return false;

            int minVal, maxVal;
            if (drops == 1) {
                minVal = nums[start + (dropIdx + 1) % k];
                maxVal = nums[start + dropIdx];
            } else {
                minVal = nums[start];
                maxVal = nums[start + k - 1];
            }
            if (minVal < lastMax) return false;
            lastMax = maxVal;
        }
        return true;
    }
}