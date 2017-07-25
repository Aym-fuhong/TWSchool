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
        String[] wordList = {"the", "day", "is", "sunny", "the", "is", "is", "sunny", "the", "the"};
        Map<String, Integer> result = new HashMap();
        result.put("the", 4);
        result.put("day", 1);
        result.put("sunny", 2);
        result.put("is", 3);
        Deal deal = new Deal();
        //when
        Map<String, Integer> wordMap = deal.getCountOfWords(wordList);
        //then
        assertThat(wordMap, is(result));
    }

    @Test
    public void should_return_sortedWordMap_when_input_wordMap() {
        //Given
        Map<String, Integer> wordMap = new HashMap();
        wordMap.put("the", 4);
        wordMap.put("day", 1);
        wordMap.put("sunny", 2);
        wordMap.put("is", 3);
        Map<String, Integer> result = new HashMap();
        result.put("the", 4);
        result.put("is", 3);
        result.put("sunny", 2);
        result.put("day", 1);
        Deal deal = new Deal();
        //when
        Map<String, Integer> sortedWordMap = deal.sortWordMap(wordMap);
        //then
        assertThat(sortedWordMap, is(result));
    }

    @Test
    public void should_return_wordString_when_input_sortedWordMap() {
        //Given
        Map<String, Integer> sortedWordMap = new HashMap();
        sortedWordMap.put("the", 4);
        sortedWordMap.put("is", 3);
        sortedWordMap.put("sunny", 2);
        sortedWordMap.put("day", 1);
        Deal deal = new Deal();
        String result = "the 4\nis 3\nsunny 2\nday 1\n";
        //when
        String wordString = deal.getWordString(sortedWordMap);
        //then
        assertThat(wordString, is(result));
    }
}
