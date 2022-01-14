package leetcode.editor.cn;

//树可以看成是一个连通且 无环 的 无向 图。 
//
// 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信
//息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。 
//
// 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: edges = [[1,2],[1,3],[2,3]]
//输出: [2,3]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
//输出: [1,4]
// 
//
// 
//
// 提示: 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ai < bi <= edges.length 
// ai != bi 
// edges 中无重复元素 
// 给定的图是连通的 
// 
//
// 
//
// 注意：本题与主站 684 题相同： https://leetcode-cn.com/problems/redundant-connection/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 11 👎 0

public class SevenLpjUW{
    public static void main(String[] args) {
        Solution solution = new SevenLpjUW().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }

        int[] father = new int[maxVertex + 1];
        for (int i = 1; i <= maxVertex; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(father, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }

    private int findFather(int[] father, int i) {
        if (father[i] != i) {
            father[i] = findFather(father, father[i]);
        }
        return father[i];
    }
    private boolean union(int[] father, int i, int j) {
        int fatherOfI = findFather(father, i);
        int fatherOfJ = findFather(father, j);
        if (fatherOfI != fatherOfJ) {
            father[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}