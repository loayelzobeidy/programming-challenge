package de.exxcellent.challenge.dataLoader;

import java.util.ArrayList;

public interface DataLoader {
    public  void readWeatherFile();
    public void readfootballFile();
    public ArrayList<String[]> getWeatherFile();
    public ArrayList<String[]> getFootballFile();
}
