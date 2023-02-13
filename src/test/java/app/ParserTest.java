package app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ParserTest 
{
    Parser p;

    @Before
    public void init() {
        p = new Parser();
    }

    @Test
    public void parsePlainWord()
    {
        String testWord = "sana";
        String testWord2 = "tana";

        String[] wordList = {
            "<st><s>" + testWord + "</s></st>",
            "<st><s>" + testWord2 + "</s><t taivutus = 'juupajuu'></t></st>"
        };
        ArrayList<WordData> d = p.parse(Arrays.asList(wordList));

        assertEquals(2, d.size());
        String result = d.get(0).plain();
        String result2 = d.get(1).plain();
        assertEquals(testWord, result);
        assertEquals(testWord2, result2);
    }

    @Test
    public void nonParseableLineIsIgnored() {
        String[] testLines = {
            "<st><s<t>>sana</t></s></st>",
            "<st>><s>sana</s></st>",
            "<st><s>sana</t><st>",
            "<st><s>sana</st></s>"
        };
        ArrayList<WordData> d = p.parse(Arrays.asList(testLines));
        assertEquals(0, d.size());

    }
}
