package logger;

import topic.Topic;
import utils.LogFileWriter;
import utils.TimeProvider;

import java.io.File;

/**
 * Class that logs information about a {@link Topic}
 */
public class TopicLogger {

    public static final String DEFAULT_FORMAT = "%s: %s";
    private String format;

    private File logDirectory;

    private boolean logToStdOut;
    private boolean logToStdErr;
    private boolean logToFile;

    private boolean includeTime;

    /**
     * Creates logger.TopicLogger with the default format.
     */
    public TopicLogger(boolean logToStdOut, boolean logToStdErr) {
        this.logToStdOut = logToStdOut;
        this.logToStdErr = logToStdErr;
        this.format = DEFAULT_FORMAT;
    }

    /**
     * Creates logger.TopicLogger with a custom format.
     */
    public TopicLogger(String format, boolean logToStdOut, boolean logToStdErr) {
        this.format = format;
        this.logToStdOut = logToStdOut;
        this.logToStdErr = logToStdErr;
    }

    public TopicLogger(String format, boolean logToStdOut, boolean logToStdErr, boolean logToFile, boolean includeTime, File logDirectory) {
        this.format = format;
        this.logToStdOut = logToStdOut;
        this.logToStdErr = logToStdErr;
        this.logToFile = logToFile;
        this.includeTime = includeTime;
        this.logDirectory = logDirectory;
    }

    /**
     * Method to log an information string about a {@link Topic}.
     * If the topic is ignored then this method will do nothing.
     */
    public void log(Topic topic, String info){
        if (topic.isIgnored()){
            return;
        }

        String message = determineTextToLog(topic, info);

        if (logToStdOut) {
            System.out.println(message);
        }
        if (logToStdErr){
            System.err.println(message);
        }
        if (logToFile && logDirectory != null){
            LogFileWriter.write(topic.getName(), message, logDirectory);
        }
    }

    private String determineTextToLog(Topic topic, String info) {
        String message = "";
        if (includeTime){
            TimeProvider timeProvider = new TimeProvider();
            message += timeProvider.currentTime();
        }

        message += String.format(format, topic.getName(), info);
        return message;
    }

}
