package typical.Tree;

/**
 * @Author: ly
 * @Date: 2020/7/25 15:50
 * @Version 1.0
 */
public class 两棵树有限次左右子树翻转是否相等 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    private boolean isEqual(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null) return false;
        if(root2==null) return false;
        if(root1.val==root2.val){
            return isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right)
                    ||isEqual(root1.right,root2.left)&&isEqual(root1.left,root2.right);
        }
        return false;
    }

}

