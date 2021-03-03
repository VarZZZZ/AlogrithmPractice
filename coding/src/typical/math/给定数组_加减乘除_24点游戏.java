package typical.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/8/22 22:08
 * @Version 1.0
 */
public class 给定数组_加减乘除_24点游戏 {
//    你有 4张写有 1到 9数字的牌。你需要判断是否能通过 *，/，+，-，(，)的运算得到 24。
//
//    示例 1:
//
//    输入:[4,1,8,7]
//    输出:True
//    解释:(8-4)*(7-1)=24

    // dfs时，将list传入参数，当list size=1时，表明这些数全部合成一个了
    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new LinkedList<>();
        for (int n : nums) arr.add((double) n);
        dfs(arr);
        return res;
    }

    private boolean res = false;
    private double eps = 0.001;

    // 对一个数组(list）加减乘除，最后合成1个数，则可以直接利用list对当前数字合并操作
    private void dfs(List<Double> arr) {
        if (res) return;
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < eps) {
                res = true;
            }
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                double a  =arr.get(i);
                double b = arr.get(j);
                List<Double> next = new ArrayList<>();
                next.addAll(Arrays.asList(a+b,a-b,a*b,b-a));
                if(Math.abs(a)>eps) next.add(b/a);
                if(Math.abs(b)>eps) next.add(a/b);

                arr.remove(i);
                arr.remove(j);
                for(Double n:next){
                    arr.add(n);
                    dfs(arr);
                    arr.remove(arr.size()-1);
                }
                arr.add(j,b);
                arr.add(i,a);
            }
        }
    }

}
