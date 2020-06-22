package typical.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContainerWithWater_装水问题 {
    // 一般都是设立  l=0 ,r = nums.length;
    // 而后 l++ ,r--;
    // 因为  l ,r 首先要取短的
    // 从两端往中间靠
    //https://leetcode.com/problems/container-with-most-water/

//    https://leetcode.com/problems/trapping-rain-water/
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
