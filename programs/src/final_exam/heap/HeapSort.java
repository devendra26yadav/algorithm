package final_exam.heap;


public class HeapSort {
    public static void main(String[] args) {
        int[] a={1,3,5,6,2,4,7};
        Heap.heapSort(a);
        for (int e:a){
            System.out.print(e+" ");
        }
    }
}
