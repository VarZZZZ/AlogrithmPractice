package 笔试._2020.小红书____重要优化点;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 魔物攻击 {
    //薯队长来到了迷宫的尽头，面前出现了N只魔物，Hi表示第i只魔物的血量，薯队长需要在T个回合内击败所有魔物才能获胜。
    // 每个回合薯队长可 以选择物理攻击一只魔物，对其造成1点伤害（物理攻击次数无上限）;
    // 或者消耗1点法力释放必杀技对其造成固定X点伤害（薯队长开始拥有M 点法力）。
    // 问X至少多大，薯队长才有机会获胜；如果无论如何都无法在T回合内获胜，则输出-1

    //第一行三个整数分别表示：N，T，M 第二行有N个整数：H1，H2，H3...HN

    //我们把问题分解成两个子问题：
    //
    //1.已知 必杀技伤害X 验证能否获胜
    //2.二分查找能够获胜的最小伤害X
    //
    //考虑二分查找的上下边界：
    //
    //    平A即可取胜，此时为X的下界0
    //    技能秒杀任意怪，此时为X的上界为怪物的最大血量，伤害更高没有意义
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        if(n>t){
            System.out.println("NO");
            return;
        }
        int m = sc.nextInt();
        int[] h = new int[n];
        int sm=0;
        for(int i=0;i<n;i++){
            h[i] = sc.nextInt();
            sm +=h[i];
        }
        if(m>t){
            m=t;//最大能使用法力值也就使用 t次
        }
        if(t>=sm){
            System.out.println(0);
            return; //平A取胜
        }
        Arrays.sort(h);
        // 二分查找
        int l=0,r=h[n-1];


    }
    private static int find(int[] h,int n,int t,int m,int mid){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(o2-o1));
        for(int i=0;i<n;i++){
            pq.offer(h[i]);
        }



        return -1;

    }
}
