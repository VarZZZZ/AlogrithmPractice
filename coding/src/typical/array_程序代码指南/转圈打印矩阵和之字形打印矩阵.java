package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/2 23:13
 * @Version 1.0
 */
public class 转圈打印矩阵和之字形打印矩阵 {

    // spiral
    private void spiralPrint(int[][] matrix){
        int tR=0;
        int tC=0;
        int dR=matrix.length-1;
        int dC=matrix[0].length-1;
        while(tR<=dR&&tC<=dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);// tR,dR,为打印的上边界和下边界。
        }
    }
    private void printEdge(int[][] matrix,int tR,int tC,int dR,int dC){ // 打印一圈

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
