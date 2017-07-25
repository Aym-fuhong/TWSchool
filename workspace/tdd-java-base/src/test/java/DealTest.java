import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DealTest {

    @Test
    public void should_return_string_list_when_input_string_include_one_space() throws Exception {
        //Given
        String words = "the day is sunny";
        String[] result = {"the", "day", "is", "sunny"};
        Deal deal = new Deal();
        //when
        String[] wordList = deal.formatWords(words);
        //then
        assertThat(wordList, is(result));
    }

    @Test
    public void should_return_string_list_when_input_string_include_more_space() throws Exception {
        //Given
        String words = "the day is   sunny";
        String[] result = {"the", "day", "is", "sunny"};
        Deal deal = new Deal();
        //when
        String[] wordList = deal.formatWords(words);
        //then
        assertThat(wordList, is(result));
    }

    @Test
    public void should_return_count_when_input_string_list() {
        //Given
        String[] wordList = {"the", "day", "is", "sunny","the", "day", "is", "sunny","the"};
        Map<String, Integer> result = new HashMap();
        result.put("the", 3);
        result.put("day", 2);
        result.put("sunny", 2);
        result.put("is", 2);

        Deal deal = new Deal();
        //when
        Map<String, Integer> wordCount = deal.getCountOfWords(wordList);
        //then
        assertThat(wordCount, is(result));
    }
}
