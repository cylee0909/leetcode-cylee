import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {

    // 滑动窗口，采用map记录
    // public static int lengthOfLongestSubstring(String s) {
    //     int n = s.length(), ans = 0;
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for (int end = 0, start = 0; end < n; end++) {
    //         char alpha = s.charAt(end);
    //         if (map.containsKey(alpha)) {
    //             start = Math.max(map.get(alpha), start);
    //         }
    //         ans = Math.max(ans, end - start + 1);
    //         map.put(s.charAt(end), end + 1);
    //     }
    //     return ans;
    // }

    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
                if (list.size() > result) {
                    result = list.size();
                }
            } else {
                list.add(c);
                while(!list.pollFirst().equals(c));
            }
        }
        return result;
    }
}
// @lc code=end

