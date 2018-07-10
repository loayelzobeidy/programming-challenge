package de.exxcellent.challenge;

import de.exxcellent.challenge.config.Configuration;
import de.exxcellent.challenge.dataLoader.CsvLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CsvTest {


    private String successLabel = "not successful";
    static Configuration config;
    static CsvLoader csvLoader;

    @Before
    public void setUp() throws Exception {
        successLabel = "";
        String rootFolder = "src/main/resources/de/exxcellent/config/";
        Configuration.init(rootFolder + "csv.config"
        );
        CsvLoader.init();
        config = Configuration.getInstance();
//        System.out.println(CsvLoader.getInstance());
        csvLoader = CsvLoader.getInstance();
        System.out.println(csvLoader);
    }

    @Test
    public void DayTest() throws IOException {
        Assert.assertEquals("Expectations met", "30",csvLoader.getFootballFile().size());
    }
    @Test
    public void FootballTest() throws IOException {
        Assert.assertEquals("Expectations met", "30",csvLoader.getWeatherFile().size());

    }

}

