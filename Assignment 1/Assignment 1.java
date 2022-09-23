import java.lang.Math;

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
        private static int maxSize = 10;

        public static void makeArray() {
            arr = new int[10];
            size = 5;

            for (int i=1;i<5;i++) {
                arr[i] = fibIter(i+1);
            }
            arr[0] = 0;
        }

        public static boolean isFull() {
            if (size == maxSize) {
                return true;
            }

            return false;
        }

        public static void resize() {
            int[] tempArr = new int[maxSize+5];

            for (int i=0;i<maxSize;i++) {
                tempArr[i] = arr[i];

            }

            maxSize += 5;
            arr = tempArr;
        }

        public static void add(int n) {
            if (isFull()) {
                resize();
            }

            arr[++size] = n;
        }

        public static void add(int n, int index) {
            if (index < 0 || index >= maxSize) {
                throw new RuntimeException("Invalid index.");
            }

            arr[index] = n;
            
            if(index > size) {
                size = index;
            }
        }

        public static int ifContains(int n) {
            for (int i=0;i<size;i++) {
                if (arr[i] == n) {
                    return i;
                }
            }

            return -1;
        }

        public static boolean remove(int n) {
            int contains = ifContains(n);

            if (contains != -1) {
                arr[contains] = 0;
                return true;
            }
            
            return false;
        }

        public static int grab() {
            double rand = Math.random() * (maxSize + 1);
            
            return arr[(int)rand];
        }
    }
}
