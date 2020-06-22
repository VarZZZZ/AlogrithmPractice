package typical.must_member;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



public class Traversal_非递归遍历 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }


    // 输入 split等对\,.等需要\\. \\\转义
    // sc.nextInt() 和sc.nextLine()不能混用

    // 前序遍历 非递归 1
    private String preOrder1(TreeNode tree){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(tree);
        while(!st.isEmpty()){
            TreeNode p = st.pop();
            sb.append(p.val);
            if(p.right!=null) st.push(p.right);
            if(p.left!=null) st.push(p.left);
        }

        return sb.toString();
    }
    // 中序遍历
    private List<Integer> inOrder(TreeNode root){
        List<Integer> res  = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!st.isEmpty()){
            while(cur!=null){
                st.push(cur);
                cur=cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(p!=null||!st.isEmpty()){
            if(p!=null){
                st.push(p);
                res.add(0,p.val);
                p=p.right;
            }else{
                p = st.pop();
                p=p.left;
            }
        }
        return res;
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode h = root;
        TreeNode c = null;
        while(!st.isEmpty()){
            c = st.peek();
            if(c.left!=null&&h!=c.left&&h!=c.right){
                st.push(c.left);
            }else if(c.right!=null&&h!=c.right){
                st.push(c.right);
            }else{
                res.add(st.pop().val);
                h = c;
            }
        }
        return res;
    }
    // morris遍历，不用栈结构遍历
    // 假设当前节点为cur
    //1.如果cur为nul，则过程停止，否则继续
    //2.如果cur没有左子树，则让cur向右移动，令cur=cur.right;
    //3.如果cur有左子树,则找到cur左子树上最右的节点，记为mostRight;
    //  1)如果mostRight.right==null,则让mostRight.right=cur,然后cur=cur.left;
    //  2)如果mostRight.right==cur,则让mostRight.right==null,cur=cur.right;
    private void morrisPre(TreeNode head){
        if(head==null) return ;
        TreeNode cur = head;
        TreeNode mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null){
                    mostRight.right=cur;
                    System.out.println(cur.val+" ");
                    cur = cur.left;
                    continue; //直接跳出，不向右子树走，向左子树
                }else{
                    mostRight.right=null;
                }
            }else{
                System.out.println(cur.val+" ");
            }
            cur=cur.right;
        }
    }
}
