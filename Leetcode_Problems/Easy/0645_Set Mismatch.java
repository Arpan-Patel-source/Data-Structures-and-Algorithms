import java.util.Arrays;
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int missing = 1; 
        int duplicate = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicate = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            missing = nums.length;
        }
        result[0] = duplicate;
        result[1] = missing;
        return result;
    }
}
