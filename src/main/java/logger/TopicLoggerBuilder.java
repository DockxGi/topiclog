package logger;

import java.io.File;

/**
 * Provides Builder Pattern for creating a {@link TopicLogger}.
 */
public class TopicLoggerBuilder {

    private String format;

    private File logDirectory;

    private boolean logToStdOut;
    private boolean logToStdErr;
    private boolean logToFile;

    private boolean includeTime;

    private TopicLogger topicLogger;

    public TopicLoggerBuilder() {
        this.format = TopicLogger.DEFAULT_FORMAT;
        this.logDirectory = null;
        this.logToStdOut = false;
        this.logToStdErr = false;
        this.logToFile = false;
        this.includeTime = false;
    }

    public TopicLoggerBuilder withTime(){
        this.includeTime = true;
        return this;
    }

    public TopicLoggerBuilder logToStdOut(){
        this.logToStdOut = true;
        return this;
    }

    public TopicLoggerBuilder logToStdErr(){
        this.logToStdErr = true;
        return this;
    }

    public TopicLoggerBuilder logToFile(File logDirectory){
        this.logToFile = true;
        this.logDirectory = logDirectory;
        return this;
    }

    /**
     * Format for the log message. Needs to contain %s two times.
     * Default format is: "%s: %s"
     */
    public TopicLoggerBuilder format(String format) {
        this.format = format;
        return this;
    }

    public TopicLogger build(){
        return new TopicLogger(format, logToStdOut, logToStdErr, logToFile, includeTime, logDirectory);
    }
}
