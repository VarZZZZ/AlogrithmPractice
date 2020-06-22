package typical.array;

public class __经典dfs_CanPartitionKSubSet_将数组分成k个大小相等的子数组 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int a:nums) sum+=a;
        if(k<1||sum%k!=0) return false;
        int[] visited = new int[nums.length];

        return canPart(nums,visited,0,k,0,0,sum/k);
    }

    private boolean canPart(int[] nums,int[] visited,int idx,int k,int cur_sum,int cur_num,int target){
        if(k==1) return true;
        if(cur_sum==target && cur_num>0) return canPart(nums,visited,0,k-1,0,0,target);
        for(int i=idx;i<nums.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                if(canPart(nums,visited,i+1,k,cur_sum+nums[i],cur_num+1,target)) return true;
                visited[i]=0;
            }
        }
        return false;
    }
}
