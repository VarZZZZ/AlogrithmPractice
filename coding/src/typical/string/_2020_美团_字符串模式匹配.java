package typical.string;

import java.util.Scanner;

public class _2020_美团_字符串模式匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String s = sc.next();

        int m = s.length(),n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            dp[0][i] = dp[0][i-1]&&p.charAt(i-1)=='*';
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        System.out.println(dp[m][n]?1:0);
    }



}
