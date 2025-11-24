package final_exam.heap;

public class Heap {
    public static void heapSort(int[]a){
        int heapSize = a.length;
        buildMaxHeap(a,heapSize);
        for(int i=a.length-1;i>0;i--){
            swap(a,0,i);
            heapSize--;
            maxHeapify(a,0,heapSize);
        }
    }

    private static void buildMaxHeap(int []a,int heapSize){
        for(int i=(heapSize/2)-1;i>=0;i--){
            maxHeapify(a,i,heapSize);
        }
    }
    private static void maxHeapify(int[] a, int i, int heapSize){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;

        if(left < heapSize && a[left] > a[largest])
            largest = left;

        if(right < heapSize && a[right] > a[largest])
            largest = right;

        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    private static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
