package typical.Tree;

/**
 * @Author: ly
 * @Date: 2020/7/7 22:17
 * @Version 1.0
 */
class Node{
    int val;
    Node left;
    Node right;
    Node(int v){
        this.val=v;
    }
}
public class Tree_基本问题 {

    /**
     * 将数组转化为二叉排序数
     * @param arr
     */
    private void arr2bst(int[] arr){

    }
    private Node addNode(int k,Node root){
        if(root==null) return new Node(k);
        if(root.val==k) return null;
        if(root.val<k){
            root.right=addNode(k,root.right);
        }else{
            root.left=addNode(k,root.left);
        }
        return root;
    }

    /**
     * 二叉树是否对称
     */
    private boolean isSym(Node root){
        if(root==null) return true;
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left==null||root.right==null) return false;
        if(root.left.val==root.right.val){
            return isSym(root.left)&&isSym(root.right);
        }
        return false;
    }








}
