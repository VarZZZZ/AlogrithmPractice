package typical.Tree.程序代码指南;

public class 树dp_二叉树中节点间的最大距离 {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    // 树dp第一步： 以某个节点x为头结点的子树中，分析答案来自哪些的可能性
    //      1) 以x为头结点的字数，最大距离可能是左子树上的最大距离
    //      2) 。。。。。。。。。，最大距离可能是右子树上的，，，，
    //      3）                  ，最大距离可能是从X的左子树里X最远的节点，先到x，在走到x的右子树里x最远的节点，也就是
                    //左子树高度+右子树高度+1
    // 树dp第二步:根据第一步的可能性分析，列出所有需要的信息，左子树和右子树都需要知道自己这颗树上的最大距离，以及高度
    // 树dp第散步：根据第二部信息汇总，定义信息如returnType:
    class ReturnType{
        int maxDistance;
        int height;

        ReturnType(int maxDistance,int height){
            this.maxDistance=maxDistance;
            this.height=height;
        }
    }
    ReturnType process(Node head){
        if(head==null)
            return new ReturnType(0,0);
        ReturnType left = process(head.left);
        ReturnType right = process(head.right);

        int height = Math.max(left.height,right.height)+1;
        int maxDistance = Math.max(left.height+right.height+1,Math.max(left.maxDistance,right.maxDistance));//要不然就不包括当前节点，要不然就必然包括当前节点
        return new ReturnType(maxDistance,height);
    }

}
