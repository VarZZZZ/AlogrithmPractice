package typical.Tree.面试问题;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/7/17 11:53
 * @Version 1.0
 */
public class 有两种数据_分别是被转发的用户和转发的用户_求原视频的用户以及转发的最长深度 {
    /**
     * from：1，1，2，2，3，6
     * to： 2，3，4，5，6，7
     */
    class Node{
        int val;
        List<Node> next;
        Node(int val){
            this.val = val;
            next = new ArrayList<>();
        }
    }

    private int sol(int[] from,int[] to){
        Map<Integer,Node> map = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < from.length; i++) {
            int f = from[i];
            int t = to[i];
            if(!map.containsKey(f)){
                map.put(f,new Node(f));
            }
            if(!map.containsKey(t)){
                map.put(t,new Node(t));
            }
            Node fn = map.get(f);
            Node tn = map.get(t);
            st.add(t);
            fn.next.add(tn);
        }


        return 0;

    }

}
