class Main {
    public static void main(String[] args) {
        Sort Sorter = new Sort();
        
        int[] toSort = new int[] {0, 4, 7, 13, 9, 6, 15};

        Sorter.insertionSort(toSort);
        Sorter.bubbleSort(toSort);
        Sorter.shellSort(toSort);
        Sorter.quickSort(toSort);
        Sorter.mergeSort(toSort);
        Sorter.upgradedQuickSort(toSort);
    }
}