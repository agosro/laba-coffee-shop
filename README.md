# Coffee Shop — Home Task

## Task requirements

1. **Create your own 3 functional interfaces and use lambda functions based on them**
2. **Replace all iterations in project with collection streaming instead**

## What was implemented

### 1) Functional Interfaces & Lambdas added
- **Custom Functional Interfaces**: `FilterCondition<T>`, `PriceCalculator<T>`, and `ActionProcessor<T>` were created in the `model` package.
- **Lambdas**: Lambdas are heavily used in `Main.java` to pass behaviors to our generic collections (e.g., `o -> o.calculateTotal()`).

### 2) Collection Streaming API (Iterations replaced)
- **Loops eliminated**: All traditional `for` and `while` loops across the project were entirely removed and replaced with Java Streams (`.stream().filter()`, `.mapToDouble()`, `.forEach()`).
- **File Word counter (Stream API)**: `WordCounter.java` was refactored. Instead of regular loops, it now uses `Files.lines(...)` to iteratively stream the input file. It counts occurrences line-by-line using `.mapToInt()` and `.sum()`.

## How to run (Windows / cmd.exe)

From the project root (where `pom.xml` is):

### Run tests
```bat
mvn clean test
```

### Package the app
This project uses a "fat jar" build, so dependencies (Apache Commons, Log4j, etc.) are included at runtime.

```bat
mvn -q -DskipTests package
```

After packaging, you should see a shaded jar such as:
- `target\coffee-shop-1.0-shaded.jar`

### Run the main demo (recommended)
Running `Main` is enough for the Home Task because it also calls the word counter.

```bat
java -jar target\coffee-shop-1.0-shaded.jar
```

This will append a new line into `output.txt` in the project root.

### Run the word counter directly (optional)
If you want to run only the counter, you can run the main class directly from the classpath.

```bat
java -cp target\coffee-shop-1.0-shaded.jar com.coffeeshop.WordCounter
```

## Output format

Each run appends a single line similar to:

- `YYYY-MM-DDTHH:MM:SS | file=input.txt | word='coffee' | count=N`

## Notes / limitations

- Counting uses substring matching (`StringUtils.countMatches`). For example, searching for `coffee` would also count `coffeeshop` if it appears. If you need *whole-word* counting only, the implementation can be adjusted.
