package typical.math;

public class 质数 {
    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] notPrime = new boolean[n];
        for(int i=2;i<n;i++){
            if(notPrime[i]==false){
                cnt++;
                for(int j=2;i*j<n;j++){
                    notPrime[i*j]=true;
                }
            }
        }
        return cnt;
    }
}
