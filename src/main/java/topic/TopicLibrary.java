package topic;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class responsible for containing a map of reusable topics.
 */
public class TopicLibrary {
    private static final Map<String, Topic> topics = new HashMap<>();

    private TopicLibrary() {
    }

    /**
     * Adds a topic to the topic.TopicLibrary. The name of the topic is used as key.
     */
    public static void add(Topic topic){
        topics.put(topic.getName(), topic);
    }

    public static Topic retrieve(String key){
        return topics.get(key);
    }
}
