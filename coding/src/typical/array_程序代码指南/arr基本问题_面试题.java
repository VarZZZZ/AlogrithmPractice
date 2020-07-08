package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/7 22:27
 * @Version 1.0
 */
public class arr基本问题_面试题 {
    /**
     * 一个数组实现两个栈
     */
    class double_stack{
        private final int length;
        int top1,top2;
        int[] arr;
        double_stack(int len){
            length=len;
            arr = new int[length];
            top1=-1;
            top2=length;
        }
        public boolean push1(int a){
            if(top1+1==top2){
                return false;
            }else{
                arr[++top1]=a;
                return true;
            }
        }
        public boolean push2(int a){
            if(top2-1==top1){
                return false;
            }
            arr[--top2]=a;
            return true;
        }
        int pop1(){
            if(top1==-1) return -1;
            return arr[top1--];
        }
        int pop2(){
            if(top2==length) return -1;
            return arr[top2++];
        }
    }

    /**
     * 数组 子数组最大累加和；直接遍历一遍，并累加sum,当sum<0是，将sum 设为0，并从当前点往后继续累加
     * 注意与给定值的和的区别
     */

    /**
     * 子矩阵的最大累加和
     *
     * 分析: 假设一个已得到一个子矩阵，m*n,最后结果的最大累加和笔试m*k,那么可以转化为 上一题
     * 将数组按列求和得到m*1,再根据子数组最大累加和求出
     */
    private int maxSumMat(int[][] m){
        int max =Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null; // 累加数组
        for(int i=0;i<=m.length;i++){
            s = new int[m[0].length]; // 列的大小
            for(int j=i;j<m.length;j++){  // i  和j 为子矩阵的行的上下边界
                cur = 0;
                for(int k=0;k<m[0].length;k++){
                    s[k] += m[j][k]; // 累加数组是不归零的，相当于上一题的原数组
                    cur += s[k];
                    max = Math.max(max,cur);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }

    /**
     * 子数组最大累乘积
     * 假设求以i位置为结尾的子数组的最大成绩，已知arr[i-1]结尾的最小乘积，最大乘积，那么以arr[i]结尾的情况只有3种
     * 1.可能是max*arr[i]。max 既然表示以arr[i-1]结尾的最大累成绩，
     * 2.可能是min*arr[i]，两个负数相乘结果可能最大
     * 3.可能仅仅是arr[i]的值
     */
    private double maxProduct(double[] arr){
        double max = arr[0];
        double min  = arr[0];
        double res = arr[0];
        double maxEnd = 0.0;
        double minEnd = 0.0;
        for(int i=1;i<arr.length;i++){
            maxEnd = max*arr[i];
            minEnd = min*arr[i];
            max = Math.max(arr[i],Math.max(maxEnd,minEnd));
            min = Math.min(Math.min(maxEnd,minEnd),arr[i]);
            res = Math.max(res,max);
        }
        return res;
    }

    /**
     * 边界都是1的最大正方形大小
     * 1.没特殊方法，检查每个位置是否可以成为正方形的左上角。可以利用right[i][j] ,down[i][j],分别表示从(i,j)向右出发有多少个连续的1
     */








}
