package leetcode.editor.cn;

//给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// 
//
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 17 👎 0

public class VvXgSW {
    public static void main(String[] args) {
        Solution solution = new VvXgSW().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

   /* public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }*/

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0 || lists == null) {
                return null;
            }
            return merge(lists, 0, lists.length-1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            ListNode node1 = merge(lists, left, mid);
            ListNode node2 = merge(lists, mid + 1, right);
            return mergeTwoLists(node1, node2);
        }

        private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
            ListNode preHead = new ListNode();
            ListNode pre = preHead;
            while (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    pre.next = node1;
                    node1 = node1.next;
                } else {
                    pre.next = node2;
                    node2 = node2.next;
                }
                pre = pre.next;
            }
            pre.next = node1 == null ? node2 : node1;
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}