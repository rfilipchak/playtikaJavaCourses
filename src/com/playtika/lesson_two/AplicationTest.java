package com.playtika.lesson_two;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AplicationTest {

    private final Aplication aplication = new Aplication();

    @Test
    public void textIsSplittedByWhitespase(){
        int wordCount = aplication.countWord("I have 5 dollars");//Ctrr + alt +f ..... ctr +alt
        assertEquals(4, wordCount);
    }
    @Test
    public void emtyTextWithSplitterCheck(){
        int wordCount = aplication.countWord(" ");
        assertEquals(0,wordCount);
    }
    @Test
    public void emtyTextWithSeveralSplittersCheck(){
        int wordCount = aplication.countWord("  ");
        String [] st = "  ".trim().split(" ");

        System.out.println(st[0]);
        assertEquals("",st[0]);
        assertEquals(0,wordCount);
    }
    @Test
    public void emtyTextCheck(){
        int wordCount = aplication.countWord("");
        assertEquals(0,wordCount);
    }
    @Test
    public void oneWordWithSlitterAfterCheck(){
        int wordCount = aplication.countWord("life ");
        assertEquals(1,wordCount);
    }
    @Test
    public void oneWordWithSlitterBeforeCheck(){
        int wordCount = aplication.countWord(" life");
        assertEquals(1,wordCount);
    }
    @Test
    public void oneWordWithSlitterFrameCheck(){
        int wordCount = aplication.countWord(" life ");
        assertEquals(1,wordCount);
    }

    @Test
    public void oneWordSentesceCheck(){
        int wordCount = aplication.countWord("life");
        assertEquals(1,wordCount);
    }
    @Test
    public void textIsSplittedBySeveralWhitespase(){
        int wordCount = aplication.countWord("      I have        5         dollars        ");
        assertEquals(4, wordCount);
    }
    @Test
    public void textIs(){
        int wordCount = aplication.countWord(" \n I \t \r work");
        assertEquals(2, wordCount);
    }

}