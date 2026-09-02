class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int k = 1;
        int p2 = 1;
        while(p2<nums.length)
        {
            if(nums[p2]==nums[p2-1]){
            p2++;
            continue;
            }
            nums[++p1] = nums[p2++];
            k++;
        }
        return k;
    }
}