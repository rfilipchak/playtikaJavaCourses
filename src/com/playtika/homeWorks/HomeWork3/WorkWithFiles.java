package com.playtika.homeWorks.HomeWork3;

import java.io.IOException;

public class WorkWithFiles {
    public static void main(String[] args) throws IOException {
        String fileFirst = "D:\\PlaytikaJavaCourses\\FilesForTests\\text1.txt";
        String fileSecond = "D:\\PlaytikaJavaCourses\\FilesForTests\\text2.txt";
        String fileCopySecond = "D:\\PlaytikaJavaCourses\\FilesForTests\\fileCopySecond.txt";
        String directory = "D:\\PlaytikaJavaCourses\\FilesForTests";

        new FileAndTextReader(directory).filesFromDirectoryData();
        System.out.println(new FileAndTextReader(directory).agreateadGetWordsFrequenciesForDirectoriesFiles());
        new FilesCopyClass(fileSecond, fileCopySecond).fileCopyFromSourseToDestination();

    }


}
