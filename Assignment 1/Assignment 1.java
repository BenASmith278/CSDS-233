class FibSeq {
    public static void main(String[] Args) {
        System.out.println(fibIter(10));
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

    private static void fillArray(int n) {
        int[] arr = new int[n];
        int tail = 0;

        while(tail < n) {
            
            tail++;
        }
    }
}
