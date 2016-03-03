
/**
 * Created by Sven on 16-Feb-16.
 */
public class MergeSorterGeneric<T> {
    public <T extends Comparable<T>> T[] sortArray(T[] a) {
        T[] tmpArray = (T[]) new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
        return a;
    }

    private <T extends Comparable<T>> void mergeSort(T[] a, T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) /2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }


    private <T extends Comparable<T>> void merge(T[] a, T[] tmpArray, int left, int center, int right) {
        int leftEnd = center - 1;
        int rightEnd = right;
        int leftPointer = left;
        int rightPointer = center;
        int tmpPointer = left;

        while (leftPointer <= leftEnd && rightPointer <= rightEnd)
            if (a[leftPointer].compareTo(a[rightPointer]) <= 0){
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
