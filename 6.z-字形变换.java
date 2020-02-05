/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows) return s;
        StringBuilder[] rb = new StringBuilder[numRows];
        int rIndex = 0;
        int step = 1;
        int i = 0;
        while (i < s.length()) {
            rIndex = Math.max(0, Math.min(numRows -1, rIndex));
            char c = s.charAt(i);
            if (rb[rIndex] == null) {
                rb[rIndex] = new StringBuilder();
            }
            rb[rIndex].append(c);
            if (rIndex + step >= numRows || rIndex + step < 0) {
                step *= -1;
            }
            rIndex += step;
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder sb :
             rb) {
            builder.append(sb.toString());
        }
        return builder.toString();
    }
}
// @lc code=end

