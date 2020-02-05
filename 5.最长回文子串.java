/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = "";
        char[] d = s.toCharArray();
        for (int i = 0; i < d.length; i++) {
            char cc = d[i];
            int l = i - 1;
            while (l >= 0) {
                if (d[l] == cc) {
                    l--;
                } else {
                    break;
                }
            }
            int r = i + 1;
            while (r < d.length) {
                if (d[r] == cc) {
                    r++;
                } else {
                    break;
                }
            }

            while (l >= 0 && r < d.length) {
                if (d[l] == d[r]) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            if (r > l) {
                if (result.length() < r - l - 1) {
                    result = s.substring(l + 1, r);
                }
            }
        }
        return result;
    }
}
// @lc code=end

