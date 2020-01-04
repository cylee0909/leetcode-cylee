/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        boolean overFlow = false;
        while(l1 != null || l2 != null || overFlow){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int r = v1 + v2 + (overFlow ? 1 : 0);
            overFlow = r > 9;
            r %= 10;
            ListNode newNode = new ListNode(r);
            if (result == null) {
                result = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }
}
// @lc code=end

