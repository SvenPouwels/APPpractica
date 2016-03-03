package han.ica.asd;

/**
 * Created by Sven on 16-Feb-16.
 */
public class MergeSorter {
    public static int[] sortArray(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) /2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }


    private static void merge(int[] a, int[] tmpArray, int left, int center, int right) {
        int leftEnd = center - 1;
        int rightEnd = right;
        int leftPointer = left;
        int rightPointer = center;
        int tmpPointer = left;

        while (leftPointer <= leftEnd && rightPointer <= rightEnd)
            if (a[leftPointer] <= a[rightPointer]){
                tmpArray[tmpPointer] = a[leftPointer];
                tmpPointer++;
                leftPointer++;
            }
            else {
                tmpArray[tmpPointer] = a[rightPointer];
                tmpPointer++;
                rightPointer++;
            }

        while (leftPointer <= leftEnd) {
            tmpArray[tmpPointer] = a[leftPointer];
            tmpPointer++;
            leftPointer++;
        }

        while (rightPointer <= rightEnd) {
            tmpArray[tmpPointer] = a[rightPointer];
            tmpPointer++;
            rightPointer++;
        }
        for (int i = left; i <= right; i++) {
            a[i] = tmpArray[i];
        }
    }
}
