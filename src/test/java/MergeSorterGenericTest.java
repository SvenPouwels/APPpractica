import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sven_ on 03/03/2016.
 */
public class MergeSorterGenericTest {
    MergeSorterGeneric<Integer> ms;
    Integer[] testArray = {8, 6, 0, 7, 5, 3, 1};
    Integer[] expectedResult = {0, 1, 3, 5, 6, 7, 8};

    @Before
    public void setup()  {
        ms = new MergeSorterGeneric<Integer>();
    }

    @Test
    public void testSorter() {
        Integer[] actualResult = ms.sortArray(testArray);
        Assert.assertArrayEquals(actualResult, expectedResult);
    }
}
