import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if (map.containsKey(target-c)) {
                int result = map.get(target-c);
                if (result != i) {
                    return new int[]{result, i};
                }
            }
        }
        return null;
    }
}
// @lc code=end

