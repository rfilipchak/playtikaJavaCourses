package com.playtika.automation.tasks.text;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkWithTextTest {
    @Test
    public void textIsSplittedByWhitespase() {
        int wordCount = new WorkWithText().countWord("I have 5 dollars");//Ctrr + alt +f ..... ctr +alt
        assertEquals(4, wordCount);
    }

    @Test
    public void emtyTextWithSplitterCheck() {
        int wordCount = new WorkWithText().countWord(" ");
        assertEquals(0, wordCount);
    }

    @Test
    public void emtyTextWithSeveralSplittersCheck() {
        int wordCount = new WorkWithText().countWord("  ");
        String[] st = "  ".trim().split(" ");
        assertEquals(0, wordCount);
    }

    @Test
    public void emtyTextCheck() {
        int wordCount = new WorkWithText().countWord("");
        assertEquals(0, wordCount);
    }

    @Test
    public void oneWordWithSlitterAfterCheck() {
        int wordCount = new WorkWithText().countWord("life ");
        assertEquals(1, wordCount);
    }

    @Test
    public void oneWordWithSlitterBeforeCheck() {
        int wordCount = new WorkWithText().countWord(" life");
        assertEquals(1, wordCount);
    }

    @Test
    public void oneWordWithSlitterFrameCheck() {
        int wordCount = new WorkWithText().countWord(" life ");
        assertEquals(1, wordCount);
    }

    @Test
    public void oneWordSentesceCheck() {
        int wordCount = new WorkWithText().countWord("life");
        assertEquals(1, wordCount);
    }

    @Test
    public void textIsSplittedBySeveralWhitespase() {
        int wordCount = new WorkWithText().countWord("      I have        5         dollars        ");
        assertEquals(4, wordCount);
    }

    @Test
    public void nullIsteadTextCheck() {
        int wordCount = new WorkWithText().countWord(null);
        assertEquals(0, wordCount);
    }

}
