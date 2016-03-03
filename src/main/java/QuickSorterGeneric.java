
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven on 16-Feb-16.
 */
public class QuickSorterGeneric<T> {

    public <T extends Comparable<T>> T[] sortArray(T[] a) {
        List<T> list = new ArrayList<T>();
        for(T i: a) {
            list.add(i);
        }
        quickSort(list);
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    private <T extends Comparable<T>> void quickSort(List<T> items) {
        if (items.size() > 1) {
            T pivot;
            List<T> smaller = new ArrayList<T>();
            List<T> same = new ArrayList<T>();
            List<T> larger = new ArrayList<T>();

            int center = items.size() / 2;

            //TODO: check pivot properly
            if (items.get(0).compareTo(items.get(center)) != 0 && items.get(0).compareTo(items.get(items.size() - 1)) != 0) {
                pivot = items.get(0);
            }
            else if (items.get(center).compareTo(items.get(0)) != 0 && items.get(center).compareTo(items.get(items.size() - 1)) != 0) {
                pivot = items.get(center);
            }
            else {
                pivot = items.get(items.size()-1);
            }

            for (T i : items) {
                if (i.compareTo(pivot) == -1) {
                    smaller.add(i);
                }
                else if (i.compareTo(pivot) == 1) {
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
