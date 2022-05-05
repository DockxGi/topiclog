package topic;

/**
 * A subject to log about.
 */
public class Topic {
    private String name;
    private boolean ignore;

    public Topic(String name) {
        this.name = name;
        this.ignore = false;
    }

    /**
     * Returns if the topic is currently ignored. There will be no logging for the topic while it is ignored.
     */
    public boolean isIgnored() {
        return ignore;
    }

    /**
     * Set if we should ignore the topic.Topic. There will be no logging for the topic while it is ignored.
     */
    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public String getName() {
        return name;
    }
}
