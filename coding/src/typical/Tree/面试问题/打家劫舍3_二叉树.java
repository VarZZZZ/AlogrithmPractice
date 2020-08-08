package typical.Tree.面试问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ly
 * @Date: 2020/8/5 10:43
 * @Version 1.0
 */
public class 打家劫舍3_二叉树 {
//    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
//    这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
    /**
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     *
     */

     class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public int rob(TreeNode root) {
            return dfs(root,new HashMap<>());
        }
        private int dfs(TreeNode root, Map<TreeNode,Integer> map){
            if(root==null) return 0;
            if(map.containsKey(root)) return map.get(root);
            int val=0;

            if(root.left!=null){
                val += dfs(root.left.left,map)+dfs(root.left.right,map);
            }
            if(root.right!=null)
                val += dfs(root.right.left,map)+dfs(root.right.right,map);
            int tmp = Math.max(val+root.val,dfs(root.left,map)+dfs(root.right,map));
            map.put(root,tmp);
            return tmp;
        }
    }

}
