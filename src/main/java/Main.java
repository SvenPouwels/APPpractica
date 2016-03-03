import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSorters();
        testGenericSorters();
    }

    public static void testSorters() {
        int[] testNumbers = {8, 6, 0, 7, 5, 3, 1};
        int[] insertionSorted = InsertionSorter.sortArray(testNumbers);
        System.out.println(Arrays.toString(insertionSorted));

        int[] testNumbers2 = {8, 6, 0, 7, 5, 3, 1};
        int[] mergeSorted = MergeSorter.sortArray(testNumbers2);
        System.out.println(Arrays.toString(mergeSorted));

        int[] testNumbers3 = {8, 6, 0, 7, 5, 3, 1};
        int[] quickSorted = QuickSorter.sortArray(testNumbers3);
        System.out.println(Arrays.toString(quickSorted));
    }

    public static void testGenericSorters() {
        InsertionSorterGeneric<Integer> is = new InsertionSorterGeneric<Integer>();
        Integer[] testNumbers4 = {8, 6, 0, 7, 5, 3, 1};
        Integer[] iSortGeneric = is.sortArray(testNumbers4);
        System.out.println(Arrays.toString(iSortGeneric));

        MergeSorterGeneric<Integer> ms = new MergeSorterGeneric<Integer>();
        Integer[] testNumbers5 = {8, 6, 0, 7, 5, 3, 1};
        Integer[] mSortGeneric = ms.sortArray(testNumbers5);
        System.out.println(Arrays.toString(mSortGeneric));

        QuickSorterGeneric<Integer> qs = new QuickSorterGeneric<Integer>();
        Integer[] testNumbers6 = {8, 6, 0, 7, 5, 3, 1};
        Integer[] qSortGeneric = qs.sortArray(testNumbers6);
        System.out.println(Arrays.toString(qSortGeneric));
    }
}
