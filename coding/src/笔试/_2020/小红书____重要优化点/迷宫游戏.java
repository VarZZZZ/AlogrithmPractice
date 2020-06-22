package 笔试._2020.小红书____重要优化点;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 迷宫游戏 {
    //薯队长最近在玩一个迷宫探索类游戏，
    // 迷宫是一个N*N的矩阵形状，其中会有一些障碍物禁止通过。
    // 这个迷宫还有一个特殊的设计，它的左右 边界以及上下边界是连通的，
    // 比如在(2,n)的位置继续往右走一格可以到(2,1)，
    // 在(1,2)的位置继续往上走一格可以到(n,2)。请问薯队长从起点位置S，
    // 最少走多少格才能到达迷宫的出口位置E。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        int[] startIdx = new int[2];
        int[] endIdx = new int[2];
        for(int i=0;i<n;i++){
            String tmp = sc.next();
            for(int j=0;j<n;j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='S'){
                    startIdx[0]=i;
                    startIdx[1]=j;
                }else if(map[i][j]=='E'){
                    endIdx[0]=i;
                    endIdx[1]=j;
                }
            }
        }
        System.out.println(bfs(map,startIdx,endIdx));
    }

    private static int bfs(char[][] map,int[] startIdx,int[] endIdx){
        int n = map.length;
        boolean[][] isVisit = new boolean[n][n];
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(startIdx);
        isVisit[startIdx[0]][startIdx[1]]=true;
        int len=0;
        while(!qu.isEmpty()){
            int size=qu.size();
            while(size-->0){
                int[] cur = qu.poll();
                if(cur[0]==endIdx[0]&&cur[1]==endIdx[1])
                    return len;
                // right
                int i=cur[0],j=cur[1];
                j = (cur[1]+1)%n;
                if(map[i][j]!='#'&&!isVisit[i][j]){
                    qu.offer(new int[]{i,j});isVisit[i][j]=true;
                }
                j = cur[1];
                // up
                i = cur[0]==0?n-1:cur[0]-1;
                if(map[i][j]!='#'&&!isVisit[i][j]){
                    qu.offer(new int[]{i,j});
                    isVisit[i][j]=true;
                }
                i=cur[0];
                // down
                i=(cur[0]+1)%n;
                if(map[i][j]!='#'&&!isVisit[i][j]){
                    qu.offer(new int[]{i,j});isVisit[i][j]=true;
                }
                i=cur[0];
                //left
                j = cur[1]==0?n-1:cur[1]-1;
                if(map[i][j]!='#'&&!isVisit[i][j]){
                    qu.offer(new int[]{i,j});isVisit[i][j]=true;
                }
                j = cur[1];
            }
            len++;
        }
        return -1;
    }



}
