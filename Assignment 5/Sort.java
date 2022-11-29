import java.util.Arrays;

/**
 * <h1> Sorting Algorithms </h1>
 * 
 * The methods sort an int array using
 * their respective algorithm. The 
 * efficiencies of the algorithms will
 * be benchmarked and analyzed.
 * 
 * @author Ben Smith
 * @version 0.0
 * @since 11-27-2022
 */

public class Sort {

    /*
     * Uses insertion sort algorithm to sort the
     * input array arr in descending order. Time 
     * complexity should be O(n^2).
     */
    void insertionSort(int[] arr) {
        int j;
        
        for (int i = 1; i < arr.length; i++) {  // shift each element left to proper spot
            int toInsert = arr[i];
            
            for (j = i; j > 0 && toInsert > arr[j-1]; j--)  // shift arr[j] left if bigger than arr[j-1]
                  arr[j] = arr[j-1];

            arr[j] = toInsert;
        }

        System.out.println(Arrays.toString(arr));
    }

    /*
     * Uses bubble sort algorithm to sort the input
     * array arr in descending order. Time complexity
     * should be O(n^2) or O(n) best case.
     */
    void bubbleSort(int[] arr) {  // work right->left, if elements in wrong spot then swap
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j-1])
                    swap(arr, j, j+1);
            }
        }
        
        System.out.println(Arrays.toString(arr));
    }

    void swap(int[] arr, int left, int right) {  // switch elements at left and right index
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /*
     * Uses shell sort algorithm using Hibbard's sequence 
     * to sort the input array arr in descending order. 
     * Time complexity should be O(n^(3/2)).
     */
    void shellSort(int[] arr) {
        int incr = 1;
        int j;

        while (2 * incr <= arr.length) 
            incr = 2 * incr;  // starting incr = floor(log arr.length)
        
        incr = incr - 1;
        
        while (incr >= 1) {  // insertion sort with increment decreasing by half each time
            for (int i = incr; i < arr.length; i++) {
                int toInsert = arr[i];

                for(j = i; j > incr-1 && toInsert > arr[j-incr]; j = j - incr)
                    arr[j] = arr[j-incr];
                
                arr[j] = toInsert;
            }

            incr = incr/2;
        }

        System.out.println(Arrays.toString(arr));
    }

    /*
     * Uses quick sort algorithm to sort the input 
     * array arr into descending order. Time 
     * complexity should be O(nlogn) best case or 
     * O(n^2) worst case.
     */
    void quickSort(int[] arr) {
        myQuickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    void myQuickSort(int[] arr, int first, int last) {  // recursively run algorithm
        if (first >= last) return;  // stop when subarray size is 1

        int split = partition(arr, first, last);
        myQuickSort(arr, first, split);
        myQuickSort(arr, split+1, last);
    }

    int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last)/2];
        int i = first - 1; // index going from left to right
        int j = last + 1; // index going from right to left
        while (true) {  // increment first and last until need to swap
            do {
                i++;
            } while (arr[i] < pivot);
            
            do {
                j--;
            } while (arr[j] > pivot);
            
            if (i > j)
                swap(arr, i, j);
            else
                return j; // arr[j] = end of left array
        }
    }

    /*
     * Uses merge sort algorithm to sort the input array
     * arr into descending order. Time complexity should
     * be O(nlogn).
     */
    void mergeSort(int[] arr) {

    }

    /*
     * Uses the upgraded quick sort agorithm to sort the
     * input array arr into descending order. Time complexity
     * should be O(nlogn)
     */
    void upgradedQuickSort(int[] arr) {

    }

    /*
     * Takes random input and generates a randomized 
     * array of size n.
     */
    int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        return arr;
    }

    /*
     * 
     */
    void readCommands(String filepath) {

    }
}
