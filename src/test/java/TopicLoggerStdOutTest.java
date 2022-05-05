import logger.TopicLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import topic.Topic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test to check if {@link TopicLogger} logs correctly to the standard output.
 */
public class TopicLoggerStdOutTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpSteams(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void log(){
        Topic topic = new Topic("Test");
        TopicLogger topicLogger = new TopicLogger(true, false);

        topicLogger.log(topic, "this is a test");

        Assert.assertEquals("Test: this is a test\n", outContent.toString());
    }

    @Test
    public void logWithCustomFormat(){
        Topic topic = new Topic("Test");
        TopicLogger topicLogger = new TopicLogger("[%s] %s",true, false);

        topicLogger.log(topic, "this is a test");

        Assert.assertEquals("[Test] this is a test\n", outContent.toString());
    }

    @Test
    public void doNotLogForIgnoredTopic(){
        Topic topic = new Topic("Test");
        topic.setIgnore(true);
        TopicLogger topicLogger = new TopicLogger(true, false);

        topicLogger.log(topic, "this is a test");

        Assert.assertEquals("", outContent.toString());
    }
}
