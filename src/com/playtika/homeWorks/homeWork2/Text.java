package com.playtika.homeWorks.homeWork2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    private final String text;

    public Text(String text) {

        if (text.equals(null)) throw new NullPointerException(" Text can't be NULL");
        this.text = text;

    }

    public List<String> getTopWords(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException(" Incorrect word counter <= 0");
        }
        Set<String> uniqueWords = new TreeSet<String>(wordsCollection());
        List<String> topWords = new ArrayList<>(uniqueWords);
        if (limit >= wordsCollection().size()) {
            return topWords.subList(0, uniqueWords.size());
        } else {
            return topWords.subList(0, limit);
        }
    }

    public Map<String, Integer> getWordsFrequencies() {
        if (wordsCollection().size() == 0) {
            return Collections.emptyMap();
        }
        Map<String, Integer> wordsFrequency = new HashMap<>();

        for (String word : wordsCollection()) {
            Integer count = wordsFrequency.get(word);
            if (count == null) wordsFrequency.put(word, 1);
            else wordsFrequency.put(word, count + 1);
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
