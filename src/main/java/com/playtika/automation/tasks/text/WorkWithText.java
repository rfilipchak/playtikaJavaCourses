package com.playtika.automation.tasks.text;

public class WorkWithText {
    public static void main(String[] args) {
        Text testText = new Text(" dagtrt rtewt ewqewq qew");

        System.out.println(testText.getTopWords(2));
        System.out.println(testText.getWordsFrequencies());
        System.out.println(testText.getLengthInChars());
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
