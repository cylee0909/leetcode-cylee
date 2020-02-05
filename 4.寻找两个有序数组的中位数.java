import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] d = null;
        if (nums1.length == 0) {
            d = nums2;
        }
        if (nums2.length == 0) {
            d = nums1;
        }
        if (d != null) {
            return (d[(d.length -1) / 2] + d[d.length / 2]) / 2f;
        }
        int len = nums1.length + nums2.length;
        return (findK2(nums1, 0, nums2, 0, (len + 1) / 2) + findK2(nums1, 0, nums2, 0, (len + 2) / 2)) / 2d;
    }

    public static int findK(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if (s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int mid1 = s1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[s1 + k / 2 - 1];
        int mid2 = s2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[s2 + k / 2 -1 ];
        if (mid1 < mid2) {
            return findK(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        } else {
            return findK(nums1, s1 , nums2, s2 + k / 2, k - k / 2);
        }
    }

    public static int findK2(int[] nums1, int s1, int[] nums2, int s2, int k) {
        int l = Math.max(k - nums2.length, 0), r = Math.min(nums1.length, k);
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums1[m] < nums2[k - m - 1]) {
                // 搜索区间[m + 1, r]
                l = m + 1;
            } else {
                r = m;
            }
        }
        // index1 = i - 1 ; i = l
        int index1 = l - 1;
        // index2 = j - 1; j = k - i
        int index2 = k - l - 1;
        int v1 = index1 >= 0 ? nums1[index1] : Integer.MIN_VALUE;
        int v2 = index2 >= 0 ? nums2[index2] : Integer.MIN_VALUE;
        return Math.max(v1, v2);
    }
}
// @lc code=end

