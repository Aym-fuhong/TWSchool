import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Deal {
    private String character = "\n";

    public String loadFile(String filePath) {
        String words = "";
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    words = lineTxt;
                    System.out.println(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return words;
    }

    public String[] formatWords(String words) {
        String[] wordList = words.split("\\s+");
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
        Map<String, Integer> map = wordMap.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return map;
    }

    public String getWordString(Map<String, Integer> sortedWordMap) {
        String wordString = "";
        Iterator it = sortedWordMap.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            wordString += key;
            wordString += " ";
            wordString += sortedWordMap.get(key);
            wordString += this.character;
        }
        return wordString;
    }
}
