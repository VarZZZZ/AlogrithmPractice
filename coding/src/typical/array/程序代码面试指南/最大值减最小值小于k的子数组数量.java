package typical.array.程序代码面试指南;

import java.util.LinkedList;
import java.util.List;

public class 最大值减最小值小于k的子数组数量 {
    // 1.如果子数组arr[i,,j]满足条件，那么i..j中的任意一个子数组都满足条件；(里面的最大值可能会减少，最小值可能会变大)
    // 2.如果子数组arr[i,j]不满组条件，即i..j内的最大-最小大于K，那么任意包括i,,j的数组都不满足；
    private int getNum(int[] arr,int k){
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i=0;
        int j=0;
        int res = 0;
        while(i<arr.length){              // 表示arr[i,,,j]
            while(j<arr.length){            // 先更新arr[i,,j] arr[i,,,j+1]..
                if(qmin.isEmpty()||qmin.peekLast()!=j){
                    while(!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                        qmin.pollLast();
                    }
                    qmin.addLast(j); // 更新最小值     ;窗口的最小值在最前面，从小到大
                    while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);       // 从大到小
                }
                if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>k){
                    break;
                }
                j++;
            }
            res += j-i;
            // 移动i
            if(qmin.peekFirst()==i) //需要移掉i，如果此时qmin中还保存着i，需要移出掉
                qmin.pollFirst();
            if(qmax.peekFirst()==i)
                qmax.pollFirst();
            i++;
        }
        return res;
    }

}
