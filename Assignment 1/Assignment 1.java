class FibSeq {
    public static void main(String[] Args) {
        System.out.println(fibIter(4));
    }

    public static int fibIter(int n) {
        if (n <= 0) {
            return 0;
        }

        int prev = 1;
        int cur = 1;
        int temp;

        for (int i=0; i<n; i++) {
            temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        
        return cur;
    }
}