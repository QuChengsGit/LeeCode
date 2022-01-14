package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
//sequence/ 
// Related Topics 并查集 数组 哈希表 👍 13 👎 0

import java.util.*;

public class WhsWhI{
    public static void main(String[] args) {
        Solution solution = new WhsWhI().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> iterator = set.iterator();
            longest = Math.max(longest, bfs(set, iterator.next()));
        }
        return longest;
    }

    private int bfs(Set<Integer> set, int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        set.remove(num);
        int length = 1;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int[] neighbors = new int[]{i - 1, i + 1};
            for (int neighbor : neighbors) {
                if (set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.remove(neighbor);
                    length++;
                }
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}