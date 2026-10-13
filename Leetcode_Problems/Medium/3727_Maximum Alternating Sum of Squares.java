class Solution
{
    public long maxAlternatingSum(int[] nums)
    {
        long result = 0;
        int i;
        int left = 0;
        int right = nums.length-1;
        boolean add = true;
        for(i = 0; i<nums.length; i++)nums[i] = nums[i]*nums[i];
        Arrays.sort(nums);
        while(left<=right)
        {
            if(add == true)result = result + nums[right--];
            else result = result - nums[left++];
            add = !add;
        }
        return result;
    }
}