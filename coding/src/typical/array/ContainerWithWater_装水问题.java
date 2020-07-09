package typical.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  ContainerWithWater_装水问题 {
    // 一般都是设立  l=0 ,r = nums.length;
    // 而后 l++ ,r--;
    // 因为  l ,r 首先要取短的
    // 从两端往中间靠
    //https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int _max=0,temp=0;
        while(l<r){
            if(height[l]<height[r]){
                temp = height[l]*(r-l);
                l++;
            }else{
                temp = height[r]*(r-l);
                r--;
            }
            _max = Math.max(_max,temp);
        }
        return _max;
    }

//    https://leetcode.com/problems/trapping-rain-water/
public int trap(int[] height) {
    int l = 0;
    int r = height.length-1;
    int res = 0;
    int maxleft = 0,maxright= 0;
    while(l<=r){
        if(height[l]<=height[r]){
            if(height[l]>maxleft) maxleft=height[l];
            else res+=maxleft-height[l]; // 如果左边的height是往下走了，且左边的最大值小于右边的height，那么，左边必然会有水位形成；右边同理
            l++;
        }else{
            if(height[r]>maxright) maxright=height[r];
            else res+=maxright-height[r];
            r--;
        }
    }
    return res;

}




public TreeNode constructMaximumBinaryTree(int[] nums) {
    if(nums.length==0) return null;
    int idx=-1;
    int maxV=  Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>maxV){
            idx=i;
            maxV=nums[i];
        }
    }
    TreeNode res = new TreeNode(nums[idx]);
    res.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,idx));
    res.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,idx+1,nums.length));
    return res;

}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
