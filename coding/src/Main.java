import java.util.*;

public class Main{
    public static void main(String[] args) {
        System.out.println(get("aaabcaa"));
    }

    private static int get(String str){
        char[] sc = str.toCharArray();
        int[] cnt = new int[26];
        int l=0,r=0;
        int max=-1;
        while(r<sc.length){
            if(cnt[sc[r]-'a']==0){
                cnt[sc[r]-'a']++;
                r++;
            }else{
                max = Math.max(max,r-l);
                while(sc[l]!=sc[r]){
                    cnt[sc[l]-'a']--;
                    l++;
                }
                cnt[sc[l]-'a']--;
                l++;
            }
        }
        return max;
    }
}


