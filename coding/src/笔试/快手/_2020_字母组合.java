package 笔试.快手;

import java.util.*;

public class _2020_字母组合 {
    //    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();
//        Map<Character,String> map = new HashMap<>();
//        map.put('2',"abc");
//        map.put('3',"def");
//        map.put('4',"ghi");
//        map.put('5',"jkl");
//        map.put('6',"mno");
//        map.put('7',"pqrs");
//        map.put('8',"tuv");
//        map.put('9',"wxyz");
//        List<String> list = new ArrayList<>();
//        dfs(map,list,num,0,"");
//
//    }
    private static void dfs(Map<Character, String> map, List<String> list, String num, int idx, String s) {
        if (idx == num.length()) {
            list.add(s);
        }
        String p = map.get(num.charAt(idx));
        for (int i = 0; i < p.length(); i++) {
            dfs(map, list, num, idx + 1, s + p.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Long a = Long.parseLong(s1.substring(1, s1.length() - 1));
        Long b = Long.parseLong(s2.substring(1, s2.length() - 1));


    }
}
