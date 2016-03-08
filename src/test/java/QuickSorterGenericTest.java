import Sorters.QuickSorterGeneric;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sven_ on 03/03/2016.
 */
public class QuickSorterGenericTest {
    QuickSorterGeneric<Integer> qs;
    Integer[] testArray = {8, 6, 0, 7, 5, 3, 1};
    Integer[] expectedResult = {0, 1, 3, 5, 6, 7, 8};

    @Before
    public void setup()  {
        qs = new QuickSorterGeneric<Integer>();
    }

    @Test
    public void testSorter() {
        Integer[] actualResult = qs.sortArray(testArray);
        Assert.assertArrayEquals(actualResult, expectedResult);
    }
}
