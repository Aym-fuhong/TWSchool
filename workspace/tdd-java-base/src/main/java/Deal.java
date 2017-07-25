import java.util.*;


public class Deal {


    public String[] formatWords(String words) {
        String[] wordList = words.split(" +");
        return wordList;
    }


    public Map<String, Integer> getCountOfWords(String[] wordList) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : wordList) {
            if (wordCount.get(word) != null) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    public Map<String, Integer> sortWordMap(Map<String, Integer> wordMap) {
        return MapUtil.sortByValue(wordMap);
    }

    public String getWordString(Map<String, Integer> sortedWordMap) {
        String wordString = "";
        Iterator it = sortedWordMap.keySet().iterator();
        while(it.hasNext()) {
            String key = (String)it.next();
            wordString += key;
            wordString += " ";
            wordString += sortedWordMap.get(key);
            wordString += "\n";
        }
        return wordString;
    }
}
