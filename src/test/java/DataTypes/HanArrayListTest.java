package DataTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sven_ on 03/03/2016.
 */
public class HanArrayListTest {

    private HanArrayList list;

    @Before
    public void setup() {
        list = new HanArrayList();
    }

    @Test
    public void testAdd() throws Exception {
        list.add(2);
    }

    @Test
    public void testGet() throws Exception {
        list.set(5, 3);
        assertEquals (list.get(5), 3);
    }

    @Test
    public void testSet() throws Exception {
        list.set(2, 10);
    }
}