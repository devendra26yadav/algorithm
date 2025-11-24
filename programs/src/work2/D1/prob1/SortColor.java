package work2.D1.prob1;

import java.util.Arrays;

public class SortColor {
    public static void sortColor(String[] colors) {
        int left = 0;
        int right = colors.length - 1;

        while (left < right) {

            while (left < right && colors[left].equals("Blue")) left++;
            while (left < right && colors[right].equals("Red")) right--;

            if (left < right) {
              swap(colors,left++,right--);
            }
        }

    }
    private static void swap(String[] colors,int i, int j){
        String temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
    public static void sort3Colors(String[] toys){
        int low = 0;
        int mid = 0;
        int high = toys.length - 1;

        while (mid <= high) {
            if (toys[mid].equals("Blue")) {
                // Swap with low and move both pointers forward
                swap(toys, low, mid);
                low++;
                mid++;
            }
            else if (toys[mid].equals("Green")) {
                // Green is in the correct middle section, just move mid
                mid++;
            }
            else { // Red
                // Swap with high and move high pointer backward
                swap(toys, mid, high);
                high--;
                // Don't increment mid because we need to examine the swapped element
            }
        }
    }
    public static <T> void print(T[] arr){
        for (T element:arr){
            System.out.print(element+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] toys = {"Red", "Blue", "Red", "Blue", "Blue", "Red"};
        System.out.println("Before Printing");
        System.out.println(Arrays.toString(toys));
        sortColor(toys);
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(toys));
        String[] toys2 = {"Red","Green", "Blue", "Red", "Blue","Green","Blue","Blue", "Red"};
        System.out.println("Before sorting toys 2");
        print(toys2);
        System.out.println("After sorting toys 2");
        sort3Colors(toys2);
        print(toys2);
    }
}
