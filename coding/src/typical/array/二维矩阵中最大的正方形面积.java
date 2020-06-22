package typical.array;

import java.util.Stack;

public class 二维矩阵中最大的正方形面积 {
    //https://leetcode.com/problems/maximal-square/
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n =matrix[0].length;
        int[][] dp = new int[m][n];
        int maxres = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||matrix[i][j]=='0'){
                    dp[i][j] = matrix[i][j]-'0';
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
                maxres = Math.max(dp[i][j],maxres);
            }
        }
        return maxres*maxres;
    }

    // 最大的矩形面积 ；  将矩形理解为直方图
    private int maxRecSize(int[][] arr){
        int maxArea = 0;
        int[] height = new int[arr[0].length];  //指的是最大矩形中的高;而非arr的高
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                height[j] = height[j]==0?0:height[j]+1;
            }
            maxArea = Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }
    private int maxRecFromBottom(int[] height){
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty()&&height[i]<=height[st.peek()]){         // 当前高度小于栈中的高度， 求以栈中的height[j]为高度的矩形此时height[j]应该为栈最高的
                int j =st.pop();
                int k = st.isEmpty()?-1:st.peek();          // 如果Height[i]=0，那么栈中的值需要全部抛出; k为左边的idx。且该idx的值比h[j]的小；
                int cur = (i-k-1)*height[j];                                             // 栈中的值从 顶到底 是从大到小的
                maxArea = Math.max(maxArea,cur);
            }
            st.push(i);
        }
        while(!st.isEmpty()){       //连续的从小到大；
            int j = st.pop();
            int k = st.isEmpty()?-1:st.peek();
            int cur = (height.length-k-1)*height[j];
            maxArea = Math.max(maxArea,cur);
        }
        return maxArea;
    }
}
