package utils;

import exceptions.LogFileWritingFailed;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class LogFileWriter {
    public static void write(String topic, String message, File logDirectory) throws LogFileWritingFailed {

        if (logDirectory.exists() && !logDirectory.isDirectory()){
            throw new LogFileWritingFailed(logDirectory.getAbsolutePath() + "is not a directory");
        }

        String currentDay = new TimeProvider().currentDay();
        File dayDirectory = new File(logDirectory, currentDay);

        File logFile = new File(dayDirectory, topic + ".log");

        createDirectoryIfNotExists(dayDirectory);
        createFileIfNotExists(logFile);

        writeMessageToLogFile(message + "\n", logFile);
    }

    private static void writeMessageToLogFile(String message, File logFile) {
        try {
            writeStringToFile(logFile, message, Charset.defaultCharset(), true);
        } catch (IOException e) {
            throw new LogFileWritingFailed("Failed to write to logFile " + logFile.getAbsolutePath());
        }
    }

    private static void createDirectoryIfNotExists(File logDirectory){
        if (! logDirectory.exists()){
            try {
                Files.createDirectories(Path.of(logDirectory.getPath()));
            } catch (IOException e) {
                throw new LogFileWritingFailed("failed to create logDirectory", e);
            }
        }
    }

    private static void createFileIfNotExists(File logFile) {
        if (! logFile.exists()){
            try {
                Files.createFile(Path.of(logFile.getPath()));
            } catch (IOException e) {
                throw new LogFileWritingFailed("failed to create logFile", e);
            }
        }
    }
}
