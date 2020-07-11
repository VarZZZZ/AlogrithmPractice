package typical.graph;

/**
 * @Author: ly
 * @Date: 2020/7/10 16:03
 * @Version 1.0
 */
public class 二维矩阵中求岛的个数 {
    // grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    // 求岛的个数，  =3
    public int numIslands(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(grid[i][j]!='1') return;
        grid[i][j]='x';
        if(i+1<grid.length)
            dfs(grid,i+1,j);
        if(i-1>=0)
            dfs(grid,i-1,j);
        if(j+1<grid[0].length)
            dfs(grid,i,j+1);
        if(j-1>=0)
            dfs(grid,i,j-1);
    }
}
