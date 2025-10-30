package work.lession3;

public class Matrix {

    static void M1(int n){
        int start=n;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(start++ +" ");
            }
            System.out.println();
        }
    }
    static void M2(int n){
        // Matrix size
        int start = 5;   // Starting number
        int[][] a = new int[n][n];
        int num = start;

        for (int d = 0; d < 2 * n - 1; d++) {
            if (d % 2 == 0) {
                // Fill diagonal from top to bottom
                for (int i = 0; i < n; i++) {
                    int j = d - i;
                    if (j >= 0 && j < n) {
                        a[i][j] = num++;
                    }
                }
            } else {
                // Fill diagonal from bottom to top
                for (int i = n - 1; i >= 0; i--) {
                    int j = d - i;
                    if (j >= 0 && j < n) {
                        a[i][j] = num++;
                    }
                }
            }
        }
        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d |", a[i][j]);
            }
            System.out.println();
        }
    }
    static void M3(int n){
        int start=n;
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                a[j][i]=start++;
            }
        }

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.printf("%3d |", a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        M1(5);
        System.out.println("Printing M2");
        M2(5);
        System.out.println("Printing M3");
        M3(5);
    }
}
