package typical.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/7/15 11:30
 * @Version 1.0
 */
public class 给定表达式_添加运算符_使结果等于给定值 {
    /**
     * 输入: num = "123", target = 6
     * 输出: ["1+2+3", "1*2*3"]
     *  +、-、*
     *  输入: num = "232", target = 8
     *  输出: ["2*3+2", "2+3*2"]
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res,num,"",0,0,target,0);
        return res;
    }

    private void dfs(List<String> res, String num, String tmp, int idx, long curRes, int target, long mul){
        if(idx==num.length()){
            if(curRes==target){
                res.add(tmp);
            }
            return;
        }
        for(int i=idx;i<num.length();i++){
            if(i!=idx&&num.charAt(idx)=='0') break; // 第一个字符为0开头，在第二次循环不做遍历，退出
            long cur = Long.parseLong(num.substring(idx,i+1));

            if(cur>Integer.MAX_VALUE) break;
            if(idx==0){
                dfs(res,num,tmp+cur,i+1,cur,target,cur);
            }else{
                dfs(res,num,tmp+"+"+cur,i+1,curRes+cur,target,cur);     // ****
                dfs(res,num,tmp+"-"+cur,i+1,curRes-cur,target,-cur);
                dfs(res,num,tmp+"*"+cur,i+1,curRes-mul+mul*cur,target,mul*cur);
            }

        }
    }





}
