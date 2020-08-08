package typical.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 复制链表_链表还有随机指针 {
    //先给每个节点都复制一个出来1-2-3  1-1-2-2-3-3
    // 然后再遍历一次，每个偶数序节点的随机指针指向前一个节点的随机指针的.next
    // 3次while  1.复制节点  2. 复制随机点  3. 拆开两个链表；  2和3不能合在一个链表中
    public String[] permutation(String s) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        List<String> res = new ArrayList<>();
        dfs(sc,res,new StringBuilder(),new boolean[sc.length]);
        return res.toArray(new String[0]);
    }
    private void dfs(char[] sc,List<String> res,StringBuilder sb,boolean[] f){
        if(sb.length()==sc.length){
            String t = sb.toString();
            if(!res.contains(t)){
                res.add(t);
            }
            return;
        }
        for(int i=0;i<sc.length;i++){
            if(!f[i]){
                sb.append(sc[i]);
                f[i]=true;
                dfs(sc,res,sb,f);
                f[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

