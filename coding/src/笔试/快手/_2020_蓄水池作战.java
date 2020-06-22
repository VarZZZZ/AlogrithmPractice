package 笔试.快手;

// 在你面前有n个蓄水池，他们组成了树形结构（由n-1条边连接）。蓄水池节点编号从1开始到n。对每个蓄水池节点来说，
// 他的儿子蓄水池节点都摆放在他的下面，并且和它用水管相连，根据重力，水会向下流动。现在我们要在蓄水池上做一些操作：
//1. 把节点v填满水。然后v的所有儿子节点水也会被填满
//2. 清空节点v的水。然后v所有的父亲节点水都会被清空
//3. 询问每个蓄水池节点是否有水。
//初始状态时候，每个节点都是空的。
//现在我们会依次进行一系列操作，我们想提前知道每次操作后的结果，你能帮忙解决吗？

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

// 第一行包含一个正整数n(1<=n<=1000)，表示蓄水池节点的数量。
//后面n-1行，每行有两个数字a[i], b[i]。（1<=a[i], b[i]<= n, a[i]!=b[i])表示蓄水池的连接关系。
//接下来的一行包含一个整数q(1<=q<=1000)，表示我们要进行的操作的数量。
//最后的q行中，每行包含两个数字c[i] (1<=c[i]<=3)和v[i](1<=v[i]<=n)。其中c[i]表示操作类型(1,2或者3)。v[i]表示操作对应的蓄水池节点。
//输入数据保证合理，是一个连通的树。
class Node{
    int val;
    Node left;
    Node right;
    Node parent;
    boolean w;
    Node(int val){
        this.val=val;
    }
}
public class _2020_蓄水池作战 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Node> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>b){
                int t = a;
                a = b;
                b = t;
            }
            Node t=null;
            if(map.containsKey(a)){
                t = map.get(a);
                if(t.left==null){
                    Node bb = new Node(b);
                    bb.parent=t;
                    t.left=bb;
                    map.put(b,bb);
                }else{
                    Node bb = new Node(b);
                    bb.parent=t;
                    t.right=bb;
                    map.put(b,bb);
                }
            }else{
                t = new Node(a);
                Node bb = new Node(b);
                bb.parent=t;
                t.left = bb;
                map.put(a,t);
                map.put(b,bb);
            }

        }
        int q = sc.nextInt();
        int[][] qq = new int[q][2];

        for(int i=0;i<q;i++){
            qq[i][0] = sc.nextInt();
            qq[i][1]=sc.nextInt();
        }
        for(int i=0;i<q;i++){
            if(qq[i][0]==1){
                pullWater(map.get(qq[i][1]));
            }else if(qq[i][0]==2){
                outWater(map.get(qq[i][1]));
            }else{
                System.out.println(map.get(qq[i][1]).w ?1:0);
            }
        }
    }
    private static void pullWater(Node node){
        if(node==null) return;
        node.w=true;
        pullWater(node.left);
        pullWater(node.right);
    }
    private static void outWater(Node node){
        if(node==null) return;
        node.w=false;
        outWater(node.parent);
    }//


    //创建hashset
    static HashSet<Integer>[] adj;
    static boolean[] full;
    public static  void main2(){

    }
}
