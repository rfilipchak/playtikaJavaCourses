package com.playtika.automation.tasks.files;

import java.io.IOException;

public class Files {
    public static void main(String[] args) throws IOException {
        String fileFirst = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\text1.txt";
        String fileSecond = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\text2.txt";
        String fileCopySecond = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\fileCopySecond.txt";
        String directory = "D:\\PlaytikaJavaCourses\\src\\main\\resources";
        String directory1 = "D:\\авуам";
        String directory2 = "D:\\PlaytikaJavaCourses\\src\\main\\resources\\New";

        new FileAndTextReader(directory).filesFromDirectoryData();
        System.out.println(new FileAndTextReader(directory).agreateadGetWordsFrequenciesForDirectoriesFiles());
        System.out.println(new FileAndTextReader(directory2).agreateadGetWordsFrequenciesForDirectoriesFiles());
        new FilesCopyClass(fileSecond, fileCopySecond).fileCopyFromSourseToDestination();
        System.out.println(new FileAndTextReader(directory1).agreateadGetWordsFrequenciesForDirectoriesFiles());
    }


}
