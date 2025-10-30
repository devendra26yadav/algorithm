package work.lession3;

public class Main {
    public static long findFib(int n){
        if (n==0) return 0;
        if(n==1) return 1;
        long[] memo= new long[n+1];
        long f=0,s=1;
        long sum=0;
        memo[0]=0;
        memo[1]=1;
        for(int i=2;i<=n;i++){
            sum=f+s;
            f=s;
            s=sum;
            memo[i] = sum;
        }
        return memo[n];
    }

    public static long fibOf(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long f = 0, s = 1;
        for (int i = 2; i <= n; i++) {
            long sum = f + s;
            f = s;
            s = sum;
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(findFib(5));
        System.out.println(fibOf(50));
    }
}
