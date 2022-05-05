import logger.TopicLogger;
import org.junit.Test;
import topic.Topic;

public class ManualTopicLoggerTest {

    @Test
    public void logWithTime(){
        Topic topic = new Topic("Test");
        TopicLogger topicLogger = new TopicLogger(", %s, %s",true, false, false, true, null);

        topicLogger.log(topic, "this is a test");
    }

}
