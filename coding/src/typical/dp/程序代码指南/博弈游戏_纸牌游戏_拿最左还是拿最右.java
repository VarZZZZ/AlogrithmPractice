package typical.dp.程序代码指南;

public class 博弈游戏_纸牌游戏_拿最左还是拿最右 {
    // 给定一个整形arr, 玩家A/B一次拿走每张纸牌，得分为arr[i]，规定A先拿、但是每次只能拿最左或最右，问最后获胜者的分数。

    //递归方法-：定义递归函数f(i,j)，如果arr[i..j]被先拿，能获得什么分数，定义s(i,j),如果arr[i,,,j]被该人后拿，能获得什么分数；
    //首先分析f(i,j)
    // 如果i!=j，当前要么选择arr[i]、要么arr[j]，如果拿arr[i]，那么对于arr[i+1,,,j]，他成了后拿的人；
    //所以作为玩家，她会的到max(arr[i]+s(i+1,j),arr[j]+s(i,j-1));
    //此次分析s(i,j)
    //如果i==j，s(i,j)=0
    // 对方先拿牌，如果拿arr[i],则本人会先拿arr[i+1,,j]，对手会把最差的情况留给本人，所以返回min(f(i+1,j),f(i,j-1));

    private int win1(int[] arr){
        if(arr==null||arr.length==0) return 0;
        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }
    private int f(int[] arr,int i,int j){
        if(i==j)
            return arr[i];
        return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
    }
    private int s(int[] arr,int i,int j){
        if(i==j) return 0;
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }

    // dp；记录
    private int win2(int[] arr){
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for(int j=0;j<arr.length;j++){
            f[j][j]=arr[j];
            for(int i=j-1;i>=0;i--){ //注意 i 和  j的方向
                f[i][j] = Math.max(arr[i]+s[i+1][j],arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
    }
}
