package abderrahmane.ml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import abderrahmane.ml.dt.DecisionTree;

public class App {
    public static void main( String[] args ) {
        try {
            BufferedReader csv = new BufferedReader(new FileReader("data_2.csv"));

            String featuresNames[] = csv.readLine().split(",");

            List<List<String>> values = csv.lines().map(line -> {
                return List.of(line.split(","));
            }).toList();

            List<String> classValues = Utils.getColumns(values, values.get(0).size() - 1);
            values = Utils.removeColumns(values, values.get(0).size() - 1);

            DecisionTree dt = new DecisionTree();

            dt.build(values, classValues);
            System.out.println(dt.predict(List.of("B","F","LOW","HIGH","A","B")));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
