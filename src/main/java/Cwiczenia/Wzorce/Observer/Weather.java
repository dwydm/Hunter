package Cwiczenia.Wzorce.Observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Observable{
    private String city;
    private int celsius;
    private WeatherCondition weatherCondition;
    private List<Observer> observersList = new ArrayList<>();

    public Weather(String city, int celsius, WeatherCondition weatherCondition) {
        this.city = city;
        this.celsius = celsius;
        this.weatherCondition = weatherCondition;
    }

    public String getCity() {
        return city;
    }

    public int getCelsius() {
        return celsius;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    @Override
    public void addObserver(Observer observer) {
        observersList.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observersList.add(observer);

    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observersList) {
            observer.update(this);
        }
    }

    public void update(WeatherCondition weatherCondition, int celsius) {
        this.weatherCondition = weatherCondition;
        this.celsius = celsius;
        notifyAllObservers();
    }


    @Override
    public String toString() {
        return city + " " + celsius + "'C and " + weatherCondition;
    }
}
