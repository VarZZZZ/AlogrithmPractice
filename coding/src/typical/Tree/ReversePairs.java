package typical.Tree;

public class ReversePairs {
    //Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
    //return the number of important reverse pairs in the given array.
    //对于数组中的当前值，快速求之前存在的大于当前值得个数
    class Solution {
        class Node{
            int val;
            Node left;
            Node right;
            int cnt;  // 大于或等于该值得点
            public Node(int val){
                this.val = val;
                cnt = 1;
            }
        }
        // 顺序递归  和  分区递归
        public int reversePairs(int[] nums) {
            int res = 0;
            Node root = null;

            for (int ele : nums) {
                res += search(root, 2L * ele + 1);
                root = insert(root, ele);
            }

            return res;
        }
        private Node insert(Node root,int val){

            if (root == null) {
                root = new Node(val);
            } else if (val == root.val) {
                root.cnt++;
            } else if (val < root.val) {
                root.left = insert(root.left, val);
            } else {
                root.cnt++;
                root.right = insert(root.right, val);
            }

            return root;
        }
        private int search(Node root,long val){
            if (root == null) {
                return 0;
            } else if (val == root.val) {
                return root.cnt;
            } else if (val < root.val) {
                return root.cnt + search(root.left, val);
            } else {
                return search(root.right, val);
            }

        }
    }
}
