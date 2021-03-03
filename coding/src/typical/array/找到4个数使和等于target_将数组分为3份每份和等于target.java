package typical.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 从数组中找出K OR 4 个数 之和等于target
public class 找到4个数使和等于target_将数组分为3份每份和等于target {
    int len = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);

    }

    public ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (index > len - k) {
            return ans;
        }
        if (k == 2) {
            int l = index, r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> re = new LinkedList<>();
                    re.add(nums[l]);
                    re.add(nums[r]);
                    ans.add(re);

                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
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
            for (int i = index; i < len - k + 1; i++) {
                ArrayList<List<Integer>> a = kSum(nums, target - nums[i], k - 1, i + 1);
                if (a != null) {
                    for (List<Integer> r : a) {
                        r.add(0, nums[i]);
                    }
                    ans.addAll(a);
                }
                while (i < len - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
        return ans;
    }

    /**
     * 任意一个整型数组，判断是否可以将数组分为三个区间（区间)，每个区间中数值的和相同
     */
    private boolean isSplit3(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        return dfs(arr, new boolean[arr.length], 0, 0, target, 3);
    }

    private boolean dfs(int[] arr, boolean[] f, int res, int idx, int target, int k) {
        if (k == 0 && res == target && idx == arr.length) return true;
        if (idx == arr.length) return false;
        if (res == target && k > 0) return dfs(arr, f, 0, idx, target, k - 1);
        for (int i = idx; i < arr.length; i++) {
            if (f[i]) continue;
            f[i] = true;
            if (dfs(arr, f, res + arr[i], i + 1, target, k)) return true;
            f[i] = false;
        }
        return false;
    }

    boolean isSplit3_2(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        int cnt = 0;
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {              // 可以直接这样算，贪心算也可以,及时arr[0,,,i] arr[0...i..j]都为target
                // arr[i...j]可以归为第二个里面
                cnt++;
                sum = 0;
            }

        }
        if (cnt == 3) return true;
        return false;
    }


}
