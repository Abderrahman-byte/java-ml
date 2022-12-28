
package abderrahmane.ml.dt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import abderrahmane.ml.Utils;
import abderrahmane.ml.csv.CSVReader;

public class DecisionTreeTest {
    @Test
    public void test1 () {
        try {
            CSVReader csvReader = new CSVReader("datasets/data_2.csv");
            List<List<String>> table = csvReader.getTable(false);
            List<String> target = Utils.getColumns(table, table.get(0).size() - 1);
            List<List<String>> features = Utils.removeColumns(table, table.get(0).size() - 1);
            DecisionTree dt = new DecisionTree();

            dt.build(features, target);

            assertEquals("drugC", dt.predict(List.of("B","F","LOW","HIGH","A","B")));
            assertEquals("drugX", dt.predict(List.of("B,F,NORMAL,HIGH,B,B".split(","))));
            assertNull(dt.predict(List.of("B","F","LOW","HIGH","A","LOW")));
        } catch (Exception ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }
}
