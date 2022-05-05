import org.junit.Assert;
import org.junit.Test;
import topic.Topic;
import topic.TopicLibrary;

public class TopicLibraryTest {

    @Test
    public void storedTopicsIsFound(){
        Topic topic = new Topic("Test");

        TopicLibrary.add(topic);
        Topic foundTopic = TopicLibrary.retrieve("Test");

        Assert.assertEquals("Test", foundTopic.getName());
    }

}
