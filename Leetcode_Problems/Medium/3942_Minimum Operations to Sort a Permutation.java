class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int idxZero = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] == 0) { idxZero = i; break; }
        boolean isForward = true, isBackward = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i - idxZero + n) % n) isForward = false;
            if (nums[i] != (idxZero - i + n) % n) isBackward = false;
        }
        int ans = Integer.MAX_VALUE;
        if (isForward) {
            ans = Math.min(ans, idxZero);
            ans = Math.min(ans, n - idxZero + 2);
        }
        if (isBackward) {
            ans = Math.min(ans, idxZero + 2);
            ans = Math.min(ans, n - idxZero);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
