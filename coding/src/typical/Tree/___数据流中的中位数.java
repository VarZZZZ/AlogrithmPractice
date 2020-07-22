package typical.Tree;

import 笔试.T;

/**
 * @Author: ly
 * @Date: 2020/7/20 17:33
 * @Version 1.0
 */
public class ___数据流中的中位数 {
    /**
     *
     void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     double findMedian() - 返回目前所有元素的中位数。
     */
    class TreeNode{
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode p){
            this.val = val;
            this.parent = p;
            left = null;
            right = null;
        }
        void addNum(int val){
            if(this.val>val){
                if(left==null){
                    left = new TreeNode(val,this);
                }else{
                    left.addNum(val);
                }
            }else{
                if(right==null){
                    right =  new TreeNode(val,this);
                }else{
                    right.addNum(val);
                }
            }
        }
        TreeNode next(){
            TreeNode res;
            if(right!=null){
                res = right;
                while(res.left!=null){
                    res = res.left;
                }
            }else{
                res = this;
                // 如果当前right==null，则找下一个大的值，需要到父节点里面找
                // 但如果当前节点为父节点的右子树，则需要继续往父节点搜索
                while(res.parent.right==res){
                    res = res.parent;
                }
                res = res.parent;
            }
            return res;
        }
        TreeNode pre(){
            TreeNode res;
            if(left!=null){
                res = left;
                while(res.right!=null){
                    res = res.right;
                }
            }else{
                res = this;
                while(res.parent.left==res){
                    res = res.parent;
                }
                res = res.parent;
            }
            return res;
        }
    }
    class MedianFinder {
        int n;
        TreeNode root;
        TreeNode cur; // 当前中位数

        /** initialize your data structure here. */
        public MedianFinder() {
            n=0;
            root=null;
            cur=null;
        }
        public void addNum(int num) {
            if(root==null){
                root = new TreeNode(num,null);
                cur = root;
                n++;
            }else{
                root.addNum(num);
                n++;
                if(n%2==1){
                    // 如果有偶数变成奇数了，且加进来的数位于中位数后面；
                    // 则中位数会向后移动一位
                    if(cur.val<=num){
                        cur = cur.next();
                    }
                }else{
                    if(cur.val>num){
                        cur = cur.pre();
                    }
                }
            }
        }
        public double findMedian() {
            if(n%2==1)
                return (double)cur.val;
            else{
                return (double)(cur.val+cur.next().val)/2;
            }
        }
    }
}

