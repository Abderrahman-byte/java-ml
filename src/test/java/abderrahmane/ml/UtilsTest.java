package abderrahmane.ml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    public void testMedian () {
        assertEquals(1, Utils.median(new double[]{1}));
        assertEquals(1, Utils.median(new double[]{1, 1}));
        assertEquals(1.5, Utils.median(new double[]{4, 1, 2, 1}));
        assertEquals(6, Utils.median(new double[]{9, 0, 2, 5, 6, 8, 9}));
        assertEquals(2, Utils.median(new double[]{0, 8, 0, 4, 0, 4, 6, 0}));
        assertEquals(23, Utils.median(new double[]{23, 28, 22, 34, 16, 23, 32}));
    }
}
