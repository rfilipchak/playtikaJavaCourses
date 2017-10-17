package com.playtika.homeWorks.homeWork2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCountTest {
    @Test
    public void textIsSplittedByWhitespase() {
        int wordCount = new WordCount().countWord("I have 5 dollars");//Ctrr + alt +f ..... ctr +alt
        assertEquals(4, wordCount);
    }

    @Test
    public void emtyTextWithSplitterCheck() {
        int wordCount = new WordCount().countWord(" ");
        assertEquals(0, wordCount);
    }

    @Test
    public void emtyTextWithSeveralSplittersCheck() {
        int wordCount = new WordCount().countWord("  ");
        String[] st = "  ".trim().split(" ");
        assertEquals(0, wordCount);
    }

    @Test
    public void emtyTextCheck() {
        int wordCount = new WordCount().countWord("");
        assertEquals(0, wordCount);
    }

    @Test
    public void oneWordWithSlitterAfterCheck() {
        int wordCount = new WordCount().countWord("life ");
        assertEquals(1, wordCount);
    }

    @Test
    public void oneWordWithSlitterBeforeCheck() {
        int wordCount = new WordCount().countWord(" life");
        assertEquals(1, wordCount);
    }

    @Test
    public void oneWordWithSlitterFrameCheck() {
        int wordCount = new WordCount().countWord(" life ");
        assertEquals(1, wordCount);
    }

    @Test
    public void oneWordSentesceCheck() {
        int wordCount = new WordCount().countWord("life");
        assertEquals(1, wordCount);
    }

    @Test
    public void textIsSplittedBySeveralWhitespase() {
        int wordCount = new WordCount().countWord("      I have        5         dollars        ");
        assertEquals(4, wordCount);
    }

    @Test
    public void nullIsteadTextCheck() {
        int wordCount = new WordCount().countWord(null);
        assertEquals(0, wordCount);
    }

}
