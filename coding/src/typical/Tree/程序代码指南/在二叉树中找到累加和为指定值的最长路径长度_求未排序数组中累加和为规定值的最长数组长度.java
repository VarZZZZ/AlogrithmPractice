package typical.Tree.程序代码指南;

import java.util.HashMap;
import java.util.Map;

public class 在二叉树中找到累加和为指定值的最长路径长度_求未排序数组中累加和为规定值的最长数组长度 {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    //二叉树中路径长度如果不回折，则表示层数
    private int getMaxLen(Node head,int k){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        return helper(head,k,0,1,0,map);

    }
    private int helper(Node head,int k,int preSum,int level,int maxLen,Map<Integer,Integer> map){
        if(head==null) return maxLen;
        int curSum = preSum+head.val;

        if(!map.containsKey(curSum)){
            map.put(curSum,level);
        }
        if(map.containsKey(curSum-k)){
            maxLen =  Math.max(maxLen,level-map.get(curSum-k));
        }
        maxLen = helper(head.left,k,curSum,level+1,maxLen,map);
        maxLen = helper(head.right,k,curSum,level+1,maxLen,map);
        if(level==map.get(curSum)){
            map.remove(curSum); // 回退; 如果level== map.get() 则表明是当前节点 加入了map.put(curSum,level);
        }
        return maxLen;
    }


}
