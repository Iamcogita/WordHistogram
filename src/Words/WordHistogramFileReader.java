package Words;

import java.util.*;

public class WordHistogramFileReader implements Iterable<String> {
    TreeMap<String, Integer> wordMap = new TreeMap<>();

    public void analyseString(String string_to_analyse) {

        String[] temp = string_to_analyse.toLowerCase().replaceAll("[.:,;!?“\"]", "")
                .replaceAll("\r", "").split(" ");

        for (String word : temp) {
            Object wordCheck = wordMap.putIfAbsent(word, 1);
            if (wordCheck != null) {
                int wordCounter = wordMap.get(word);
                wordCounter++;
                wordMap.put(word, wordCounter);
            }
        }
    }

    @Override
    public Iterator iterator() {
        return wordMap.keySet().iterator();
    }

    private Map<Integer, Set<String>> getTopWords() {
        Map<Integer, Set<String>> listTopTen = new TreeMap<>(Comparator.reverseOrder());
        for (String word : this) {
            Integer wordFrequency = wordMap.get(word);
            boolean exists = listTopTen.containsKey(wordFrequency);
            if (!exists) {
                listTopTen.put(wordFrequency, new HashSet<>());
            }
            listTopTen.get(wordFrequency).add(word);
        }
        return listTopTen;
    }

    public void printMostUsed(int mostUsed) {
        Map<Integer, Set<String>> top = getTopWords();
        Set<Integer> orderedFrequencyKeys = top.keySet();
        Iterator<Integer> frequencyIterator = orderedFrequencyKeys.iterator();
        int displayCounter = 0;

        while (frequencyIterator.hasNext()) {
            Integer frequency = frequencyIterator.next(); //800
            Set<String> words = top.get(frequency); //the
            Iterator wordIt = words.iterator();
            System.out.print(frequency + ":");
            while (wordIt.hasNext()) {
                displayCounter++;
                System.out.print(" " + wordIt.next() + "; ");
                if (displayCounter >= mostUsed) {
                    return;
                }
            }
            System.out.println("");
        }
    }

}