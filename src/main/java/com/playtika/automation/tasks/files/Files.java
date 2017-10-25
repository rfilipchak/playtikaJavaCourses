package com.playtika.automation.tasks.files;

import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class Files {
    private static final org.slf4j.Logger LOG
            = LoggerFactory.getLogger(Files.class);

    public static void main(String[] args) throws IOException {
        String fileFirst = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\text1.txt";
        String fileSecond = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\text2.txt";
        String fileCopySecond = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\fileCopySecond.txt";
        String directory = "D:\\PlaytikaJavaCourses\\src\\main\\resources";
        String directory1 = "D:\\авуам";
        String directory2 = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\New";

        new FileAndTextReader(directory).filesFromDirectoryData();

        LOG.info(String.valueOf(new FileAndTextReader(directory).
                agreateadGetWordsFrequenciesForDirectoriesFiles()));
        LOG.info(String.valueOf(new FileAndTextReader(directory2).
                agreateadGetWordsFrequenciesForDirectoriesFiles()));

        new FilesCopyClass(fileSecond, fileCopySecond).fileCopyFromSourseToDestination();

        LOG.info(String.valueOf(new FileAndTextReader(directory1).
                agreateadGetWordsFrequenciesForDirectoriesFiles()));
    }


}
