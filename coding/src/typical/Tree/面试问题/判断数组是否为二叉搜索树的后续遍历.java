package typical.Tree.面试问题;

/**
 * @Author: ly
 * @Date: 2020/8/5 17:36
 * @Version 1.0
 */
public class 判断数组是否为二叉搜索树的后续遍历 {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder,0,postorder.length-1);
    }
    private boolean dfs(int[] postorder,int l,int r){
        if(l>=r) return true;
        int i = l;
        while(postorder[i]<postorder[r]) i++;
        int m = i;
        while(postorder[i]>postorder[r]) i++;
        return i==r&&dfs(postorder,l,m-1)&&dfs(postorder,m,r-1);
    }
    /**
     * 单调栈规则
     * 先将数组倒序，
     */
}
