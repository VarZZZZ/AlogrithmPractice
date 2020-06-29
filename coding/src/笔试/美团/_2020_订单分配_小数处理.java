package 笔试.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// N皇后
public class _2020_订单分配_小数处理 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] nums = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextDouble();
            }
        }

        List<Integer> tmp = new ArrayList<>();
        boolean[] flag = new boolean[n];
        double rs = -1000.00;
        System.out.println(String.format("%.2f",rs));

    }
    private static List<Integer> res;
    private static double rs = -1000.00;
    private static void dfs(List<Integer> tmp,double[][] nums,int curIdx,double tpMax,double curSum,boolean[] flag){
        if(curIdx==nums.length){
            if(curSum>tpMax){
                tpMax=curSum;
                res = new ArrayList<>(tmp);
            }
        }
        double res=0;
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                flag[i]=true;
                curSum += nums[curIdx][i];
                tmp.add(i);

                dfs(tmp,nums,curIdx+1,tpMax,curSum,flag);
            }
        }

    }
}
