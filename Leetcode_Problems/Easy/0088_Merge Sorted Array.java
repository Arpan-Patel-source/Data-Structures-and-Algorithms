class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int arrayNums1 = 0;
        int arrayNums2 = 0;

        for (int i = 0; i < m + n; i++) {
            if (arrayNums2 >= n || (arrayNums1 < m && nums1Copy[arrayNums1] <= nums2[arrayNums2])) {
                nums1[i] = nums1Copy[arrayNums1++];
            } else {
                nums1[i] = nums2[arrayNums2++];
            }
        }
    }
}
