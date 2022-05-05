import org.junit.Test;
import utils.TimeProvider;

public class ManualTimeProviderTest {
    @Test
    public void currentTime(){
        TimeProvider timeProvider = new TimeProvider();

        String currentTime = timeProvider.currentTime();

        System.out.println(currentTime);
    }
}
