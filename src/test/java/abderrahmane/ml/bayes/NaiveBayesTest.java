package abderrahmane.ml.bayes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import abderrahmane.ml.Utils;
import abderrahmane.ml.csv.CSVReader;

@TestInstance(Lifecycle.PER_CLASS)
public class NaiveBayesTest {
    private NaiveBayes bayes;
    private CSVReader csvReader;

    @BeforeAll
    public void initDataset() {
        try {
            this.csvReader = new CSVReader("datasets/data_2.csv");
            List<List<String>> table = this.csvReader.getTable(false);
            List<String> target = Utils.getColumns(table, table.get(0).size() - 1);

            this.bayes = new NaiveBayes(table, target);
        } catch (Exception ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @Test
    public void probabilityOfFeatureGivenClassValueTest() {
        assertEquals(4.0 / 11.0, bayes.probability("drugY", 0, "A"));
        assertEquals(7.0 / 11.0, bayes.probability("drugY", 0, "B"));
        assertEquals(7.0 / 11.0, bayes.probability("drugY", 1, "F"));
        assertEquals(4.0 / 11.0, bayes.probability("drugY", 1, "M"));
        assertEquals(0, bayes.probability("drugX", 2, "HIGH"));
        assertEquals(1, bayes.probability("drugA", 2, "HIGH"));
        assertEquals(1, bayes.probability("drugA", 4, "A"));
        assertEquals(1.0 / 5.0, bayes.probability("drugC", 4, "A"));
        assertEquals(2.0 / 4.0, bayes.probability("drugX", 4, "A"));
        assertEquals(0, bayes.probability("drugD", 4, "A"));
    }

    @Test
    public void probabilityOfClass () {
        assertEquals(1.0/21.0, bayes.probability("drugA"));
        assertEquals(5.0/21.0, bayes.probability("drugC"));
        assertEquals(4.0/21.0, bayes.probability("drugX"));
        assertEquals(11.0/21.0, bayes.probability("drugY"));
        assertEquals(0, bayes.probability("drugD"));
    }

    @Test
    public void probabilityTest () {
        assertEquals(0, bayes.probability("drugA", List.of("A","M","HIGH","NORMAL","A","B")));
        assertEquals(0, bayes.probability("drugC", List.of("A","M","HIGH","NORMAL","A","B")));
        assertEquals(0, bayes.probability("drugX", List.of("A","M","HIGH","NORMAL","A","B")));
        assertEquals(0.001135398990736741,bayes.probability("drugY", List.of("A","M","HIGH","NORMAL","A","B")));
    }

    @Test
    public void getProbableClassTest () {
        assertEquals("drugY", bayes.getProbableClass(List.of("A","M","HIGH","NORMAL","A","B")));
    }
}