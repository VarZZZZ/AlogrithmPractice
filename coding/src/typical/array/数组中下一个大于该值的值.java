package typical.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 数组中下一个大于该值的值 {
    // stack 或是保存数值，并用map保存大小关系，或是直接保存idx
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int n:nums2){
            while(!st.isEmpty()&&st.peek()<n){
                mp.put(st.pop(),n);
            }
            st.push(n);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i] = mp.getOrDefault(nums1[i],-1);
        }
        return res;
    }
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] next = new int[len];
        Arrays.fill(next,-1);
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<len*2;i++){
            int n = nums[i%len];
            while(!s.isEmpty() && nums[s.peek()]<n){
                next[s.pop()] = n;
            }
            if(i<len) s.push(i);
        }
        return next;

    }
}
