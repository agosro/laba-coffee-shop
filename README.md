# Coffee Shop — Home Task

## Task requirements

1. **Add 3 enums to the project**
2. **Count the amount of “special words” inside a file**
3. **As a result, provide a new file with information**
4. **Implementation must use**:
   - `StringUtils` (Apache Commons Lang)
   - `FileUtils` (Apache Commons IO)
5. **The output file must NOT clean up previous results** (must append)
6. **Use any article you want** (input text can be arbitrary)

## What was implemented

### 1) Enums added
Located in `src/main/java/com/coffeeshop/model/`:

- `OrderStatus` (`NEW`, `PROCESSING`, `COMPLETED`, `CANCELLED`)
- `PaymentMethod` (`CASH`, `CREDIT_CARD`, `DEBIT_CARD`, `MOBILE_PAY`)
- `DiscountType` (`NONE`, `PERCENTAGE`, `FIXED_AMOUNT`)

These enums are now also **used in `com.coffeeshop.Main` (Demo 1)** to demonstrate they work at runtime.

### 2) Word counter (StringUtils + FileUtils)
Class: `src/main/java/com/coffeeshop/WordCounter.java`

- Reads the whole input file using `FileUtils.readFileToString(...)`
- Counts occurrences using `StringUtils.countMatches(...)` (case-insensitive)
- Writes a new result line to the output file using `FileUtils.writeStringToFile(..., append=true)`
  - This guarantees previous results are preserved

### 3) Input "article"
File: `input.txt` (project root)

This is a small English sample text that contains multiple occurrences of the word `coffee`.

### 4) Automated test for “append” behavior
File: `src/test/java/com/coffeeshop/WordCounterTest.java`

The test runs the counter twice and checks that the output file size increases on the second run.

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
