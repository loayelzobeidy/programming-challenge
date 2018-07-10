package de.exxcellent.challenge.analyzers.impl;

import de.exxcellent.challenge.analyzers.Analyzer;
import de.exxcellent.challenge.config.Configuration;
import de.exxcellent.challenge.dataLoader.impl.CsvLoader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App implements Analyzer {
    private static Configuration config;
    private static CsvLoader csvLoader;

    public  App(Configuration config,CsvLoader csvLoader) throws IOException {
        this.config =config;
        this.csvLoader = csvLoader;
        this.csvLoader.readfootballFile();
        this.csvLoader.readWeatherFile();

    }
    public String dayAnalysis(){


        ArrayList<String[]> dayList = this.csvLoader.getWeatherFile();
        if(dayList==null)
            return "the list was not initialized correctly";
        if(dayList.size()==1)
            return "the list is empty";
        int smallest  =(int) Math.abs(Integer.parseInt(dayList.get(1)[1])-Integer.parseInt(dayList.get(1)[2]));
        int index = 1;
        for(int i = 2 ;i<dayList.size();i++) {
            int temp = (int) Math.abs(Integer.parseInt(dayList.get(i)[1]) - Integer.parseInt(dayList.get(i)[2]));
            if (smallest > temp) {
                smallest = temp;
                index = i;
            }

        }
        return (index+1)+"";

    }
    public String footballAnalysis(){
        //5 6
        ArrayList<String[]> footList = this.csvLoader.getFootballFile();
        if(footList==null)
            return "the list was not initialized correctly";
            if(footList.size()==1)
            return "the list is empty";
        int smallest  =(int) Math.abs(Integer.parseInt(footList.get(1)[5])-Integer.parseInt(footList.get(1)[6]));
        int index = 1;
        for(int i = 2 ;i<footList.size();i++) {
            int temp = (int) Math.abs(Integer.parseInt(footList.get(i)[5]) - Integer.parseInt(footList.get(i)[6]));
            if (smallest > temp) {
                smallest = temp;
                index = i;
            }

        }
        return index+1+"";
    }

    public static void main(String... args) {

        // Your preparation code …

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
