package Words;

import java.util.Iterator;
import java.util.TreeMap;

public class WordHistogram implements Iterable<String> {
    TreeMap<String, Integer> wordMap = new TreeMap<>();
    private int maxWordSize;

    public int getMaxWordSize() {
        return maxWordSize;
    }

    public void analyseString(String string_to_analyse) {
        String[] temp = string_to_analyse.toLowerCase().replaceAll("[.:,;!?]", "").split(" ");
        for (String word : temp) {
            if (word.length() > maxWordSize) {
                maxWordSize = word.length();
            }
            Object obj = wordMap.putIfAbsent(word, 1);
            if (obj != null) {
                int wordCounter = wordMap.get(word);
                wordCounter++;
                wordMap.put(word, wordCounter);
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return wordMap.keySet().iterator();
    }

    public int get(String word) {
        return wordMap.get(word);
    }

    public String startWordAt(String word, int maxWordSize) {
        String start = "";
        System.out.print(" ");
        for (int i = 0; i < maxWordSize - word.length(); i++) {
            System.out.print("-");
        }
        System.out.print(" : ");
        return start;
    }

    public String wordCounterGraph(int wordCounter) {
        String graph = "";
        for (int i = 0; i < wordCounter; i++) {
            System.out.print("[/]");
        }
        return graph;
    }
}
