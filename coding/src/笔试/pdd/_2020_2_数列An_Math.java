package 笔试.pdd;

import java.util.Scanner;

public class _2020_2_数列An_Math {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] na = new int[T];
        int maxN = 0;
        int i=0;
        while(T-->0){
            int N = sc.nextInt();
            maxN = Math.max(N,maxN);
            na[i++]=N;
        }
        int[] f_min = new int[maxN+1];
        int[] f_max = new int[maxN+1];
        f_min[1]=1;
        f_max[1]=1;
        f_min[2]=1;
        f_max[2]=1;
        // max 其实就是  1。。n 之间的相减最大，那么只要当前让最大的减最小的即可
        // min , 其实就是相减相减轮询；  2-1  4-3 :N=4=》1-1=0  N=6: 6-5 4-3  2-1=》结果为1 1-1+1=1
        for(i=3;i<=maxN;i++){
            f_max[i] = Math.abs(i-f_min[i-1]);
            f_min[i] = (((i+1)/2)%2==0)?0:1;  // 此处没搞懂；
        }
        for(i=0;i<na.length;i++){
            System.out.println(f_min[na[i]]+" "+f_max[na[i]]);

        }
    }
}
