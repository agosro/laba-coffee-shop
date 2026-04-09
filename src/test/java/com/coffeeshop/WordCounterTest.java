package com.coffeeshop;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void appendsResultsInsteadOfOverwriting() {
        File input = new File("input.txt");
        assertTrue(input.exists(), "input.txt must exist in the project root");

        File output = new File("target/test-output.txt");
        if (output.exists()) {
            assertTrue(output.delete(), "Could not delete test output file");
        }

        WordCounter.countWordsInFile(input.getPath(), output.getPath(), "coffee");
        long sizeAfterFirst = output.length();
        assertTrue(sizeAfterFirst > 0, "It must write content on the first run");

        WordCounter.countWordsInFile(input.getPath(), output.getPath(), "coffee");
        long sizeAfterSecond = output.length();

        assertTrue(sizeAfterSecond > sizeAfterFirst, "Second run must append results, not overwrite");
    }
}
