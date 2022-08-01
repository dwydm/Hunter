package Cwiczenia.Wzorce.Observer;

public class WeatherDemo {
    public static void main(String[] args) {
        Weather weather = new Weather("Wrocław", 23, WeatherCondition.WINDY);
        Webapp app1 = new Webapp();
        Smartphone app2 = new Smartphone();
        weather.addObserver(app1);
        weather.addObserver(app2);
        weather.update(WeatherCondition.WINDY,20);
        weather.update(WeatherCondition.SUNNY,25);
    }
}
