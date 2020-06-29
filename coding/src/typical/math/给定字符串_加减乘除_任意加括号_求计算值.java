package typical.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 给定字符串_加减乘除_任意加括号_求计算值 {
    //https://leetcode.com/problems/different-ways-to-add-parentheses/
    Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='-'||c=='+'||c=='*'){
                String p1 = input.substring(0,i);   // 分解
                String p2 = input.substring(i+1);
                List<Integer> l1 = map.getOrDefault(p1,diffWaysToCompute(p1));
                List<Integer> l2 = map.getOrDefault(p2,diffWaysToCompute(p2));
                for(int m:l1){
                    for(int n:l2){
                        int r = 0;
                        switch(c){
                            case '+':
                                r = m+n;
                                break;
                            case '-':
                                r = m-n;
                                break;
                            case '*':
                                r = m*n;
                                break;
                        }
                        res.add(r);
                    }
                }
            }
        }
        if(res.size()==0)
            res.add(Integer.valueOf(input));   //全是数字
        map.put(input,res);
        return res;
    }
}
