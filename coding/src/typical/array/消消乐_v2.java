package typical.array;

public class 消消乐_v2 {
    // 从数组中消去相同的值， 每次消除n个，得分为n*n,要求最后得分和最大

    // dp[i][j] 无论i, j 是否符合，无论i-1是否符合  i..j中，都不管，超过i-j的范围都由dp[i-z][j+1]考虑
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes,0,n-1,0,dp);


    }
    private int helper(int[] boxes,int i,int j,int m,int[][][] dp){
        if(i>j) return 0;
        if(dp[i][j][m]>0) return dp[i][j][m];

        for(;i+1<=j&&boxes[i+1]==boxes[i];i++,m++);
        int res = (m+1)*(m+1)+ helper(boxes,i+1,j,0,dp);   // 存在两种情况，一种是直接消除前头；二是消除中间;
        // m 表示前面i..j 左边已有的连续的与char[i]一致的字符串的长度

        for(int z=i+1;z<=j;z++){  // 第一次循环， char[i] 与 char[i+1]必定不相等;
            if(boxes[z]==boxes[i]){
                // 中间消除一块，右端拼到左端
                res = Math.max(res,helper(boxes,i+1,z-1,0,dp)+helper(boxes,z,j,m+1,dp));
            }
        }
        return res;

    }
}
