package com.playtika.homeWorks.HomeWork3;

import com.playtika.homeWorks.homeWork2.Text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class FileAndTextReader {
    private final String directoryName;

    public FileAndTextReader(String directoryName) {
        if (directoryName.equals(null)) {
            throw new NullPointerException("Dyrectory can't be NULL");
        }
        this.directoryName = directoryName;
    }

    public void filesFromDirectoryData() throws IOException {
        File[] files = new File(directoryName).listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.printf("File path: %s; File size: %d; File creation date: %s%n",
                    files[i].getPath(),
                    files[i].length(),
                    getCreationDateTime(files[i]));
        }
    }

    public Map<String, Integer> agreateadGetWordsFrequenciesForDirectoriesFiles() throws IOException {

        File myFolder = new File(directoryName);
        if (!myFolder.exists()) {
            throw new NullPointerException("No such dyrectory");
        }
        Map<String, Integer> wordsFrequencies = new HashMap<>();
        for (File file : myFolder.listFiles()) {
            if(file.isFile()) {
                Text text = new Text(readFileToString(file));
                Map<String, Integer> getWordFromFile = text.getWordsFrequencies();
                for (String word : getWordFromFile.keySet()) {
                    Integer count = wordsFrequencies.get(word) == null ? 0 : wordsFrequencies.get(word);
                    wordsFrequencies.put(word, count + getWordFromFile.get(word));
                }
            }
        }
        return wordsFrequencies;
    }

    private String readFileToString(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    private LocalDateTime getCreationDateTime(File file) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        return attr.creationTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
