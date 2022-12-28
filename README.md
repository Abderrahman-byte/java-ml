# Java ML Library

Simple Machine Learning algorithms collection

## Examples

### CSVReader example :

```java
CSVReader csvReader = new CSVReader("dataset.csv", ",");
List<String> header = csvReader.getHeader();

List<List<String>> data = csvReader.getTable(true); // Returns Data as List of lists
```

### Decision Tree example :

The ```DecisionTree``` class is define in ```abderrahmane.ml.dt.DecisionTree``` .

```java
List<List<String>> table = ... // data table
List<String> target = ... // class values

DecisionTree dt = new DecisionTree();
dt.build(features, target);

dt.predict(List.of(/* List of features */)); // Returns String prediction result
```

### Naive Bayes example :

The ```NaiveBayes``` class is define in ```abderrahmane.ml.bayes.NaiveBayes``` .

```java
List<List<String>> table = ... // data table
List<String> target = ... // class values

NaiveBayes bayes = new NaiveBayes(features, target);
bayes.getProbableClass(List.of(/* list of features*/)); // Returns String prediction result
```

### KNN :

The ```NaiveBayes``` class is define in ```abderrahmane.ml.bayes.NaiveBayes``` .


```java
List<List<String>> table = ... // data table
List<String> target = ... // class values

KNN knn = new KNN(features, target);

knn.predict(List.of(/* list of features*/)); // Returns String prediction result
```