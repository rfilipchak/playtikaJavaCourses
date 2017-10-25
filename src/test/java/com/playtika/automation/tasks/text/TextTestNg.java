package com.playtika.automation.tasks.text;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TextTestNg {
    Text text = new Text("Я считываю текст в строку % *.");
    Text textWitDublicates = new Text("Я считываю текст в строку, Я считываю текст");


    @Test(expectedExceptions = NullPointerException.class, groups = "allTextTests")
    public void nullTextCouldNotBeProcessed() {
        new Text(null);
    }


    @Test(groups = {"OutTextTest", "allTextTests"},
            dependsOnMethods = "nullTextCouldNotBeProcessed")
    public void punctuationProcessedLikeEmptyCollection() {
        assertThat((new Text(" ,....!").getTopWords(5)), is(emptyCollectionOf(String.class)));
    }

    @Test(groups = {"OutTextTest", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void invisibleSymbolsProcessedLikeEmptyCollection() {
        assertThat((new Text("\\\n\\\t\\\f\\\r").getTopWords(5)), is(emptyCollectionOf(String.class)));
    }

    @Test(groups = {"OutTextTest", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void symbolsProcessedLikeEmptyCollection() {

        assertThat((new Text("&^(()^&%*^^^*(*()@#)").getTopWords(5)), is(emptyCollectionOf(String.class)));
    }

    @Test(groups = {"OutTextTest", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void emptyTextProcessedLikeEmptyCollection() {

        assertThat(new Text("").getTopWords(5), is(empty()));
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            groups = {"getTopWords", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void getTopWordCouldNotBeProcessedZero() {
        text.getTopWords(0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            groups = {"getTopWords", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void getTopWordCouldNotBeProcessedNegativeCount() {
        text.getTopWords(-15);
    }

    @Test(groups = {"getTopWords", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void getTopWordsReturnedCorrectWordsAndOder() throws Exception {
        assertThat(text.getTopWords(5), is(Arrays.asList("в", "строку", "считываю", "текст", "я")));
    }

    @Test(groups = {"getTopWords", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void getTopWordsForApperCaseSymbols() {
        assertThat(new Text("StrinG IntEGeR DouBlE ").getTopWords(3), is(Arrays.asList("double", "integer", "string")));
    }

    @Test(groups = {"getTopWords", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "punctuationProcessedLikeEmptyCollection"})
    public void getTopWordsReturnedCorrectResultFromTextWithDublicates() throws Exception {
        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(5)
                , is(Arrays.asList("в", "строку", "считываю", "текст", "я")));
    }


    @Test(groups = {"getWordsFrequencies", "allTextTests"},
            dependsOnMethods = "nullTextCouldNotBeProcessed")
    public void getWordsFrequenciesReturnedCorrectAmountWordsFrequency() {
        Map<String, Long> testWordFrequencies = new HashMap<>();
        testWordFrequencies.put("я", 2L);
        testWordFrequencies.put("в", 1L);
        testWordFrequencies.put("строку", 1L);
        testWordFrequencies.put("считываю", 2L);
        testWordFrequencies.put("текст", 2L);
        assertThat(textWitDublicates.getWordsFrequencies(), is(testWordFrequencies));
    }

    @Test(groups = {"getWordsFrequencies", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "getWordsFrequenciesReturnedCorrectAmountWordsFrequency"})
    public void getWordsFrequenciesReturnedResultForEmptyText() {
        assertThat(new Text("").getWordsFrequencies(), is(Collections.EMPTY_MAP));
    }

    @Test(groups = {"getTopWords", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "emptyTextProcessedLikeEmptyCollection"})
    public void getTopWordsProcessedMoreThanMaxLimitOfWordsAsMax() throws Exception {
        int highestLimit = 1000;
        assertThat(new Text("Я считываю текст в строку, Я считываю текст").getTopWords(highestLimit)
                , is(Arrays.asList("в", "строку", "считываю", "текст", "я")));
    }

    @Test(groups = {"getLengthInChars", "allTextTests"},
            dependsOnMethods = "nullTextCouldNotBeProcessed")
    public void getLengthInCharsReturnTotalEmountOfChars() {

        assertThat(text.getLengthInChars(), is(21));
    }

    @Test(groups = {"getLengthInChars", "allTextTests"},
            dependsOnMethods = {"nullTextCouldNotBeProcessed",
                    "getLengthInCharsReturnTotalEmountOfChars"})
    public void getLengthForEmptyTextEqualZero() {
        assertThat(new Text("")
                .getLengthInChars(), equalTo(0));
    }
}


