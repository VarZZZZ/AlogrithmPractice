package typical.array.程序代码面试指南;

import java.util.List;
import java.util.Stack;

public class 求数组中每个位置左边和右边最近的且值小于当前的位置 {
    // 建立一个栈，在遍历时，遇到什么情况停止遍历处理？遇到右边值比栈顶元素小的时候，说明右边的找到了，那么左边的在栈中寻找
    private int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> st  = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                int popIdx = st.pop();
                int leftLessIdx = st.isEmpty()?-1:st.peek();
                res[popIdx][1]=i; // 右边
                res[popIdx][0] = leftLessIdx; // 左边
            }
            st.push(i);
        }
        while(!st.isEmpty()){  // 全是从小到大；右边没有小的值
            int popIdx = st.pop();
            int leftLessIdx = st.isEmpty()?-1:st.peek();
            res[popIdx][1]=-1;
            res[popIdx][0]=leftLessIdx;
        }
        return res;
    }
    //考虑重复值
    private int[][] getNearLess(int[] arr){
        int[][] res =new int[arr.length][2];
        Stack<List<Integer>> st = new Stack<>();  // 利用list保存同值的idx

        return res;

    }
}
