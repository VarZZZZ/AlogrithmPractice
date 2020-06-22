package typical.Tree.程序代码指南;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化反序列化树 {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    // 序列化一棵树
    private String serialByPre(Node head){
        if(head==null){
            return "#!";
        }
        String res = head.val+"!";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return res;
    }

    // 反序列
    private Node deserialByPre(String str){
        String[] vals = str.split("!");
        Queue<String> q = new LinkedList<>();
        for(String v:vals){
            q.offer(v);
        }
        return helper(q);
    }
    private Node helper(Queue<String> q){
        String val = q.poll();
        if(val.equals("#")){
            return null;
        }
        Node n = new Node(Integer.parseInt(val));
        n.left=helper(q);
        n.right=helper(q);
        return n;
    }
}
