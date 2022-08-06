import Words.WordHistogramFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainFileReader {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("src/Words/The_Call_of_Cthulhu"));

        String STRING_TO_ANALYSE;

        WordHistogramFileReader wordHistogram = new WordHistogramFileReader();

        while ((STRING_TO_ANALYSE = reader.readLine()) != null) {
            wordHistogram.analyseString(STRING_TO_ANALYSE);
        }


        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        wordHistogram.printMostUsed(30);

    }
}