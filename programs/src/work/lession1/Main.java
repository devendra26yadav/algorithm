package work.lession1;

public class Main {
    public static void kThMax(int[] arr,int k) {
        if(k < 1 || arr.length < k) return;
        for (int j = 0; j < k; j++) {
            int maxIndex = -1;
            int maxVal = Integer.MIN_VALUE;
            for (int i = j; i < arr.length; i++) {
                if (arr[i] > maxVal) {
                    maxVal = arr[i];
                    maxIndex = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nThe "+k+"th max : "+arr[k-1]);
    }

    public static void main(String[] args) {
        int[] a = {1, 11, 4, 2, 7, 7, 9,11,11};
        kThMax(a,4);
    }
}
