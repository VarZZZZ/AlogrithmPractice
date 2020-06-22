package typical.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DFS_IncreasingSubsequence_去重 {

    //对于一个数组，找到所有的递增序列
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1) res.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            // 此处重要去重； 对于该for循环内，表示的是选出一个值；
            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }
}
