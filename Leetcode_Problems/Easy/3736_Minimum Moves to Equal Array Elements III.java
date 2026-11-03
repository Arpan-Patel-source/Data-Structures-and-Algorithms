class Solution {
    public int minMoves(int[] nums)
    {
        int valMax = nums[0];
        long totalSum = 0;
        for (int num : nums) {
            if (num > valMax)
                valMax = num;

            totalSum += num;
        }

        return (int) ((long) valMax * nums.length - totalSum);
    }
}