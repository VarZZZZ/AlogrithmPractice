package 笔试;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ByteDance_2018_3_2_推箱子_规划路径 {
    private static int p_x,p_y;
    private static int b_x,b_y;
    private static int e_x,e_y;
    private static char[][] mp;
//    int p_x,p_y;  // 人的位置;
//    int b_x,b_y; // 箱子的位置;
//    int e_x,e_y; //终点
    static class Node{
        int px,py,bx,by,step_cnt;
        public Node(int px, int py, int bx, int by, int step_cnt) {
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
            this.step_cnt = step_cnt;
        }
    }
    static boolean[][][][] vt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        mp = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mp[i][j] = sc.nextLine().charAt(0);
                if(mp[i][j]=='S'){
                    p_x=i;p_y=j;
                }else if(mp[i][j]=='0'){
                    b_x=i;b_y=j;
                }else if(mp[i][j]=='E'){
                    e_x=i;e_y=j;
                }
            }
        }
        vt = new boolean[n][m][n][m]; // 人 和箱子 的已访问位置
        System.out.println(bfs(new Node(p_x,p_y,b_x,b_y,0)));
    }
    public static boolean judge(int px,int py){
        if(px<0||px>mp.length||py<0||py>mp[0].length||mp[px][py]=='#'){
            return false;
        }
        return true;
    }

    public static int bfs(Node n){
        int[][] dir ={{0,1},{0,-1},{-1,0},{1,0}};
        PriorityQueue<Node> que = new PriorityQueue<>((a,b)->{  // 普通队列也行
            if(a.step_cnt<b.step_cnt) return -1;
            else return 1;
        });
        que.offer(n);
        vt[n.px][n.py][n.bx][n.by] = true;
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.bx==e_x&&cur.by==e_y){
                return cur.step_cnt;
            }
            for(int i=0;i<4;i++){
                int ppx = cur.px+dir[i][0];
                int ppy = cur.py+dir[i][1];
                int bbx = cur.bx;
                int bby = cur.by;
                if(judge(ppx,ppy)){
                    if(ppx==bbx&&ppy==bby){
                        bbx = cur.bx+dir[i][0];  // 相同方向推动箱子
                        bby = cur.by + dir[i][1];
                        if(!judge(bbx,bby)) continue;
                    }
                    if(vt[ppx][ppy][bbx][bby]) continue;
                    vt[ppx][ppy][bbx][bby] = true;  // 按广度遍历，最先到达的节点即最短
                    que.offer(new Node(ppx,ppy,bbx,bby,cur.step_cnt+1));
                }
            }
        }
        return -1;
    }
}
