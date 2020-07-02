package typical.string.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/1 23:29
 * @Version 1.0
 */
public class 字符串切割成回文子串的最小分割数 {

    private int minCut(String str){
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] dp = new int[len+1]; // dp[i] 表示子串str[i..len-1]至少切割几次
        dp[len] = -1;
        boolean[][] f = new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i] = Integer.MAX_VALUE;
            for(int j=i;j<len;j++){ // 找到切割点j，使得i.(j).到len-1切割次数最小
                if(chars[i]==chars[j]&&(j-i<2||f[i+1][j-1])){   // 判断i .i+1...j-1..j是否是回文
                    f[i][j]=true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}
