import 笔试.T;

import java.util.*;

public class Main {
    static int res = 0;



    // 参加会议-时间开始-结束-有房间数量
    private boolean[] meetingRooms(int[][] intervals,int room,int[][] ask){
        TreeMap<Integer,int[]> inter = new TreeMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(new int[]{intervals[i][0],intervals[i][1],-1});
        }
        for (int i = 0; i < ask.length; i++) {
            pq.offer(new int[]{ask[i][0],ask[i][1],i});
        }
        int[] roomHaving = new int[room];
        boolean contains = false;
        boolean[] askCon = new boolean[ask.length];
        int size=  pq.size();
        int l=0,r=0;
        while(r<size){

        }

        Stack<Integer> askIdx = new Stack<>();
//        for (Integer start : inter.keySet()) {
//            contains=false;
//            for(int i=0;i<room;i++){
//                if(roomHaving[i]<=start){
//                    roomHaving[i] = inter.get(start)[1];
//                    if(inter.get(start)[0]>=0){
//                        askIdx.push(inter.get(start)[0]);
//                    }
//                    contains=true;
//                    break;
//                }
//            }
//            if(!contains){
//            }
//        }




        return null;
    }

    public static void main(String[] args) {
        String[][] maps = new String[][]{{"S","."},{"#","T"}};
        System.out.println(maze(maps));
    }
    private static int maze(String[][] maps){
        int m = maps.length;
        int n =maps[0].length;
        int[] start = new int[2];
        int[] end = new int[2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(maps[i][j].equals("S")){
                    start[0]=i;
                    start[1]=j;
                }else if(maps[i][j].equals("T")){
                    end[0]=i;
                    end[1]=j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int path=0;
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size=  queue.size();
            while(size-->0){
                int[] cur = queue.poll();
                if(cur[0]==end[0]&&cur[1]==end[1]){
                    return path;
                }
                for(int i=0;i<dir.length;i++){
                    int x = cur[0]+dir[i][0];
                    int y = cur[1]+dir[i][1];
                    if(x>=0&&x<m&&y>=0&&y<n){
                        if(maps[x][y].equals("#")){
                            continue;
                        }
                        if(maps[x][y].equals("T")){
                            return path+1;
                        }
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            path++;
        }
        return path;
    }




}






