package 笔试.wangyi;

import java.util.Scanner;

public class _2020_2_16_积木_3个操作_正式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n  = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            long n_sm = 0;
            int i=0;
            for(i=0;i<n;i++){
                arr[i] = sc.nextInt();
                n_sm +=arr[i];
                if(n_sm+m<((long)i*(i+1)/2)){
                    System.out.println("NO");
                    break;
                }
            }
            if(i==n){
                System.out.println("YES");
            }

        }
    }


}
