package typical.string;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: ly
 * @Date: 2020/7/22 21:20
 * @Version 1.0
 */
public class 删除最小数量的无效括号 {
    /**
     * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
     * 输入: "()())()"
     * 输出: ["()()()", "(())()"]
     */

    /**
     * dfs-求解  对于括号-判断close的数量和open的数量，如果当前close>open，则必然出现了问题，从有问题的
     * 串中找错即可,且只需要删除close即可，目标是找到合适的close删除，
     * 同理，判断open>close的个数，
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s,res,0,0,'(',')');
        return res;
    }
    // start2cnt start2rm 减少遍历次数--从0开始也可以
    private void dfs(String s,List<String> res,int start2cnt,int start2rm,char openC,char closeC){
        int open=0,close=0;
        for(int i=start2cnt;i<s.length();i++){
            if(s.charAt(i)==openC) open++;
            if(s.charAt(i)==closeC) close++;
            // 必然出现问题
            if(close>open){
                for(int j=start2rm;j<=i;j++){
                    // 删除多余的括号
                    // 第二个条件 去重，如果两个close连着，则只需要去掉一个即可
                    if(s.charAt(j)==')'&&(j==start2rm||s.charAt(j-1)!=')')){
                        // 去除Str中一个字符，然后继续判断的有效方法
                        dfs(s.substring(0,j)+s.substring(j+1),res,i,j,openC,closeC);
                    }
                }
                return; // 出现问题了，不在该层输出，而是到正确解的位置输出
            }
        }

        // ????????????????????
        String ss = new StringBuilder(s).reverse().toString();
        if(openC=='('){
            dfs(ss,res,0,0,')','(');
        }else
            res.add(s);
    }
}

