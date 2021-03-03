package typical.string;

import java.util.Scanner;

public class ____2020_美团_字符串模式匹配 {

    //正则匹配
    //给你一个字符串 s 和一个字符规律 p，
    // 请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    //
    //'.' 匹配任意单个字符
    //'*' 匹配零个或多个前面的那一个元素
    //
    //https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-solution/

    class Solution {
        public boolean isMatch(String s, String p) {
            char[] sc = s.toCharArray();
            char[] pc = p.toCharArray();
            int sn = sc.length;
            int pn = pc.length;
            boolean[][] dp = new boolean[sn+1][pn+1];
            dp[0][0] = true;
            // 需要以长度为单位，s可以为0长度，如果以下标为单位会出错
            for(int i=0;i<=sn;i++){
                for(int j=1;j<=pn;j++){
                    if(pc[j-1]=='*'){
                        // 因为可以匹配0次，也可以匹配多次，只要匹配即可，所以用|
                        dp[i][j] |= dp[i][j-2]; //匹配0次时，直接比较sc[i] 和pc[j-2]的匹配程度。

                        if(i>0&&(sc[i-1]==pc[j-2]||pc[j-2]=='.')){   //当可以匹配多次时，如abbb 和ab*;  在最后的b和*时，sc[3]==pc[1]时，比较sc[2]和pc[2]
                            // 相当于扔掉s[i-1]，再进行匹配，因为*可以模拟多个s[i-1]，即相当于同时去掉一个s[i-1].
                            dp[i][j] |= dp[i-1][j];
                        }
                    }else{
                        if(i>0&&(sc[i-1]==pc[j-1]||pc[j-1]=='.')){
                            dp[i][j] |= dp[i-1][j-1];
                        }
                    }
                }
            }
            return dp[sn][pn];
        }
    }

}
