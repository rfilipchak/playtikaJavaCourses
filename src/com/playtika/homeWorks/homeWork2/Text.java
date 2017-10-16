package com.playtika.homeWorks.homeWork2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    private final String text;

    public Text(String text) {

        if (text.equals(null)) {
            throw new NullPointerException(" Text can't be NULL");
        } else {
            this.text = text;
        }
    }

    public List<String> getTopWords(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(" Incorrect word counter <= 0");
        }
        Set<String> uniqueWords = new TreeSet<String>();
        uniqueWords.addAll(wordsCollection());
        if (limit >= wordsCollection().size()) {
            return new ArrayList<>(uniqueWords).subList(0, uniqueWords.size());
        } else {
            return new ArrayList<>(uniqueWords).subList(0, limit);
        }
    }

    public Map<String, Integer> getWordsFrequencies() {
        Map<String, Integer> wordsFrequency = new HashMap<>();
        if (wordsCollection().size() == 0) {
            throw new IllegalArgumentException("Can't count getWordsFrequencies() for ampty collection");
        }
        List<String> topWords = getTopWords(wordsCollection().size());

        for (String word : topWords) {
            int count = 0;
            for (int i = 0; i < wordsCollection().size(); i++) {
                if (word.equals(wordsCollection().get(i))) {
                    count++;
                }
            }
            wordsFrequency.put(word, count);
        }
        return wordsFrequency;
    }

    public int getLengthInChars() {
        int totaWordsSumm = 0;
        for (String word : wordsCollection()) {
            totaWordsSumm += word.length();
        }
        return totaWordsSumm;
    }

    private List<String> wordsCollection() {
        Pattern pattern = Pattern.compile("([a-zA-Z0-9а-яА-Я]+)");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }


}
