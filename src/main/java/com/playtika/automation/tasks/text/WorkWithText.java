package com.playtika.automation.tasks.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkWithText {
    private static final Logger LOG
            = LoggerFactory.getLogger(WorkWithText.class);

    public static void main(String[] args) {
        Text testText = new Text(" dagtrt rtewt ewqewq qew");

        LOG.info(String.valueOf(testText.getTopWords(2)));
        LOG.info(String.valueOf(testText.getWordsFrequencies()));
        LOG.info(String.valueOf(testText.getLengthInChars()));
    }

    public int countWord(String text) {
        if (text == null) {
            return 0;
        }
        String trimmedText = text.trim();
        if ("".equals(trimmedText)) {
            return 0;
        }
        return trimmedText.split("[\\s,.!?]+").length;
    }
}
