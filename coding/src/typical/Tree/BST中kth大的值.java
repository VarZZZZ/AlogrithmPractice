package typical.Tree;

 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class BST中kth大的值 {
    int temp=0;
    int idx=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return temp;
    }
    private void inOrder(TreeNode root,int k){
        if(temp!=0){
            return;
        }
        if(root==null) return;
        inOrder(root.left,k);
        idx++;
        if(idx==k){
            temp=root.val;
            return;
        }
        inOrder(root.right,k);
    }
}
