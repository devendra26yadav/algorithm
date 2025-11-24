package work.D3;

public class Main {
    static void searchSS(int[][] m, int key) {
        int n = m.length;
        boolean dir=false;
        int k=0;
        for(int d=0;d<2*n-1;d++){
            if(d<n)
            {
                if(dir){
                    for(int i=d,j=0;j<=d;i--,j++){
                        //System.out.printf("[%d,%d]",i,j);
                        System.out.printf("%d, ",m[i][j]);
                    }
                }else{
                    for(int i=0,j=d;i<=d;i++,j--){
                        //System.out.printf("[%d,%d]",i,j);
                        System.out.printf("%d, ",m[i][j]);
                    }
                }
                dir=!dir;
                k++;
            }else {
                // Fill diagonal from bottom to top
                for (int i = n - 1; i >= 0; i--) {
                    int j = d - i;
                    if (j >= 0 && j < n) {
                        //a[i][j] = num++;
                        System.out.printf("%d, ",m[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }

    static void searchSS2(int[][]m,int key){
        int n = m.length;
        if(key<m[0][0] || key > m[n-1][n-1]){
            System.out.println("Not Found");
            return;
        }
        for(int d=0;d<2*n-1;d++){
            if(d%2==0){
                for(int i=0;i<n;i++){
                    int j=d -i;
                    if(j>=0 && j<n && m[i][j]==key){
                        System.out.printf("(%d,%d)",i,j);
                        return;
                    }
                }
            }else{
                for(int i=n-1;i>=0;i--){
                    int j=d -i;
                    if(j>=0 && j<n && m[i][j]==key){
                        System.out.printf("(%d,%d)",i,j);
                        return;
                    }
                }
            }
        }
        System.out.println("Not Found!");
    }

    static  void search(int[][]m,int key){
        int n=m.length;
        if(n==0 || key<m[0][0] ||  key > m[n-1][n-1]){
            System.out.println("Not Found");
            return;
        }
        int i=0,j=n-1;
        while(i<n && j>=0){
            if(m[i][j]==key){
                System.out.printf("[%d,%d]",i,j);
                break;
            }else if(m[i][j]>key){
                j--;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {
                {5, 7, 8, 14, 15},
                {6, 9, 13, 16, 23},
                {10, 12, 17, 22, 24},
                {11, 18, 21, 25, 28},
                {19, 20, 26, 27, 29}
        };
        //searchSS(m,4);
        searchSS2(m,93);
        search(m,11);
    }
}
