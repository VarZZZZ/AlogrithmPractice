package typical.Tree.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/10 22:54
 * @Version 1.0
 */
public class 找到图树中一条最长的路径 {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    /**
     * d[u]表示节点u到叶子节点的路径最大值
     * max1 表示节点u到叶子节点的路径最大值
     * max2 表示u到叶子节点的路径次大值
     * d[u] = max1
     * ans = d[u],max1,max2中的最大值和次大值的和
     *
     * 为什么不直接dfs?
     */


    /**
     * 树中最长的路径
     * 打印树中最长的路径
     */
    int maxLen = 0;
    private int getMaxPath(Node root){

        if(root==null) return 0;
        int left = getMaxPath(root.left)+1;
        int right = getMaxPath(root.right)+1;
        return Math.max(left,right);
    }




}
