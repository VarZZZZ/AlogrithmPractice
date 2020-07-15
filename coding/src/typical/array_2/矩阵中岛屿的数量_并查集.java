package typical.array_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: ly
 * @Date: 2020/7/14 21:06
 * @Version 1.0
 */
public class 矩阵中岛屿的数量_并查集 {
    //给一个 01 矩阵，求不同的岛屿的个数。
    //0 代表海，1 代表岛，如果两个 1 相邻，那么这两个 1 属于同一个岛。我们只考虑上下左右为相邻。

    /**
     * 大致思路：当前节点判断是否和左上两个节点根节点相同，如果不同(一定不同，每个节点最开始指向自己），
     * 且相邻，说明是同一个岛屿 count -= 1
     * 如果左上没有True，则当前是新的岛屿，count不变。（判断，右下效果一样）
     */
    private int numOfIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        // 位置(i,j)的编号为i*n+j
        int cnt = 0;
        Map<Integer,Integer> father = new HashMap<>(m*n+n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=1) continue;
                int k = i*n+j;
                father.put(k,k);
                cnt++;
            }
        }
        boolean b;  // 判断当前节点是否并入并查集
        // 将相邻的1 拼接起
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!=1) continue;
                int t1 = i*n+j;
                int t2 = t1-1; //左边的节点
                int t3 = t1-n; // 上边的节点
                 b= false;
                if(j>0&&grid[i][j]==grid[i][j-1]){
                    union(father,t1,t2);
                    b=true;
                }
                if(i>0&&grid[i][j]==grid[i-1][j]){
                    union(father,t1,t3);
                    b=true;
                }
                if(b) cnt--;
            }
        }

        return cnt;
    }

    private int findFather(Map<Integer,Integer> father,int k){
        Stack<Integer> st = new Stack<>();
        while(father.get(k)!=k){
            st.push(k);
            k = father.get(k);
        }
        while(!st.empty()){ // 摊开
            father.put(st.pop(),k);
        }
        return k;
    }

    private void union(Map<Integer,Integer> father,int t,int c){
        int f_t = findFather(father,t);
        int f_c = findFather(father,c);
        if(f_t!=f_c){
            father.put(f_t,f_c);
        }
    }

//    public static void main(String[] args) {
//        矩阵中岛屿的数量_并查集 A = new 矩阵中岛屿的数量_并查集();
//        int[][] grid = new int[][]{
//                {1,1,0,0,0},
//                {1,1,0,0,0},
//                {0,0,1,0,0},
//                {0,0,0,1,1}
//        };
//        int num = A.numOfIsland(grid);
//        System.out.println(num);
//    }

}
