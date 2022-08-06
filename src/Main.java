import Words.WordHistogram;

public class Main {
    public static void main(String[] args) {

        final String STRING_TO_ANALYSE = "You can always trust the untrustworthy because you can always trust that they will be untrustworthy. It's the trustworthy you cannot trust.";

        WordHistogram wordHistogram = new WordHistogram();
        wordHistogram.analyseString(STRING_TO_ANALYSE);

        for (String word : wordHistogram) {
            System.out.print(word);
            System.out.println(wordHistogram.startWordAt(word, wordHistogram.getMaxWordSize()) + wordHistogram.wordCounterGraph(wordHistogram.get(word)));
        }
    }
}