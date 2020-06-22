package typical.Tree.程序代码指南;

public class 树dp_判断是否为平衡树 {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    class ReturnType{
        boolean isBalance;
        int height;
        ReturnType(boolean is,int hei){
            isBalance=is;
            height=hei;
        }
    }
    // 不方便，直接后续递归遍历最好，同时求高度
    private ReturnType process(Node head){
        if(head==null) return new ReturnType(true,0);
        ReturnType left = process(head.left);
        ReturnType right = process(head.right);
        int hei = Math.max(left.height,right.height)+1;
        boolean is = left.isBalance&&right.isBalance&&Math.abs(left.height-right.height)<2;
        return new ReturnType(is,hei);
    }
}
