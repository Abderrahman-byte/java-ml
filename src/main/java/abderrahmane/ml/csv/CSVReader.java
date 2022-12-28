package abderrahmane.ml.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {
    private BufferedReader reader;
    private FileReader fileReader;
    private String separator;

    public CSVReader (String filename) throws FileNotFoundException {
        this(filename, ",");
    }

    public CSVReader (String filename, String separator) throws FileNotFoundException {
        this.fileReader = new FileReader(filename);
        this.reader = new BufferedReader(this.fileReader);
        this.separator = separator;
    }

    public List<String> getHeader () throws IOException {
        this.reset();

        return List.of(this.reader.readLine().split(separator));
    }

    public List<List<String>> getTable () throws IOException {
        return this.getTable(true);
    }

    public List<List<String>> getTable (boolean includeHeader) throws IOException {
        this.reset();

        if (!includeHeader) this.reader.readLine();

        return this.reader.lines().map(line -> {
            return List.of(line.split(","));
        }).toList();
    }

    public void close () throws IOException {
        this.reader.close();
    }

    private void reset () throws IOException {
        this.reader.mark(0);
        this.reader.reset();
    }
}
