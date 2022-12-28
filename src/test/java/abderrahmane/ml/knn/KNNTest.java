package abderrahmane.ml.knn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import abderrahmane.ml.Utils;
import abderrahmane.ml.csv.CSVReader;

public class KNNTest {
    @Test
    public void predictTest () {
        try {
            CSVReader csvReader = new CSVReader("datasets/data3.csv");
            List<List<String>> table = csvReader.getTable(false);
            List<String> target = Utils.getColumns(table, table.get(0).size() - 1);
            List<List<String>> features = Utils.removeColumns(table, table.get(0).size() -1);

            KNN knn = new KNN(features, target);

            assertEquals("yes", knn.predict(List.of("A","medium","yes","fair")));
            assertEquals("yes", knn.predict(List.of("A","medium","yes","fair"), 3));
        } catch (Exception ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @Test
    public void predictData2Test () {
        try {
            CSVReader csvReader = new CSVReader("datasets/data_2.csv");
            List<List<String>> table = csvReader.getTable(false);
            List<String> target = Utils.getColumns(table, table.get(0).size() - 1);
            List<List<String>> features = Utils.removeColumns(table, table.get(0).size() -1);

            KNN knn = new KNN(features, target);

            assertEquals("drugC", knn.predict(List.of("B","F","LOW","HIGH","A","B")));
            assertEquals("drugX", knn.predict(List.of("B,F,NORMAL,HIGH,B,B".split(",")), 10));
        } catch (Exception ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }
}
