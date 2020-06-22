package typical.string;

import java.util.*;

public class PalindromePartition_将字符串分割成所有回文组成的list {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) &&(i-j<=2 || dp[j+1][i-1]))
                    dp[j][i]=true;
            }
        }
        helper(res,new ArrayList<>(),s,dp,0);
        return res;

    }

    private void helper(List<List<String>> res,List<String> temp,String s,boolean[][] dp,int idx){
        if(idx==dp.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<dp.length;i++){
            if(dp[idx][i])
            {
                temp.add(s.substring(idx,i+1));
                helper(res,temp,s,dp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    //https://leetcode.com/problems/palindrome-partitioning-ii/submissions/
    // 最小 将s分割成回文的切割次数
    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] pd = new boolean[n][n];
        int[] mc = new int[n];
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=0;j<=i;j++){
                if(cs[i]==cs[j]&&(j+1>i-1 || pd[j+1][i-1])){
                    pd[j][i]=true;
                    min = j==0?0:Math.min(min,mc[j-1]+1);
                }
            }
            mc[i]=min;
        }
        return mc[n-1];
    }


}
