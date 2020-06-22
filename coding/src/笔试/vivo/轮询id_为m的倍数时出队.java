package 笔试.vivo;

public class 轮询id_为m的倍数时出队 {
    //https://www.nowcoder.com/question/next?pid=20555525&qid=637399&tid=33994403
    private static String solution(int[] input) {
        // TODO Write your code here
        int n =input[0]; // 人的数量
        int m = input[1]; // 倍数
        int idx=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        boolean[] flag = new boolean[n];
        StringBuilder sb =new StringBuilder();
        int i=1; //计数
        int j=0; //真实下标
        while(idx<n){
            if(flag[j]){
                j = (j+1)%n;
            }else{
                if(i%m==0){
                    sb.append(arr[j]+" ");
                    flag[j]=true;
                    idx++;
                }
                i++;
                j = (j+1)%n;
            }
        }
        return sb.toString();
    }
}
