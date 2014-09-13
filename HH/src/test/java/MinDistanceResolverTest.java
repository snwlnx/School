import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinDistanceResolverTest {

    private MinDistanceResolver resolver;

    @Before
    public void init() throws Exception {
        resolver = new MinDistanceResolver();
    }

    @Test
    public void testGetMinimumDistance() throws Exception {
        resolver.addPoint(10,10);
        resolver.addPoint(20,10);
        resolver.addPoint(20,15);
        assertEquals(5,resolver.getMinimumDistance(),0.0);
        resolver.addPoint(15, 16);
        resolver.addPoint(12.5, 0);
        resolver.addPoint(17, 18);
        assertEquals(2.82,resolver.getMinimumDistance(),0.01);
        resolver.addPoint(-10, 7);
        resolver.addPoint(-9, 8);
        resolver.addPoint(0, 0);
        resolver.addPoint(10, 7);
        assertEquals(1.41,resolver.getMinimumDistance(),0.01);
    }
}