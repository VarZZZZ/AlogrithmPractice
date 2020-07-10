package typical.Tree;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/7/10 15:21
 * @Version 1.0
 */
public class 从上往下_从右往左_上帝视角看二叉树 {
    /**
     * 1.从右往左看，这个即求树的层数，只要构建树的时候加个小变量代表当前层数即可
     * 2.从右上往左下看，这个即求往右的最大深度，即只有往右的时候，看到的个数才会+1，同样设置个小变量即可
     * 3.从上往下看，这个可以看成树的宽度，设根节点为位置0，往左就是位置-1，往右就是位置+1，构建一遍树下来可以求出最小位置l和最大位置r
     */
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 从右往左看二叉树
     * 利用List的size()表示当前到第几层了，如果当前层数大于size(),则添加
     */
    private List<Integer> rightView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(res,0,root);
        return res;
    }
    private void helper(List<Integer> res, int level, TreeNode root) {
        if(root==null) return ;
        if(level==res.size()){
            res.add(root.val);
        }
        helper(res,level+1,root.right);
        helper(res,level+1,root.left);
    }

    /**
     * 从上倒下，垂直打印
     */
    private void downView(TreeNode root){
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();// key 为 -1/-2/0。。。value为节点值，如果是从上往下看，那么可以不用set
        int distance = 0;
        getVerticalOrder(root,distance,map);
        Iterator<Integer> ite = map.keySet().iterator();
        while(ite.hasNext()){
            Integer key = ite.next();
            for (Integer integer : map.get(key)) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    // 前序遍历，同一个key，上面的一定出现在下面的之前(LIST中）
    private void getVerticalOrder(TreeNode root,int dis,Map<Integer,List<Integer>> map){
        if(root==null) return;
        if (!map.containsKey(dis)) {
            map.put(dis,new ArrayList<>());
        }
        map.get(dis).add(root.val);

        getVerticalOrder(root.left,dis-1,map);
        getVerticalOrder(root.right,dis+1,map);
    }
}
