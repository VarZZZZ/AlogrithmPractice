package 笔试.wangyi;

import java.util.*;

public class _2020_1_13_序列转换对比_提前 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            Set<String> st = new HashSet<>();
            String s = sc.next();
            String t = sc.next();
            System.out.println(bfs(s,t));
        }
    }

    private static String bfs(String s, String t) {
        List<String> list = new ArrayList<>();
        String tmp = s;
        while (tmp.length() > 1) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < tmp.length() && tmp.charAt(i) == '1') {
                i++;
            }
            while (i < tmp.length()) {
                if (tmp.charAt(i) == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
                i++;
            }
            String l = sb.toString();
            tmp = l;
            if (!l.equals("")) {
                list.add(l);
            }
        }
        if (list.contains("1")) list.add("0"); // ???
        int idx = 0;
        while(idx<t.length()){
            int n=0;
            if(idx+s.length()<=t.length()&&t.substring(idx,s.length()).equals(s)){
                idx +=s.length(); // 可以放到下面
            }else if(idx<t.length()){ // 贪心
                for(int i=0;i<list.size();i++){ // 长的字符串在前面、先从最长的开始匹配；
                    String l = list.get(i);
                    if(idx+l.length()<=t.length()&&t.substring(idx,l.length()).equals(l)){
                        idx+=l.length();
                        break;
                    }else{
                        n++;//失败，未匹配到;
                    }
                }
                if(n==list.size()) return "NO";
            }
        }
        return "YES";

    }
}
