package utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Provides the Time (date + time). This class only supports UTC.
 */
public class TimeProvider {

    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";

    /**
     * Returns a string that represents the current time in UTC.
     */
    public String currentTime(){
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        return dateTime.toString(DEFAULT_TIME_FORMAT);
    }

    public String currentDay() {
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        return dateTime.toString(DEFAULT_DAY_FORMAT);
    }
}
