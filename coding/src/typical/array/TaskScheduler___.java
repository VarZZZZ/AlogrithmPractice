package typical.array;

public class TaskScheduler___ {
    // 任务分配 tasks = ["A","A","A","B","B","B"], n = 2; n为2个间隔内不允许连续出现相同
    // A -> B -> idle -> A -> B -> idle -> A -> B.
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int maxCnt = 0;
        int[] cnt = new int[26];
        for(char t:tasks){
            cnt[t-'A']++;
            if(max==cnt[t-'A']){
                maxCnt++;
            }else if(max<cnt[t-'A']){
                max=cnt[t-'A'];
                maxCnt=1;
            }
        }
        int partCnt = max-1;
        int partLen = (n-(maxCnt-1));
        int emptyPlot = partCnt*partLen;
        int availableTasks = tasks.length-maxCnt*max;
        int res = Math.max(0,emptyPlot-availableTasks); //可以直接减；因为第二大的必定在间隔中
        return 0;
    }
}
