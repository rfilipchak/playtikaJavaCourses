package com.playtika.automation.tasks.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileAndTextReader {
    private static final Logger LOG
            = LoggerFactory.getLogger(FileAndTextReader.class);

    private final String dyrectoryName;

    public FileAndTextReader(String dyrectoryName) throws IOException {
        if(dyrectoryName == null){
            LOG.error("directory can't be null", new NullPointerException());
        }
        this.dyrectoryName = dyrectoryName;

    }

    public void filesFromDirectoryData() throws IOException {
        Arrays.stream(new File(dyrectoryName).listFiles())
                .forEach(file -> fileParameters(file));
    }

    public Map<String, Long> agreateadGetWordsFrequenciesForDirectoriesFiles() throws IOException {
       try {
           return Files.list(Paths.get(dyrectoryName)).map(path -> readFileToStringLine(path))
                   .flatMap(Collection::stream)
                   .map(s -> s.split("\\s+"))
                   .flatMap(Arrays::stream)
                   .filter(w -> w.matches("([a-zA-Z0-9а-яА-Я]+)"))
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       }catch (IOException e){
           LOG.error("No such durectory ", e);
           return Collections.emptyMap();
       }
    }
    private List<String> readFileToStringLine(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOG.debug("Empty collection",e);
            return Collections.emptyList();
        }
    }

    private void fileParameters(File file) {
        try {
            System.out.printf("File path: %s; File size: %d; File creation date: %s%n",
                    file.getPath(),
                    file.length(),
                    getCreationDateTime(file));
        } catch (IOException e) {
            LOG.error("Getting file parrameters error",e);
        }

    }

    private LocalDateTime getCreationDateTime(File file) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        return attr.creationTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
