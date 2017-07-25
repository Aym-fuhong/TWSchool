import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DealTest {

    @Test
    public void should_return_string_list_when_input_string_include_one_space() throws Exception {
        String words = "the day is sunny";
        String[] result = {"the", "day", "is", "sunny"};
        Deal deal = new Deal();
        assertThat(deal.formatWords(words), is(result));
    }

    @Test
    public void should_return_string_list_when_input_string_include_more_space() throws Exception {
        String words = "the day is   sunny";
        String[] result = {"the", "day", "is", "sunny"};
        Deal deal = new Deal();
        assertThat(deal.formatWords(words), is(result));
    }
}
