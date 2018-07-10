package de.exxcellent.challenge;

import de.exxcellent.challenge.config.Configuration;
import de.exxcellent.challenge.dataLoader.impl.CsvLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CsvTest {
    static Configuration config;
    static CsvLoader csvLoader;

    @Before
    public void setUp() throws Exception {
        String rootFolder = "src/main/resources/de/exxcellent/config/";
        Configuration.init(rootFolder + "app.config"
        );
        CsvLoader.init();
        config = Configuration.getInstance();
        csvLoader = CsvLoader.getInstance();
        csvLoader.readfootballFile();
        csvLoader.readWeatherFile();
    }

    @Test
    public void DayTest() throws IOException {
        Assert.assertEquals("The football file should be loaded correctly", 21,csvLoader.getFootballFile().size());
    }
    @Test
    public void FootballTest() throws IOException {
        Assert.assertEquals("The weather file should be loaded correctly", 31,csvLoader.getWeatherFile().size());

    }

}

