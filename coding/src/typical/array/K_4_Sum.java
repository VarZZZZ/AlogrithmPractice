package typical.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 从数组中找出K OR 4 个数 之和等于target
public class K_4_Sum {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums,target,4,0);

    }
    public ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index){
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(index > len-k) {
            return ans;
        }
        if(k == 2) {
            int l = index,r = len-1;
            while(l < r) {
                if (nums[l] + nums[r] == target){
                    List<Integer> re = new LinkedList<>();
                    re.add(nums[l]);
                    re.add(nums[r]);
                    ans.add(re);

                    while(l < r && nums[l+1] == nums[l]) l++;
                    while(l < r && nums[r-1] == nums[r]) r--;
                    l++;
                    r--;
                } else {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        } else {
            for(int i = index;i<len-k+1;i++){
                ArrayList<List<Integer>> a = kSum(nums,target-nums[i],k-1,i+1);
                if(ans != null) {
                    for(List<Integer> r:a){
                        r.add(0,nums[i]);
                    }
                    ans.addAll(a);
                }
                while(i < len-1 && nums[i+1]==nums[i]){
                    i++;
                }
            }
        }
        return ans;
    }
}
