# CoinOptimizer

Report the optimal distribution of coins for a dollar amount.

## Requirements

[JDK 9](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)

## Dependencies

[JUnit 4.12](https://junit.org/junit4/)

## Build the project

You can build the project using Maven.

```
mvn clean package
```

## Run the project locally

Run the jar in the target directory after building with Maven.

```
java -jar target/CoinOptimizer-<version>.jar <dollarValue>
```

## Input:

A well-formatted dollar value.

```
java -jar CoinOptimizer.jar 3.50
```

```
java -jar CoinOptimizer.jar \$3,000.50
```

```
java -jar CoinOptimizer.jar '$3'
```

## Output:

A hash representing the optimal distribution of coins.

```
{
  'silver-dollar': 0,
  'half-dollar': 1,
  'quarter': 1,
  'dime': 2,
  'nickel': 0,
  'penny': 4
}
```
