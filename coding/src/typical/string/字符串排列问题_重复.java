package typical.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/8/5 23:14
 * @Version 1.0
 */
public class 字符串排列问题_重复 {
    /**
     * 超时---
     * @param
     * @return
     */
//    public String[] permutation(String s) {
//        char[] sc = s.toCharArray();
//        Arrays.sort(sc);
//        List<String> res = new ArrayList<>();
//        dfs(sc,res,new StringBuilder(),new boolean[sc.length]);
//        return res.toArray(new String[0]);
//    }
    private void dfs(char[] sc,List<String> res,StringBuilder sb,boolean[] f){
        if(sb.length()==sc.length){
            String t = sb.toString();
            if(!res.contains(t)){
                res.add(t);
            }
            return;
        }
        for(int i=0;i<sc.length;i++){
            if(!f[i]){
                sb.append(sc[i]);
                f[i]=true;
                dfs(sc,res,sb,f);
                f[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    /**
     * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
     *输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     */
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
    private void dfs(int idx){ // 看作二叉树问题
        if(idx==c.length-1){
            res.add(new String(c));
            return;
        }
        boolean[] f = new boolean[26];
        for(int i=idx;i<c.length;i++){       // 将排序看作是给每个位置idx选择一个字符
            if(f[c[i]-'a']) continue;  // 当前位置已经出现过该字符c[i]了，避免重复
            f[c[i]-'a']=true;
            swap(i,idx);    // 将位置i的字符赋值到idx位置； 每次交换，将未使用的字符替换到当前位置的后面去，这样可以不用for flag判断
            dfs(idx+1);
            swap(i,idx);
        }
    }
    private void swap(int a,int b){
        char t = c[b];
        c[b]=c[a];
        c[a]=t;
    }

}
