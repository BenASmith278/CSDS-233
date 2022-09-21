class FibSeq {
    public static int[] arr;

    public static void main(String[] Args) {
        System.out.println(fibIter(10));
        FiboArray.fillArray(10);
        FiboArray.add(69);
        for (int n : arr) {
            System.out.println(n);
        }
    }

    private static int fibIter(int n) {
        /* Iterative Method
        Complexity: O(n) */

        // verify input is valid
        if (n <= 0) {
            throw new RuntimeException("Cannot find Fibonnaci numbers below 1.");
        }

        int prev = 0;
        int cur = 1;
        int temp;

        for (int i=1; i<n; i++) {
            temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        
        return cur;
    }

    private static int fibRecur(int n) {
        /* Recursive Method
        Complexity: O(2^n) */ 

        // verify input is valid
        if (n <= 0) {
            throw new RuntimeException("Cannot find Fibonnaci numbers below 1.");
        // base cases
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibRecur(n-1) + fibRecur(n-2);
        }
    }

    class FiboArray {
        private static int size = 0;

        public static void fillArray(int n) {
            arr = new int[n];
            size = n;

            for (int i=0;i<n;i++) {
                arr[i] = fibIter(i+1);
            }
        }

        public static void add(int n) {
            int[] tempArr = new int[size+1];

            for (int i=0;i<size;i++) {
                tempArr[i] = arr[i];
            }

            tempArr[size++] = n;
            arr = tempArr;
        }

        public static int ifContains(int n) {
            for (int i=0;i<size;i++) {
                if (arr[i] == n) {
                    return i;
                }
            }

            return -1;
        }
    }
}
