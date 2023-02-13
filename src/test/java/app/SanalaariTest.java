package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SanalaariTest {

    @Test
    public void initializationIsCorrect() {
        String[] wordList = {
            "<s>sana</s>",
            "<s>sana2</s>",
            "<st><s>sana3</s></st>",
            "<st><s>this should not be included</st></s>"
        };

        Sanalaari sl = new Sanalaari(Arrays.asList(wordList));
        assertEquals(wordList.length - 1, sl.size());
    }

    @Test
    public void sanalaariFindsWords() {
        String[] wordList = {
            "<s>olat</s>",
            "<s>talo</s>",
            "<s>olut</s>",
            "<s>stoola</s>",
            "<s>staili</s>",
            "<s>olo</s>"
        };

        Sanalaari sl = new Sanalaari(Arrays.asList(wordList));

        List<WordData> result = sl.get("latoso", 4);
        assertEquals(2, result.size());
        assertTrue(result.contains(new WordData("olat")));
        assertTrue(result.contains(new WordData("talo")));

        result = sl.get("latoso", 6);
        assertEquals(1, result.size());
    }
    
}
