package de.exxcellent.challenge;

import de.exxcellent.challenge.config.Configuration;
import de.exxcellent.challenge.dataLoader.CsvLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConfigTest {


        private String successLabel = "not successful";
        static Configuration config;
        static CsvLoader csvLoader;

        @Before
        public void setUp() throws Exception {
            successLabel = "";
            String rootFolder = "src/main/resources/de/exxcellent/config/";
            Configuration.init(rootFolder + "csv.config"
            );
            config = Configuration.getInstance();

        }

        @Test
        public void aPointlessTest() {
            Assert.assertEquals("Expectations met", "", successLabel);
        }
        @Test
        public void DayTest() throws IOException {
            Assert.assertEquals("Expectations met", "src/main/resources/de/exxcellent/challenge/football.csv",config.getappConfigProp("footballPath"));
        }
        @Test
        public void FootballTest() throws IOException {
            Assert.assertEquals("Expectations met", "src/main/resources/de/exxcellent/challenge/weather.csv",config.getappConfigProp("weatherPath"));

        }

    }

