package midterm;

import work2.D1.prob1.SortColor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] A ={1,3,5,8,9,0,0,0};
        int[] B ={2,4,7};
        merge(A,B);
        print(A);
    }
    static void merge(int[]a,int[]b){
        int i=0,j=0;
        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                i++;
            }else {
                shiftRight(a,i);
                a[i]=b[j++];
            }
        }
    }
    static void print(int[]A){
        System.out.println(Arrays.toString(A));
    }
    static void shiftRight(int[]a,int fromPos){
       for(int i=a.length-1;i>=fromPos;i--){
           if(i-1<0){
               a[i]=a[0];
           }else {
               a[i]=a[i-1];
           }
       }
    }
    static void mergeTwoArray(int[]A,int[]B){
        int[] temp = new int[A.length];
        int i=0,j=0;
        int k=0;
        while(i<A.length&&j< B.length){
            if(A[i]<B[j]){
                temp[k]=A[i++];
            }
            else {
                temp[k]=B[j++];
            }
            k++;
        }
        System.out.println(k);
        while (k<A.length){
            temp[k]=A[i++];
            k++;
        }
        System.out.println(Arrays.toString(temp));
    }
}
