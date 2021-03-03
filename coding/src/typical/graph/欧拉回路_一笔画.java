package typical.graph;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/8/27 9:19
 * @Version 1.0
 */
public class 欧拉回路_一笔画 {
    /**
     * 给定一个 nnn 个点 mmm 条边的图，要求从指定的顶点出发，经过所有的边恰好一次（可以理解为给定起点的「一笔画」问题），使得路径的字典序最小。
     https://leetcode-cn.com/problems/reconstruct-itinerary/solution/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
     */

    /**
     * 对于无向图 GGG，GGG 是欧拉图当且仅当 GGG 是连通的且没有奇度顶点。
     *
     * 对于无向图 GGG，GGG 是半欧拉图当且仅当 GGG 是连通的且 GGG 中恰有 222 个奇度顶点。
     *
     * 对于有向图 GGG，GGG 是欧拉图当且仅当 GGG 的所有顶点属于同一个强连通分量且每个顶点的入度和出度相同。
     *
     * 对于有向图 GGG，GGG 是半欧拉图当且仅当 GGG 的所有顶点属于同一个强连通分量且
     *
     *     恰有一个顶点的出度与入度差为 111；
     *
     *     恰有一个顶点的入度与出度差为 111；
     *
     *     所有其他顶点的入度和出度相同。
     */

    /**
     * Hierholzer 算法用于在连通图中寻找欧拉路径，其流程如下：
     *
     *     1.从起点出发，进行深度优先搜索。
     *
     *     2.每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
     *
     *     3.如果没有可移动的路径，则将所在节点加入到栈中，并返回。
     *
     * 一个有向欧拉图与起点有关，起点不同，是否欧拉图也可能不同
     * 如果确定起点是欧拉图时，则最后一个访问节点必定是出入度不同的，必然是最后一个访问节点
     可以改变入栈的规则，当我们遍历完一个节点所连的所有节点后，我们才将该节点入栈（即逆序入栈）。
     */
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket:tickets){
            String src  = ticket.get(0),dst = ticket.get(1);
            if(!map.containsKey(src)){
                map.put(src,new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }
    private void dfs(String cur){
        while(map.containsKey(cur)&&map.get(cur).size()>0){
            String tmp = map.get(cur).poll();
            dfs(tmp);
        }
        res.add(cur);

    }




}

