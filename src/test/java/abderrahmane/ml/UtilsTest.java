package abderrahmane.ml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    public void testMedian() {
        assertEquals(1, Utils.median(new double[] { 1 }));
        assertEquals(1, Utils.median(new double[] { 1, 1 }));
        assertEquals(1.5, Utils.median(new double[] { 4, 1, 2, 1 }));
        assertEquals(6, Utils.median(new double[] { 9, 0, 2, 5, 6, 8, 9 }));
        assertEquals(2, Utils.median(new double[] { 0, 8, 0, 4, 0, 4, 6, 0 }));
        assertEquals(23, Utils.median(new double[] { 23, 28, 22, 34, 16, 23, 32 }));
    }

    @Test
    public void testSetColumn() {
        List<List<Integer>> table = new ArrayList<>(List.of(
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4)));

        List<List<Integer>> expected = new ArrayList<>(List.of(
                List.of(1, 1, 3, 4),
                List.of(1, 2, 3, 4),
                List.of(1, 3, 3, 4),
                List.of(1, 4, 3, 4),
                List.of(1, 5, 3, 4)));

        table = Utils.setColumn(table, List.of(1, 2, 3, 4, 5), 1);
        
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                assertEquals(expected.get(i).get(j), table.get(i).get(j));
            }
        }
    }
}
