package app;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        String baseURL = "sanalista/";
        String wordListFile = "kotus-sanalista_v1.xml";
        List<String> rawData = FileReader.asList(baseURL + wordListFile);

        Sanalaari sl = new Sanalaari(rawData);
    }
}
