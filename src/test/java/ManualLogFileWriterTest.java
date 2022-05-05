import org.junit.Test;
import utils.LogFileWriter;

import java.io.File;

public class ManualLogFileWriterTest {
    @Test
    public void writesToLogFile(){
        File logDirectory = new File("./test-result/logDirectory/");
        System.out.println("logDirectory is " + logDirectory.getAbsolutePath());

        LogFileWriter.write("test", "this is a test message", logDirectory);
        LogFileWriter.write("test", "this is a second test message", logDirectory);
    }
}
