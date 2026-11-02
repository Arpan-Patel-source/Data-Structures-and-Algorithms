class Solution {
    public int minMoves(int[] nums) {
        final long sum = Arrays.stream(nums).asLongStream().sum();
        final int mn = Arrays.stream(nums).min().getAsInt();
        return (int) (sum - (long) mn * nums.length);
    }
}
