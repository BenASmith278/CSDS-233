import java.util.Arrays;

public class Demo {
    static private int[] array; 
    static public int[] testArr;  // use a different array for testing to keep tests consistent
    static Sort Sorter = new Sort();

    public static void main(String[] args){
        int[] sizes = new int[] {10, 20, 50, 100, 200, 500, 1000, 2000};  // all the sizes of array to test

        System.out.println("RANDOM INPUTS:");
        for(int n : sizes) {  // for each size run the experiments
            System.out.println("N=" + n);
            array = Sorter.generateRandomArray(n, n);
            runExperiments();
            System.out.println();
        }

        System.out.println("SORTED INPUTS:");
        for(int n : sizes) {
            System.out.println("N=" + n);
            array = makeSortedArray(n);
            runExperiments();
            System.out.println();
        }

        System.out.println("REVERSE-SORTED INPUTS:");
        for(int n : sizes) {
            System.out.println("N=" + n);
            array = makeRSortedArray(n);
            runExperiments();
            System.out.println();
        }

    }

    static int[] makeSortedArray(int n) {  // makes sorted array of size n
        int[] nums = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = i;
        }

        return nums;
    }

    static int[] makeRSortedArray(int n) {  // makes reverse-sorted array of size n
        int[] nums = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = n-i;
        }

        return nums;
    }

    /*
     * Get time before and after sorting and print difference.
     */
    static void runExperiments(){
        long start;
        long end;
        long elapse;
        setArrays();

        start = System.nanoTime();
        Sorter.insertionSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("insertion: " + elapse);
        setArrays();  // reset array so tests are consistent

        start = System.nanoTime();
        Sorter.bubbleSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("bubble: " + elapse);
        setArrays();

        start = System.nanoTime();
        Sorter.shellSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("shell: " + elapse);
        setArrays();

        start = System.nanoTime();
        Sorter.quickSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("quick: " + elapse);
        setArrays();

        start = System.nanoTime();
        Sorter.mergeSort(testArr);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("merge: " + elapse);
        setArrays();

        start = System.nanoTime();
        Sorter.upgradedQuickSort(testArr, 2, 3);
        end = System.nanoTime();
        elapse = end - start;
        System.out.println("upgraded quick: " + elapse);
        setArrays();
    }

    static void setArrays(){  // reset testArr elements to array values
        testArr = new int[array.length];

        for(int i=0; i<array.length; i++) {
            testArr[i] = array[i];
        }
    }
}
