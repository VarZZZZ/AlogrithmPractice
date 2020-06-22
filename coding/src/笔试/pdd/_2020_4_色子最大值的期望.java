package 笔试.pdd;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _2020_4_色子最大值的期望 {
    //http://39.108.236.169:8080/article/2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX=-1;
        int T = sc.nextInt();
        int TT = T;
        int[] x = new int[T+1];
        int i=0;
        while(T-->0){
            x[i] = sc.nextInt();
            MAX = Math.max(MAX,x[i]);
            i++;
        }
        double pre=0.0;
        double sum=0;
        for(i=1;i<=MAX;i++){
            double tp = 1.0;
            for(int j=0;j<TT;j++){
                tp *= Math.min(x[j],i)/(float)x[j];
            }
            sum +=(tp-pre)*i;
            pre = tp;
        }
        DecimalFormat dec = new DecimalFormat(".00");
        System.out.println(dec.format(sum));
    }
}
