class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int p1=0, p2=1,i;
        for(i=0;i<nums.length-1;i++)
        {
            if(nums[p1++]==nums[p2++])return true;
        }
        return false;
    }
}