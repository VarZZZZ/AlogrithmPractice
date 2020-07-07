package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/2 23:16
 * @Version 1.0
 */
public class 正方形矩阵90度旋转 {
    // 顺时针
    // 与转圈打印同理；
    private void rote(int[][] matrix){
        int tR=0;
        int tC=0;
        int dR=matrix.length-1;
        int dC=matrix[0].length-1;
        while(tR<=dR&&tC<=dC){
           roteEdge(matrix,tR++,tC++,dR--,dC--);// tR,dR,为打印的上边界和下边界。
        }
    }
    private void roteEdge(int[][] m,int tR,int tC,int dR,int dC){ // 画个图出来
        int times = dC-tC; // 边的长度，也就是要转换的次数
        int tp = 0;
        for(int i=0;i!=times;i++){
            tp = m[tR][tC+i];
            m[tR][tC+i] = m[dR-i][tC];
            m[dR-i][tC] = m[dR][dC-i];
            // ...
        }
    }
}
