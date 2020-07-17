package 笔试.猿辅导;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/7/15 22:59
 * @Version 1.0
 */
public class _2020_出勤率_结构设计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] l1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        int m = Integer.parseInt(l1[1]);
        Map<String, List<String>> class2stu = new HashMap<>();
        Map<String, String> stu2class = new HashMap<>();
        Map<String, String> class2tea = new HashMap<>();
        Map<String, String> tea2class = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] l = sc.nextLine().split(" ");
            class2tea.put(l[2], l[1]);
            tea2class.put(l[1], l[2]);
            class2stu.put(l[2], new ArrayList<>());
            for (int j = 3; j < l.length; j++) {
                class2stu.get(l[2]).add(l[j]);
                stu2class.put(l[j], l[2]);
            }
        }
        Map<String, List<Integer>> tea2Time = new HashMap<>();
        Map<String, List<Integer>> stu2Time = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] l = sc.nextLine().split(" ");
            if (tea2class.containsKey(l[1])) { // 老师
                if (!tea2Time.containsKey(l[1])) {
                    tea2Time.put(l[1], new ArrayList<>());
                }
                tea2Time.get(l[1]).add(Integer.parseInt(l[2]));
            } else {
                if (!stu2Time.containsKey(l[1])) {
                    stu2Time.put(l[1], new ArrayList<>());
                }
                stu2Time.get(l[1]).add(Integer.parseInt(l[2]));
            }
        }

        Map<String, Integer> stu2AllTime = new HashMap<>();
        Map<String, Integer> tea2AllTime = new HashMap<>();
        for (String tea : tea2Time.keySet()) {
            List<Integer> t = tea2Time.get(tea);
            Collections.sort(t);
            int tp = 0;
            for (int i = 0; i < t.size() - 1; i += 2) {
                tp += t.get(i + 1) - t.get(i);
            }
            tea2AllTime.put(tea, tp);
        }
        for (String stu : stu2Time.keySet()) {
            List<Integer> t = stu2Time.get(stu);
            Collections.sort(t);
            int tp = 0;
            for (int i = 0; i < t.size() - 1; i += 2) {

            }
            stu2AllTime.put(stu, tp);
        }
        Map<String, Integer> cla2teaChu = new HashMap<>();
        Map<String, Integer> cla2stuChu = new HashMap<>();
        for (String tea : tea2AllTime.keySet()) {
            String cla = tea2class.get(tea);
            cla2teaChu.put(cla, tea2AllTime.get(tea) * class2stu.get(cla).size());
        }
        for (String stu : stu2AllTime.keySet()) {
            String cla = stu2class.get(stu);
            if (!cla2stuChu.containsKey(cla)) {
                cla2stuChu.put(cla, 0);
            }
            cla2stuChu.put(cla, cla2stuChu.get(cla) + stu2AllTime.get(stu));
        }
        Map<String, Double> cla2res = new HashMap<>();
        for (String cla : cla2teaChu.keySet()) {
            double s = (double) cla2stuChu.get(cla);
            double t = (double) cla2teaChu.get(cla);
            cla2res.put(cla, s / t);
            System.out.println(cla+"   "+ s+" "+t);
        }
        PriorityQueue<Map.Entry<String, Double>> pq = new PriorityQueue<>((a, b) -> {
            if (!a.getValue().equals(b.getValue())) return a.getValue() < b.getValue() ? 1 : -1;
            return a.getKey().compareTo(b.getKey());
        });
        for (Map.Entry<String, Double> me : cla2res.entrySet()) {
            pq.offer(me);
        }
        while (pq.size() != 0) {
            System.out.println(pq.poll().getKey());
        }
    }
}
