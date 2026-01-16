package h3;

import java.util.Arrays;

public class H3_main {

    public static void main(String[] args) {
        int[] input = {12, 11, 13, 5, 6, 7, 1, 99, 2};
        System.out.println("Unsortiert: " + Arrays.toString(input));
        
        int[] sorted = mergeSort(input);
        System.out.println("Sortiert:   " + Arrays.toString(sorted));
    }

    public static int[] mergeSort(int[] array) {
       
        if (array.length <= 1) {
            return array;
        }

       
        int mid = array.length / 2;
        
      
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

       
        left = mergeSort(left);
        right = mergeSort(right);

        
        return merge(left, right);
    }

  
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0; // Zeiger für left
        int j = 0; // Zeiger für right
        int k = 0; // Zeiger für result

       
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

      
        while (i < left.length) {
            result[k++] = left[i++];
        }

       
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}