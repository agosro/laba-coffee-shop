package com.coffeeshop;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class WordCounter {

    public static void countWordsInFile(String inputFilePath, String outputFilePath, String wordToCount) {
        if (StringUtils.isBlank(inputFilePath) || StringUtils.isBlank(outputFilePath) || StringUtils.isBlank(wordToCount)) {
            throw new IllegalArgumentException("inputFilePath/outputFilePath/wordToCount must not be blank");
        }

        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (!inputFile.exists() || !inputFile.isFile()) {
            throw new IllegalArgumentException("Input file does not exist or is not a file: " + inputFile.getAbsolutePath());
        }

        String lowerWord = StringUtils.lowerCase(wordToCount);

        try (Stream<String> lines = Files.lines(inputFile.toPath(), StandardCharsets.UTF_8)) {
            long count = lines
                    .map(StringUtils::lowerCase)
                    .mapToInt(line -> StringUtils.countMatches(line, lowerWord))
                    .sum();

            String resultLine = String.format(
                    "%s | file=%s | word='%s' | count=%d%n",
                    LocalDateTime.now(),
                    inputFile.getName(),
                    wordToCount,
                    count
            );

            Files.writeString(outputFile.toPath(), resultLine, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Error processing files: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        countWordsInFile("src/main/resources/input.txt", "src/main/resources/output.txt", "coffee");
    }
}
