package com.playtika.automation.tasks.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Text {

    private final String text;
    private static final Logger LOG
            = LoggerFactory.getLogger(Text.class);

    public Text(String text) {

        if (text == null) {
            LOG.error("Text can't be NULL",
                    new NullPointerException("Text can't be NULL"));
        }
        this.text = text;

    }

    public List<String> getTopWords(int limit) {
        if (limit <= 0) {
            LOG.error("Incorrect word counter <= 0",
                    new IllegalArgumentException());
        }
        return wordsCollection().stream()
                .distinct()
                .sorted()
                .limit(limit)
                .collect(toList());
    }

    public Map<String, Long> getWordsFrequencies() {
        return wordsCollection().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int getLengthInChars() {
        return wordsCollection().stream()
                .mapToInt(String::length)
                .sum();
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
