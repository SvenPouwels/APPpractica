

/**
 * Created by Sven on 16-Feb-16.
 */
public class InsertionSorterGeneric<T> {

    public <T extends Comparable<T>> T[] sortArray(T[] a) {
        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            int j = p;
            while (j > 0 && (tmp.compareTo(a[j - 1]) < 0)) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }
        return a;
    }
}
