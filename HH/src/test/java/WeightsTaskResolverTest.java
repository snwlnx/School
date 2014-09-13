import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WeightsTaskResolverTest {
    private WeightsTaskResolver resolver;

    @Before
    public void init() throws Exception {
        resolver = new WeightsTaskResolver();
    }

    @Test
    public void testEqualsSubSequence() throws Exception {
        int[] arr;

        arr = new int[]{2,3,4,5,6};
        assertTrue(Arrays.equals(new Integer[]{2,3,5},resolver.findEqualsSubLists(arr).get(0).toArray()));
        assertTrue(resolver.checkContainsWeight(arr,7));

        arr = new int[]{25,25,25,25,100};
        assertTrue(Arrays.equals(new Integer[]{25,25,25,25},resolver.findEqualsSubLists(arr).get(0).toArray()));
        assertTrue(resolver.checkContainsWeight(arr,75));

        arr = new int[]{1000,500,500};
        assertTrue(Arrays.equals(new Integer[]{1000},resolver.findEqualsSubLists(arr).get(0).toArray()));
        assertTrue(!resolver.checkContainsWeight(arr,100));

        arr = new int[]{10,9,8,13,12};
        assertTrue(resolver.findEqualsSubLists(arr) == null);
        assertTrue(resolver.checkContainsWeight(arr,10));
    }
}