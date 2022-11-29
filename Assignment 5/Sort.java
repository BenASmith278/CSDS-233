import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        insertionSort(arr, 0, arr.length - 1);
    }

    void insertionSort(int[] arr, int first, int last) {
        int j;
        
        for (int i = first; i <= last; i++) {  // shift each element left to proper spot
            int toInsert = arr[i];
            
            for (j = i; j > first && toInsert > arr[j-1]; j--)  // shift arr[j] left if bigger than arr[j-1]
                  arr[j] = arr[j-1];

            arr[j] = toInsert;
        }
    }

    /*
     * Uses bubble sort algorithm to sort the input
     * array arr in descending order. Time complexity
     * should be O(n^2) or O(n) best case.
     */
    void bubbleSort(int[] arr) {  // work right->left, if elements in wrong spot then swap
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j+1])
                    swap(arr, j, j+1);
            }
        }
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
    }

    /*
     * Uses quick sort algorithm to sort the input 
     * array arr into descending order. Time 
     * complexity should be O(nlogn) best case or 
     * O(n^2) worst case.
     */
    void quickSort(int[] arr) {
        myQuickSort(arr, 0, arr.length - 1);
    }

    void myQuickSort(int[] arr, int first, int last) {  // recursively run algorithm
        if (first >= last) 
            return;  // stop when subarray size is 1

        int split = partition(arr, first, last);
        myQuickSort(arr, first, split);
        myQuickSort(arr, split + 1, last);
    }

    int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last)/2];
        int i = first - 1; // index going from left to right
        int j = last + 1; // index going from right to left
        while (true) {  // increment first and last until need to swap
            do {
                i++;
            } while (arr[i] > pivot);
            
            do {
                j--;
            } while (arr[j] < pivot);
            
            if (i < j)
                swap(arr, j, i);
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
        int[] temp = new int[arr.length];
        myMergeSort(arr, temp, 0, arr.length - 1);
    }

    void myMergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end ) // base case
            return;
        int middle = (start + end)/2; // The splitting step
        // Sort first and second halves 
        myMergeSort (arr, temp, start, middle); 
        myMergeSort (arr, temp, middle + 1, end); 

        // Merge the sorted halves 
        merge(arr, temp, start, middle, middle+1, end); 
    }

    static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart; // index into left subarray
        int j = rightStart; // index into right subarray
        int k = leftStart; // index into temp

        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] > arr[j]) { 
                temp[k] = arr[i]; 
                i++; 
            } else { 
                temp[k] = arr[j]; 
                j++; 
            } 
            
            k++; 
        }

        // Copy remaining elements of left array if any
        while (i <= leftEnd) { 
            temp[k] = arr[i]; 
            i++; 
            k++; 
        } 

        // Copy remaining elements of right array if any
        while (j <= rightEnd) { 
            temp[k] = arr[j]; 
            j++; 
            k++; 
        } 

        for (i = leftStart; i <= rightEnd; i++) // copy back
            arr[i] = temp[i];
    }

    /*
     * Uses the upgraded quick sort agorithm to sort the
     * input array arr into descending order. Time complexity
     * should be O(nlogn)
     */
    void upgradedQuickSort(int[] arr, int d, int k) {
        int[] temp = new int[arr.length];
        myUpgradedQuickSort(arr, temp, d, 0, k, 0, arr.length - 1);
    }

    void myUpgradedQuickSort(int[] arr, int[] temp, int d, int depth, int k, int first, int last) {  // recursively run algorithm
        // different base cases depending on situation
        if (depth >= d) {
            myMergeSort(arr, temp, first, last);
            return;
        }
        if (last - first < k) {
            insertionSort(arr, first, last);
            return;
        }

        int split = partition(arr, first, last);
        myUpgradedQuickSort(arr, temp, d, depth + 1, k, first, split);
        myUpgradedQuickSort(arr, temp, d, depth + 1, k, split + 1, last);
    }

    /*
     * Takes random input and generates a randomized 
     * array of size n.
     */
    int[] generateRandomArray(int n) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = -10 + (int)(Math.random() * (21));  // generate random number from -10 to 10
        }

        return arr;
    }

    /*
     * Reads a .txt file and prints the results of the
     * commands.
     */
    void readCommands(String filepath) throws FileNotFoundException {
        File commands = new File(filepath);
        Scanner sc = new Scanner(commands);

        while(sc.hasNextLine()) {
            String command = sc.nextLine();  // get line
            String algo = command.substring(0, command.indexOf(":"));  // reads algorithm part of command
            String array = command.substring(command.indexOf("[") + 1, command.indexOf("]"));  // reads array part of command
            String d = command.substring(command.indexOf(":") + 2, command.indexOf(":") + 3);  // gets d value
            String k = command.substring(command.indexOf(":") + 6, command.indexOf(":") + 7);  // gets k value
            // splits array part of command into numbers
            // converts to int[]
            String[] nums = array.split(",");
            int[] arr = new int[nums.length];
            for(int i=0; i<nums.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }

            // choose method based on algo string
            switch(algo) {
                case "insertionSort":
                    insertionSort(arr);
                    System.out.println("insertionSort: " + Arrays.toString(arr));
                    break;
                case "bubbleSort":
                    bubbleSort(arr);
                    System.out.println("bubbleSort: " + Arrays.toString(arr));
                    break;
                case "shellSort":
                    shellSort(arr);
                    System.out.println("shellSort: " + Arrays.toString(arr));
                    break;
                case "quickSort":
                    quickSort(arr);
                    System.out.println("quickSort: " + Arrays.toString(arr));
                    break;
                case "mergeSort":
                    mergeSort(arr);
                    System.out.println("mergeSort: " + Arrays.toString(arr));
                    break;
                case "upgradedQuickSort":
                    upgradedQuickSort(arr, Integer.parseInt(d), Integer.parseInt(k));
                    System.out.println("upgradedQuickSort: " + Arrays.toString(arr));
                    break;
            }
        }

        sc.close();
    }

    /*
     * Get time before and after sorting and print difference.
     */
    void runExperiments(int[] arr){
        long start;
        long end;
        long elapse;
        int[] testArr = arr;  // use a different array variable to not overwrite arr
        
        start = System.nanoTime();
        insertionSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("insertion: " + elapse);
        testArr = arr;

        start = System.nanoTime();
        bubbleSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("bubble: " + elapse);
        testArr = arr;

        start = System.nanoTime();
        shellSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("shell: " + elapse);
        testArr = arr;

        start = System.nanoTime();
        quickSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("quick: " + elapse);
        testArr = arr;

        start = System.nanoTime();
        mergeSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("merge: " + elapse);
        testArr = arr;

        start = System.nanoTime();
        upgradedQuickSort(testArr, 2, 3);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("upgraded quick: " + elapse);
        testArr = arr;
    }
}
