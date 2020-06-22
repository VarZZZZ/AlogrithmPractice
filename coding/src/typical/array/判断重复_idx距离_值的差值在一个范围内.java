package typical.array;

import java.util.HashMap;
import java.util.Map;

public class 判断重复_idx距离_值的差值在一个范围内 {
    // 利用map<> val 存储idx下标，以此判断idx距离;或是map size不超过k范围，val为key

    // https://leetcode.com/submissions/detail/287231599/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 下标不超过k，值不超过t
        if(k<1||t<0) return false;
        Map<Long,Long> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            long submap = (long)nums[i]-Integer.MIN_VALUE; // 利用映射关系
            long maped = submap/((long)t+1);   // maped 桶
            if(map.containsKey(maped)||(map.containsKey(maped-1)&&submap-map.get(maped-1)<=t)||
                    map.containsKey(maped+1)&&map.get(maped+1)-submap<=t){
                return true;
            }
            // i and j as most k means have k+1
            if(map.entrySet().size()>=k){
                long sub = ((long)nums[i-k]-Integer.MIN_VALUE)/((long)t+1);
                map.remove(sub);
            }
            map.put(maped,submap);
        }
        return false;
    }

}
