import logger.TopicLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import topic.Topic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TopicLoggerStdErrTest {
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpSteams(){
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void log(){
        Topic topic = new Topic("Test");
        TopicLogger topicLogger = new TopicLogger(false, true);

        topicLogger.log(topic, "this is a test");

        Assert.assertEquals("Test: this is a test\n", errContent.toString());
    }

    @Test
    public void logWithCustomFormat(){
        Topic topic = new Topic("Test");
        TopicLogger topicLogger = new TopicLogger("[%s] %s",false, true);

        topicLogger.log(topic, "this is a test");

        Assert.assertEquals("[Test] this is a test\n", errContent.toString());
    }

    @Test
    public void doNotLogForIgnoredTopic(){
        Topic topic = new Topic("Test");
        topic.setIgnore(true);
        TopicLogger topicLogger = new TopicLogger(false, true);

        topicLogger.log(topic, "this is a test");

        Assert.assertEquals("", errContent.toString());
    }
}
