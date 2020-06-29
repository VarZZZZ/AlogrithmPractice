package typical.dp.程序代码指南;

public class 最小编辑代价 {
    // 给定两个字符串，给定3个整数ic,dc,rc,分别表示插入，删除和替换一个字符的代价，返回将str1编辑成str2的最小代价；

    //方法一：经典dp

    private int minCost(String str1,String str2,int ic,int dc,int rc){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        int row=ch1.length+1;
        int col = ch2.length+1;
        int[][] dp = new int[row][col];
        for(int i=1;i<row;i++){
            dp[i][0] = dc*i;
        }
        for(int i=1;i<col;i++){
            dp[0][i] = ic*i;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + rc; // 替换的代价
                }
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ic); // 先从i转换成j-1,再在尾部插入一个字符
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+dc); // 先将i删除一个字符，再将i-1转化为j；
            }
        }
        return dp[row-1][col-1];
    }
}
