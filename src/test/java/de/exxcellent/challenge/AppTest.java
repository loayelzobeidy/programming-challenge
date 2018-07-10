package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzers.impl.App;
import de.exxcellent.challenge.config.Configuration;
import de.exxcellent.challenge.dataLoader.impl.CsvLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {
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

    }
    @Test
    public void DayTest() throws IOException {
        App temp =new App(config,csvLoader);
        Assert.assertEquals("The day corresponding to the smallest difference should be 15", "15", temp.dayAnalysis());
    }
    @Test
    public void FootballTest() throws IOException {
        App temp =new App(config,csvLoader);
        Assert.assertEquals("The football team corresponding to the smallest difference should be 9", "9", temp.footballAnalysis());
    }

}