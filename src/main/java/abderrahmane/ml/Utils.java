package abderrahmane.ml;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Utils {
    public static <T> List<T> getColumns (List<List<T>> table, int index) {
        List<T> columns = new ArrayList<>();

        for (List<T> row : table) columns.add(row.get(index));

        return columns;
    }

    public static <T> List<List<T>> removeColumns (List<List<T>> table, int index) {
        List<List<T>> values = new ArrayList<>();

        for (List<T> row : table) {
            List<T> newRow = new ArrayList<>();

            for (int i = 0; i < row.size(); i++) {
                if (i != index) newRow.add(row.get(i));
            }

            values.add(newRow);
        }

        return values;
    }

    public static <T> List<T> removeValue (List<T> table, int index) {
        List<T> values = new ArrayList<>();

        for (int i = 0; i < table.size(); i++) {
            if (index != i) values.add(table.get(i));
        }

        return values;
    }

    public static <T> Set<T> getUnique (List<T> table) {
        Set<T> uniqueValues = new TreeSet<>();

        for (T elt : table) uniqueValues.add(elt);

        return uniqueValues;
    }

    public static int getOccurrence (List<? extends Object> lst, Object value) {
        return lst.stream().filter(v -> v.equals(value)).toArray().length;
    }

    public static int getIndexOfSmallest (List<Double> lst) {
        Double min = Double.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < lst.size(); i++) {
            Double elt = lst.get(i);

            if (elt < min) {
                min = elt;
                index = i;
            }
        }

        return index;
    }
}
