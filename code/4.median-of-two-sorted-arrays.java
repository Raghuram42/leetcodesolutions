class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) return findMedianSortedArrays(new int[0], nums2);
        if (nums2 == null) return findMedianSortedArrays(nums1, new int[0]);
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums1[mid] < nums2[k - mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        double candidate1 = Math.min(l == m ? Integer.MAX_VALUE : nums1[l], k - l == n ? Integer.MAX_VALUE : nums2[k - l]);
        if ((m + n) % 2 == 1) return candidate1;
        double candidate2 = Math.max(l == 0 ? Integer.MIN_VALUE : nums1[l - 1], k - l == 0 ? Integer.MIN_VALUE : nums2[k - l - 1]);
        return (candidate1 + candidate2) / 2;
    }
}