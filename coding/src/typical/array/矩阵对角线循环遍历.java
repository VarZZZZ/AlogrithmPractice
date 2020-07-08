package typical.array;

public class 矩阵对角线循环遍历 {
    //https://leetcode.com/problems/diagonal-traverse/
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        if(m==0) return new int[0];
        int n = mat[0].length;

        int[] res = new int[m*n];

        int r=0,c=0;
        for(int i=0;i<m*n;i++){       // 每一条线 r +c 都有奇偶之分
            res[i] = mat[r][c];
            // up
            if((r+c)%2==0){
                if(c==n-1) r++;
                else if(r==0) c++;
                else{
                    r--;
                    c++;
                }
            }else{
                if(r==m-1) c++;
                else if(c==0) r++;
                else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

}
