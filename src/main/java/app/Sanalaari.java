package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sanalaari {
    
    private Parser parser;
    private ArrayList<WordData> wordData;
    private HashMap<String, WordData> wordMap;

    public Sanalaari(List<String> rawData) {
        parser = new Parser();
        init(rawData);
    }

    private void init(List<String> rawData) {
        wordData = parser.parse(rawData);
        wordMap = new HashMap<>();
        for (WordData w : wordData) {
            wordMap.put(w.plain(), w);
        }
    }

    public int size() {
        return this.wordData.size();
    }

    public List<WordData> get(String letters, int length) {
        ArrayList<WordData> result = new ArrayList<>();
        ArrayList<String> partial = new ArrayList<>();

        for (WordData w : wordData) {
            if (w.plain().length() == length)
                partial.add(w.plain());
        }

        char[] letterSet = letters.toCharArray();
        for (String word : partial) {
            int match = 0;
            boolean[] used = new boolean[letters.length()];
            
            for (char charInWord : word.toCharArray()) {
                boolean valid = false;
                for (int i = 0; i < letters.length(); i++) {
                    if (used[i])
                        continue;
                    if (letterSet[i] == charInWord) {
                        used[i] = true;
                        valid = true;
                        break;
                    }
                }
                if (!valid)
                break;
                match++;            
            }
            System.out.println();
            if (match == length)
                result.add(wordMap.get(word));
        }
        return result;
    }


}
