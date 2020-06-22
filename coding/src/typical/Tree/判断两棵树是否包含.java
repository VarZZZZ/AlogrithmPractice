package typical.Tree;

public class 判断两棵树是否包含 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static boolean contains(TreeNode t1,TreeNode t2){
        if(t2==null) return true;
        if(t1==null) return false;
        return check(t1,t2)||contains(t1.left,t2)||contains(t1.right,t2);
    }
    static boolean check(TreeNode t1,TreeNode t2){
        if(t2==null) return true;
        if(t1==null||t1.val!=t2.val) return false;
        return check(t1.left,t2.left)&&check(t1.right,t2.right);
    }

    // 如果是验证拓扑结构是否是相等或包含的，可以先序列化为字符串，再对字符串操作
}
