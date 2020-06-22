package typical.Tree;
import java.util.*;
public class ZigZag遍历树 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int l=0;
        while(!q.isEmpty()){
            int size = q.size();
            l++;
            List<Integer> tmp = new LinkedList<>();
            while(size-->0){
                TreeNode t = q.poll();
                if(l%2!=0){
                    tmp.add(t.val);
                }else{
                    tmp.add(0,t.val);
                }
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }
            res.add(tmp);

        }
        return res;
    }


}
