package typical.Tree.面试问题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ly
 * @Date: 2020/7/28 22:27
 * @Version 1.0
 */
public class 最小高度树_树的重心 {
    /**
     * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，
     * 在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，
     * 写出一个函数找到所有的最小高度树并返回他们的根节点。
     */

    /**
     * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     * <p>
     * 0
     * |
     * 1
     * / \
     * 2   3
     * <p>
     * 输出: [1]
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 一层一层删除叶子节点。先删除最外围，然后删除新成的叶子节点
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 叶子节点
            if (adj.get(i).size() == 1) {
                ls.add(i);
            }
        }
        while (n > 2) {
            n -= ls.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer l : ls) {
                Integer nei = adj.get(l).iterator().next();
                adj.get(nei).remove(l);
                if(adj.get(nei).size()==1){
                    newLeaves.add(nei);
                }
            }
            ls=newLeaves;
        }
        return ls;
    }


    //https://blog.csdn.net/zhanxufeng/article/details/80715185


}
