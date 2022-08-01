package Cwiczenia.Wzorce.Observer;

public enum WeatherCondition {
    RAINY("rainy"),
    SUNNY("sunny"),
    WINDY("windy");

    private final String condition;
    WeatherCondition(String condition) {
        this.condition = condition;
    }
}
