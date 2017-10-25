package com.playtika.automation.tasks.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FilesCopyClass {
    private String fileSourseName;
    private String fileDestinationName;
    private static final Logger LOG
            = LoggerFactory.getLogger(FilesCopyClass.class);

    public FilesCopyClass(String fileSourseName, String fileDestinationName) throws FileNotFoundException {
        if (fileSourseName == null) {
            LOG.error("File sourse name can't be NULL", new NullPointerException());
        } else if (fileSourseName.isEmpty()) {
            LOG.error("fileSourseName can't be empty", new FileNotFoundException();
        } else if (fileDestinationName == null) {
            LOG.error("File destination name can't be NULL", new NullPointerException());
        } else if (fileDestinationName.isEmpty()) {
            LOG.error("fileDestinationName can't be empty", new FileNotFoundException());
        }

        this.fileSourseName = fileSourseName;
        this.fileDestinationName = fileDestinationName;
    }

    public void fileCopyFromSourseToDestination() throws IOException {
        File fileSourse = new File(fileSourseName);
        File fileDestination = new File(fileDestinationName);
        if (fileDestination.exists()) {
            fileDestination.delete();
        }
        try (FileInputStream fileIn = new FileInputStream(fileSourse);
             FileOutputStream fileOut = new FileOutputStream(fileDestination)) {
            byte[] buffer = new byte[1024];
            int bufferLength = fileIn.read(buffer);
            while (bufferLength > 0) {
                fileOut.write(buffer, 0, bufferLength);
                bufferLength = fileIn.read(buffer);
            }
        }
    }

}
