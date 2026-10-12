import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[31];
        long MOD = 1_000_000_007;
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++){
                if (((num >> bit) & 1) == 1) bitCounts[bit]++;
            }
        }
        long totalSumOfSquares = 0;
        for (int i = 0; i <k; i++) {
            long currentNumber = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCounts[bit] > 0) {
                    currentNumber |= (1L << bit);
                    bitCounts[bit]--;
                }
            }

            long squaredValue = (currentNumber * currentNumber) % MOD;
            totalSumOfSquares = (totalSumOfSquares + squaredValue) % MOD;
        }
        return (int) totalSumOfSquares;
    }
}
