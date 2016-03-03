

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven on 16-Feb-16.
 */
public class QuickSorter {

    public static int[] sortArray(int[] a) {
        List<Integer> ints = new ArrayList<Integer>();
        for(int i: a) {
            ints.add(i);
        }
        quickSort(ints);
        for (int i = 0; i < ints.size(); i++) {
            a[i] = ints.get(i);
        }
        return a;
    }

    private static void quickSort(List<Integer> items) {
        if (items.size() > 1) {
            int pivot;
            List<Integer> smaller = new ArrayList<Integer>();
            List<Integer> same = new ArrayList<Integer>();
            List<Integer> larger = new ArrayList<Integer>();

            int center = items.size() / 2;

            //TODO: check pivot properly
            if (items.get(0) >= items.get(center) && items.get(0) >= items.get(items.size() - 1)) {
                pivot = items.get(0);
            }
            else if (items.get(center) > items.get(0) && items.get(center) > items.get(items.size() - 1)) {
                pivot = items.get(center);
            }
            else {
                pivot = items.get(items.size()-1);
            }

            for (Integer i : items) {
                if (i < pivot) {
                    smaller.add(i);
                }
                else if (i > pivot) {
                    larger.add(i);
                }
                else {
                    same.add(i);
                }
            }

            quickSort(smaller);
            quickSort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }
}
