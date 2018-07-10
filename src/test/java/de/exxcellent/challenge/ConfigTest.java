package de.exxcellent.challenge;

import de.exxcellent.challenge.config.Configuration;
import de.exxcellent.challenge.dataLoader.impl.CsvLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConfigTest {

        static Configuration config;
        static CsvLoader csvLoader;

        @Before
        public void setUp() throws Exception {
            String rootFolder = "src/main/resources/de/exxcellent/config/";
            Configuration.init(rootFolder + "app.config"
            );
            config = Configuration.getInstance();

        }

        @Test
        public void DayTest() throws IOException {
            Assert.assertEquals("The football path should be loaded correctly", "src/main/resources/de/exxcellent/challenge/football.csv",config.getCsvConfigProp("footballPath"));
        }
        @Test
        public void FootballTest() throws IOException {
            Assert.assertEquals("the weather path should be loaded correctly", "src/main/resources/de/exxcellent/challenge/weather.csv",config.getCsvConfigProp("weatherPath"));

        }

    }

