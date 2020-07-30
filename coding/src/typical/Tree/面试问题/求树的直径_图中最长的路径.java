package typical.Tree.面试问题;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/7/28 22:38
 * @Version 1.0
 */
public class 求树的直径_图中最长的路径 {
    /**
     * 先，先将无根树转成有根树，
     * 定义F[i]表示从i出发向远离根节点的方向走的最长路径的长度，
     * G[i]表示从i向远离根节点的方向走的次长路径的长度。
     * 注意F[i]和G[i]不能沿着i的同一个儿子走。
     * 特别地，如果i只有一个儿子，那么G[i]=0。答案为max(F[i]+G[i])。
     *
     * 注意F[i]是向原理根节点的方向走
     */
    int maxPath = 0;
    private int getLong(Map<Integer, List<Integer>> map){
        Set<Integer> st = new HashSet<>();
        int root = map.keySet().iterator().next();
        st.add(root);
        Map<Integer,Integer> f = new HashMap<>();
        Map<Integer,Integer> g = new HashMap<>();
        dfs(map,st,root,f,g);

        return maxPath;
    }
    private void dfs(Map<Integer, List<Integer>> map,Set<Integer> st,int root,
                     Map<Integer,Integer> f,Map<Integer,Integer> g){
        f.put(root,0);
        g.put(root,0);
        for (Integer nei : map.get(root)) {
            if(!st.contains(nei)){
                st.add(nei);
                dfs(map,st,nei,f,g);
                st.remove(nei);
                // 先搜索到最底层-远离root的最远端点
                if(f.get(root)<f.get(nei)+1){//如果发现了一条更长的路径，那么更新f[x]和g[x]。
                    g.put(root,f.get(root));
                    f.put(root,f.get(nei)+1); // 如果root只有一条nei，那么会出现g[root]=0
                }else if(g.get(root)<f.get(nei)+1){
                    g.put(root,f.get(nei)+1);
                }
            }
        }
        maxPath = Math.max(maxPath,f.get(root)+g.get(root));
    }

}
