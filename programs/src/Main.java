public class Main {
    public static void main(String[] args) {
        m1(5);
        System.out.println(minMaxDiff(new int[]{2,3,4,5,6,10,1,5}));
    }
    public static void m1(int n){
        double j=n,count=0;
        while (j>1){
            count++;
            j=Math.sqrt(j);
        }
    }
    public static int minMaxDiff(int[] a) {
        int minSoFar = a[0];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 1; i < a.length; i++) {
            maxDiff = Math.max(maxDiff, a[i] - minSoFar);
            minSoFar = Math.min(minSoFar, a[i]);
        }

        return maxDiff;
    }
}
