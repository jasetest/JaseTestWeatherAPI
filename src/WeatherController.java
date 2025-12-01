import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.http.HttpClient;

public class WeatherController {

    @FXML private TextField zipInput;
    @FXML private Label locationLabel;
    @FXML private Label tempLabel;
    @FXML private Label windLabel;
    @FXML private Label conditionLabel;

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final LocationService locationService = new ZippopotamusLocationService(httpClient);
    private final WeatherService weatherService = new OpenMeteoWeatherService(httpClient);

    @FXML
    private void onFetchWeather() {
        String zip = zipInput.getText().trim();
        if (zip.isEmpty()) {
            locationLabel.setText("Please enter a ZIP code.");
            return;
        }

        try {
            Location location = locationService.getLocation(zip);
            WeatherData weather = weatherService.getCurrentWeather(location);

            locationLabel.setText(location.toString());
            tempLabel.setText(String.format("🌡️ Temperature: %.1f °F", weather.getTemperature()));
            windLabel.setText(String.format("💨 Wind Speed: %.1f mph", weather.getWindSpeed()));

            // Simple condition logic
            String condition;
            if (weather.getPrecipitationProbability() > 50) {
                condition = "🌧️ Rain likely";
            } else if (weather.getTemperature() < 32) {
                condition = "❄️ Cold & Clear";
            } else {
                condition = "☀️ Clear skies";
            }
            conditionLabel.setText("Condition: " + condition);

        } catch (Exception e) {
            locationLabel.setText("Error: " + e.getMessage());
        }
    }
}
