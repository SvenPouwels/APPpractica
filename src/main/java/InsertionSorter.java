

/**
 * Created by Sven on 16-Feb-16.
 */
public class InsertionSorter {

    public static int[] sortArray(int[] a) {
        for (int p = 1; p < a.length; p++) {
            int tmp = a[p];
            int j = p;
            while (j > 0 && tmp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }
        return a;
    }
}
