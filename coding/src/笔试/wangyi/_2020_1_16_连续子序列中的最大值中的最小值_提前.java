package 笔试.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2020_1_16_连续子序列中的最大值中的最小值_提前 {
    //https://www.nowcoder.com/question/next?pid=20791008&qid=800697&tid=33897302
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int[] res = new int[n];
        for(int i=1;i<=array.length;i++){ // i 表示 间隔长度，从1到array.length
            int left = 0,right = left+i;
            int tp = Integer.MAX_VALUE;
            while(right<=array.length){
                int st = Integer.MIN_VALUE;
                for(int j=left;j<right;j++){
                    st = Math.max(st,array[j]);
                }
                left++;
                right++;
                tp = Math.min(tp,st);
            }
            res[i-1] = tp;
        }
        for(int r:res){
            System.out.print(r+" ");
        }



    }
}
