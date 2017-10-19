package com.playtika.homeWork;

import java.io.*;

public class FilesCopyClass {
    private String fileSourseName;
    private String fileDestinationName;

    public FilesCopyClass(String fileSourseName, String fileDestinationName) throws FileNotFoundException {

        if (fileSourseName == null) {
            throw new NullPointerException("File sourse name can't be NULL");
        } else if (fileSourseName.isEmpty()) {
            throw new FileNotFoundException("fileSourseName can't be empty");
        } else if (fileDestinationName == null) {
            throw new NullPointerException("File destination name can't be NULL");
        } else if (fileDestinationName.isEmpty()) {
            throw new FileNotFoundException("fileDestinationName can't be empty");
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
