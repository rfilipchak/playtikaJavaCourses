package com.playtika.homeWorks.HomeWork3;

import java.io.IOException;

public class WorkWithFiles {
    public static void main(String[] args) throws IOException {
        String fileFirst = "D:\\PlaytikaJavaCourses\\FilesForTests\\text1.txt";
        String fileSecond = "D:\\PlaytikaJavaCourses\\FilesForTests\\text2.txt";
        String fileCopySecond = "D:\\PlaytikaJavaCourses\\FilesForTests\\fileCopySecond.txt";
        String directory = "D:\\PlaytikaJavaCourses\\FilesForTests";
        String directory1 = "D:\\авуам";
        String directory2 = "D:\\New folder";

        new FileAndTextReader(directory).filesFromDirectoryData();
        System.out.println(new FileAndTextReader(directory).agreateadGetWordsFrequenciesForDirectoriesFiles());
        System.out.println(new FileAndTextReader(directory2).agreateadGetWordsFrequenciesForDirectoriesFiles());
        new FilesCopyClass(fileSecond, fileCopySecond).fileCopyFromSourseToDestination();
        System.out.println(new FileAndTextReader(directory1).agreateadGetWordsFrequenciesForDirectoriesFiles());

    }


}
