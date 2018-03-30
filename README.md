# CoinOptimizer

Report the optimal distribution of coins for a dollar amount.

## Requirements

[JDK 9](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)

## Run the project locally

`java -jar out/artifacts/CoinOptimizer_jar/CoinOptimizer.jar <dollarValue>`

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
{ 'silver-dollar': 0, 'half-dollar': 1, 'quarter': 1, 'dime': 2, 'nickel': 0, 'penny': 4
}
```
