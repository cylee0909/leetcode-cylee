/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {

    // public String convert(String s, int nRows) {
    //     char[] c = s.toCharArray();
    //     int len = c.length;
    //     StringBuffer[] sb = new StringBuffer[nRows];
    //     for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
    //     int i = 0;
    //     while (i < len) {
    //         for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
    //             sb[idx].append(c[i++]);
    //         for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
    //             sb[idx].append(c[i++]);
    //     }
    //     for (int idx = 1; idx < sb.length; idx++)
    //         sb[0].append(sb[idx]);
    //     return sb[0].toString();
    // }

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) return s;
        StringBuilder[] rb = new StringBuilder[numRows];
        int rIndex = 0;
        int step = 1;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (rb[rIndex] == null) {
                rb[rIndex] = new StringBuilder();
            }
            rb[rIndex].append(c);
            if (rIndex == 0) step = 1;
            if (rIndex == numRows -1) step = -1;
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

