package typical.dp.程序代码指南;

public class C字符串是否能由字符串A_B交错组成 {

    // s1=AB s2 = 12  aim = AB12、A1B2、1AB2...保持相对顺序
    private boolean isCross(String s1,String s2,String aim){

        boolean[][]  dp = new boolean[s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                // 如果dp[i][j-1]能够组成aim[i+j-1 -1]，且s2[j]==aim[i+j-1]，那么dp[i][j]成立
                if(s1.charAt(i-1)==aim.charAt(i+j-1)&&dp[i-1][j] || (s2.charAt(j-1)==aim.charAt(i+j-1)&&dp[i][j-1])){
                    dp[i][j]=true;
                }
            }
        }
        return true;//错误的
    }
}
