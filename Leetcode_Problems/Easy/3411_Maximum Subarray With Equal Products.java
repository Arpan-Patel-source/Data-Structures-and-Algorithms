class Solution {
    public int maxLength(int[] nums)
    {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long currentGcd = nums[i];
            long currentLcm = nums[i];

            for (int j = i; j < n; j++) {
                long num = nums[j];
                product = product * num;

                long gcd = 1;
                long min = Math.min(currentGcd, num);
                for (long k = 1; k <= min; k++)
                    if (currentGcd % k == 0 && num % k == 0)
                        gcd = k;
                currentGcd = gcd;

                long max = Math.max(currentLcm, num);
                long lcm = max;
                while (lcm % currentLcm != 0 || lcm % num != 0)
                    lcm = lcm + max;
                currentLcm = lcm;

                if (product == currentGcd * currentLcm)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}
