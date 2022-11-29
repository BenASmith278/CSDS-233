public class Demo {
    public static void main(String[] args){
        Sort Sorter = new Sort();
        int[] arr;

        System.out.println("RANDOM INPUTS (n=10):");
        arr = Sorter.generateRandomArray(10);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=20):");
        arr = Sorter.generateRandomArray(20);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=50):");
        arr = Sorter.generateRandomArray(50);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=100):");
        arr = Sorter.generateRandomArray(100);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=200):");
        arr = Sorter.generateRandomArray(200);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=500):");
        arr = Sorter.generateRandomArray(500);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=1000):");
        arr = Sorter.generateRandomArray(1000);
        Sorter.runExperiments(arr);

        System.out.println("RANDOM INPUTS (n=2000):");
        arr = Sorter.generateRandomArray(2000);
        Sorter.runExperiments(arr);


        System.out.println("SORTED INPUTS (n=10):");
        arr = makeSortedArray(10);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=20):");
        arr = makeSortedArray(20);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=50):");
        arr = makeSortedArray(50);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=100):");
        arr = makeSortedArray(100);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=200):");
        arr = makeSortedArray(200);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=500):");
        arr = makeSortedArray(500);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=1000):");
        arr = makeSortedArray(1000);
        Sorter.runExperiments(arr);
        
        System.out.println("SORTED INPUTS (n=2000):");
        arr = makeSortedArray(2000);
        Sorter.runExperiments(arr);
        

        System.out.println("REVERSE-SORTED INPUTS (n=10):");
        arr = makeRSortedArray(10);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=20):");
        arr = makeRSortedArray(20);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=50):");
        arr = makeRSortedArray(50);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=100):");
        arr = makeRSortedArray(100);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=200):");
        arr = makeRSortedArray(200);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=500):");
        arr = makeRSortedArray(500);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=1000):");
        arr = makeRSortedArray(1000);
        Sorter.runExperiments(arr);

        System.out.println("REVERSE-SORTED INPUTS (n=2000):");
        arr = makeRSortedArray(2000);
        Sorter.runExperiments(arr);

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
}
