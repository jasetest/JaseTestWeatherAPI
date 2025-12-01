import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.http.HttpClient;

public class WeatherController {

    //fxml field
    @FXML private TextField zipInput;
    @FXML private Label locationLabel;
    @FXML private Label tempLabel;
    @FXML private Label windLabel;
    @FXML private Label conditionLabel;

    //setup the services like normal
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final LocationService locationService = new ZippopotamusLocationService(httpClient);
    private final WeatherService weatherService = new OpenMeteoWeatherService(httpClient);

    //handles the button
    @FXML
    private void onFetchWeather() {
        String zip = zipInput.getText().trim();
        if (zip.isEmpty()) {
            locationLabel.setText("Please enter a ZIP code.");
            return;
        }

        try {
            //method to fetch the weather and update the entire gui
            Location location = locationService.getLocation(zip);
            WeatherData weather = weatherService.getCurrentWeather(location);

            locationLabel.setText(location.toString());
            tempLabel.setText(String.format("🌡️ Temperature: %.1f °F", weather.getTemperature()));
            windLabel.setText(String.format("💨 Wind Speed: %.1f mph", weather.getWindSpeed()));

            String condition;
            if (weather.getPrecipitationProbability() > 50) {
                condition = "🌧️ Rain likely";
            } else if (weather.getTemperature() < 32) {
                condition = "❄️ Cold & Clear";
            } else {
                condition = "☀️ Clear skies";
            }
            conditionLabel.setText("Condition: " + condition);

            //error handling
        } catch (Exception e) {
            locationLabel.setText("Error: " + e.getMessage());
        }
    }
}
