package typical.array.程序代码面试指南;

public class 最长公共子序列_最长公共子串_删除最小字符数使两个字符串相等 {


    // 子序列   --与删除最小字符数使两个字符串相等问题一致
    //1a2c3d4e5f  b1d23ca45; => 12345
    private int[][] getdp(char[] str1,char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0]==str2[0]?1:0;
        for(int i=1;i<str1.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],str1[i]==str2[0]?1:0);
        }
        for(int j=1;j<str2.length;j++){
            dp[0][j] = Math.max(dp[0][j-1],str1[0]==str2[j]?1:0);
        }

        for(int i=1;i<str1.length;i++){
            for(int j=1;j<str2.length;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str1[i]==str2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }

    private String lcse(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getdp(ch1,ch2);
        int m = ch1.length-1;
        int n = ch2.length-1;
        char[] res = new char[dp[m][n]];
        int idx=res.length-1;
        while(idx>=0){
            if(n>0&&dp[m][n]==dp[m][n-1]){
                n--;
            }else if(m>0&&dp[m][n]==dp[m-1][n]){
                m--;
            }else{
                // 如果dp[m][n]> dp[m-1][n] 且dp[m][n-1]。则计算dp[m][n]时必然选择了dp[m-1][n-1]+1
                res[idx--]=ch1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    //最长公共子串问题
    //1AB2345CD   '12345EF'  => 2345                             //子序列的d[i][j]是指 0-i,0-j的最长长度，结果返回去dp[n][m];
    private int[][] getdp2(char[] str1,char[] str2){          // dp[i][j]是指包括字符[i][j]的最长长度 , 结果返回dp中的最大值
        int[][] dp = new int[str1.length][str2.length];
        for(int i=1;i<str1.length;i++){
            if(str1[i]==str2[0]){
                dp[i][0] = 1;
            }

        }
        for(int j=1;j<str2.length;j++){
            if(str2[j]==str1[0]){
                dp[0][j] = 1;
            }

        }
        for(int i=1;i<str1.length;i++){
            for(int j=1;j<str2.length;j++){
                if(str1[i]==str2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        return dp;
    }

    //求字符串时，先找到最大值，在根据最大值，以及所处的位置，利用substring求得
}
