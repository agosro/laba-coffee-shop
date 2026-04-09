package com.coffeeshop;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

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

        try {
            String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);

            String lowerContent = StringUtils.lowerCase(content);
            String lowerWord = StringUtils.lowerCase(wordToCount);

            int count = StringUtils.countMatches(lowerContent, lowerWord);

            String resultLine = String.format(
                    "%s | file=%s | word='%s' | count=%d%n",
                    LocalDateTime.now(),
                    inputFile.getName(),
                    wordToCount,
                    count
            );

            FileUtils.writeStringToFile(outputFile, resultLine, StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            throw new RuntimeException("Error processing files: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        countWordsInFile("input.txt", "output.txt", "coffee");
    }
}
