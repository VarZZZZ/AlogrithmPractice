package typical.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IpV4_6 {
    public String validIp(String IP){
        String[] ipv4 = IP.split("\\.",-1);
        String[] ipv6 = IP.split(":",-1);
        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            for(String s : ipv4) if(isIPv4(s)) {
            } else return "Neither";
            return "IPv4";
        }
        if(IP.chars().filter(ch -> ch == ':').count() == 7){
            for(String s : ipv6) if(isIPv6(s)) {
            } else return "Neither";
            return "IPv6";
        }
        return "Neither";
    }
    public static boolean isIPv4 (String s){

        try{
            // 判断字符串是否存在前0，可以先Integer.valueOf转化为int，再转化为String.并比较两个String
            return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        }
        catch (NumberFormatException e){return false;}
    }
    public static boolean isIPv6 (String s){
        if (s.length() > 4) return false;
        try {return Integer.parseInt(s, 16) >= 0  && s.charAt(0) != '-';}
        catch (NumberFormatException e){return false;}

    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> st = new HashSet<>();
        helper(nums,st,0,res,new ArrayList<>());
        return res;
    }

    private void helper(int[] nums,Set<String> st, int idx, List<List<Integer>> res, List<Integer> tmp){
        if(tmp.size()>=2){
            StringBuilder sb = new StringBuilder();
            for(int t:tmp){
                sb.append(t);
            }
            if(st.add(sb.toString())){
                res.add(new ArrayList<>(tmp));
            }
        }
        if(idx==nums.length) return;
        for(int i=idx;i<nums.length;i++){
            if(tmp.size()==0||tmp.get(tmp.size()-1)<=nums[i]){
                tmp.add(nums[i]);
                helper(nums,st,i+1,res,tmp);
                tmp.remove(tmp.size()-1);
            }

        }
    }
}
