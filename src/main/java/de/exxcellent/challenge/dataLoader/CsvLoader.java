package de.exxcellent.challenge.dataLoader;
import de.exxcellent.challenge.config.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvLoader {
    private static Configuration config;
    private  ArrayList<String[]> weatherFile;
    private  ArrayList<String[]> footballFile;
    private static CsvLoader instance;
    private CsvLoader(){

    }

    public ArrayList<String[]> getWeatherFile() {
        return weatherFile;
    }

    public ArrayList<String[]> getFootballFile() {
        return footballFile;
    }

    public static void init()  throws IOException {
        config = Configuration.getInstance();
        if(instance==null)
        instance = new CsvLoader();
            }
     public  static CsvLoader getInstance(){
        return instance;
     }
    public  void readWeatherFile(){
        this.weatherFile = new ArrayList<>();
        String csvFile = config.getappConfigProp("weatherPath");
        System.out.println(csvFile);
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);
                weatherFile.add(row);
//                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void readfootballFile(){
        String csvFile = config.getappConfigProp("footballPath");
        this.footballFile = new ArrayList<>();
//        System.out.println(csvFile);
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);
               footballFile.add(row);
//                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
