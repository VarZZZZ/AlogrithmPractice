package typical.Tree.程序代码指南;

// 树形dp过程： 先遍历左子树搜集信息，再遍历右子树，最后再头结点做信息整合
public class 树dp_找到二叉树中最大搜索二叉树 {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    class ReturnType{
        Node maxBSTHead;
        int maxBSTSize;
        int min;
        int max;
        ReturnType(Node maxBSTHead,int maxBSTSize,int min,int max){
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }
    private ReturnType process(Node x){ // 返回的值不一定是包括node x的，也可能返回的是x的子节点
        if(x==null) return new ReturnType(null,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        ReturnType lData = process(x.left);
        ReturnType rData = process(x.right);
        int min = Math.min(x.val,Math.min(lData.min,rData.min));
        int max = Math.max(x.val,Math.max(lData.max,rData.max));
        int maxBSTSize = Math.max(lData.maxBSTSize,rData.maxBSTSize);
        Node maxBSTHead = lData.maxBSTSize>=rData.maxBSTSize?lData.maxBSTHead:rData.maxBSTHead;

        // 判断是否可以同时包含左右两个字数
        if(lData.maxBSTHead==x.left&&rData.maxBSTHead==x.right&&x.val>lData.max&&x.val<rData.min){
            maxBSTHead = x;
            maxBSTSize=lData.maxBSTSize+rData.maxBSTSize+1;
        }
        return new ReturnType(maxBSTHead,maxBSTSize,min,max);
    }
}
