package typical.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找到数组中个数大于n除以3的数字 {
    //  既然是找到》n/3的数字，那么最多会有2个合适的数字，所以，保存2个值。
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0,cnt2=0,can1=0,can2=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            if(can1==n)
                cnt1++;
            else if(can2==n)
                cnt2++;
            else if(cnt1==0){
                cnt1++;
                can1=n;
            }else if(cnt2==0){
                cnt2++;
                can2=n;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(nums.length==0) return res;
        if(map.getOrDefault(can1,0)>nums.length/3) res.add(can1);
        if(can2!=can1&&map.getOrDefault(can2,0)>nums.length/3) res.add(can2);
        return res;
    }
}
