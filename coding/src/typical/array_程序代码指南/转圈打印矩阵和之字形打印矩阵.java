package typical.array_程序代码指南;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/7/2 23:13
 * @Version 1.0
 */
public class 转圈打印矩阵和之字形打印矩阵 {

    // spiral
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int left=0,right=m-1;
        int top=0,bottom = n-1;
        while(left<=right&&top<=bottom){
            printEdge(arr,left++,right--,top++,bottom--);
        }
    }
    private static void printEdge(int[][] arr,int left,int right,int top,int bottom){
        int i=top;
        int j = left;
        if(left==right){
            while(i<=bottom){
                System.out.print(arr[i++][j]+" ");
            }
            return;
        }
        if(top==bottom){
            while(j<=right){
                System.out.print(arr[i][j++]+" ");
            }
            return;
        }
        while(i<bottom){           // 不要用 i<=bottom #####
            System.out.print(arr[i++][j]+" ");
        }
        while(j<right){
            System.out.print(arr[i][j++]+" ");
        }
        while(i>top){
            System.out.print(arr[i--][j]+" ");
        }
        while(j>left){
            System.out.print(arr[i][j--]+" ");
        }
    }

    // 之
    // 1 2 3 4
    // 5 6 7 8
    // 9 10 11 12
    //print 1 2 5 9 6 3; 一根线穿过

    private void printZig(int[][] m){
        int tR= 0;
        int tC=0;
        int dR=0;
        int dC=0;
        int endR=m.length-1;
        int endC=m[0].length-1;
        boolean fromUp = false;
        while(tR!=endR+1){
            printLevel(m,tR,tC,dR,dC,fromUp);
        }
    }

    private void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp) {
        if(fromUp){

        }else{
            while(dR!=tR-1){
                System.out.print(m[dR--][dC++]+" ");
            }
        }
    }

}
