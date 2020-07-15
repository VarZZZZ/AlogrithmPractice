package 笔试.字节;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/7/15 16:48
 * @Version 1.0
 */
public class _2019_数组元素组合问题_间隔 {
    //https://blog.csdn.net/missxy_/article/details/93050545
    private static int num=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt(); //任意两个元素之间的间隔不得超过d
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // n个建筑物的位置
        }
        dfs(arr,0,d,-1,0);
        System.out.println(num);
    }
    private static void dfs(int[] arr,int idx,int d,int pre,int curNum){
        if(curNum==3){
            num++;
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(pre==-1){
                dfs(arr,i+1,d,arr[i],1);
            }else{
                if(arr[i]-pre>d) return;
                if(arr[i]==pre) continue;
                dfs(arr,i+1,d,pre,curNum+1);
            }
        }
    }
}
