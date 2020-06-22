package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//字符串S由小写字母构成，长度为n。
//        定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
//        询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
public class ____ByteDance_2018_2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m =sc.nextInt();
        int res=1;
        for(char c='a';c<='z';c++){
            List<Integer> pos = new ArrayList<>();
            for(int i=0;i<str.length();i++){
                if(c==str.charAt(i)){
                    pos.add(i);
                }
            }
            if(pos.size()<2) continue;
            int[][] dp =new int[pos.size()][pos.size()];
            int ans = 1;
            for(int len=2;len<=pos.size();len++){
                for(int i=0;i<=pos.size()-len;i++){
                    dp[i][i+len-1]= dp[i+1][i+len-2]+pos.get(i+len-1)-pos.get(i) +1 -len; // +1+len是为了让两端的
                    //的两个值移动到dp[i+1][i+len-2]的两端。
                    if(dp[i][i+len-1]<=m){
                        ans = len;
                    }
                }
            }
            res = Math.max(res, ans);
        }
        System.out.println(res);

    }
}
