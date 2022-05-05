package exceptions;

public class LogFileWritingFailed extends RuntimeException {
    public LogFileWritingFailed(String message) {
        super(message);
    }

    public LogFileWritingFailed(String message, Throwable cause) {
        super(message, cause);
    }
}
