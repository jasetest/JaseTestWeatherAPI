# WeatherAppJava

A simple Java/JavaFX application that fetches weather data for U.S. ZIP codes using the [Zippopotam.us](http://api.zippopotam.us) API for location lookup and the [Open-Meteo](https://open-meteo.com/en/docs) API for weather information.

---

## ✨ Features

- 🔍 **ZIP Code Lookup**  
  Enter any U.S. ZIP code to automatically resolve the city, state, country, and geographic coordinates.

- 🌡️ **Current Weather Report**  
  Displays temperature (°F), wind speed (mph), wind direction (°), and precipitation probability (%).

- 🎨 **JavaFX UI**  
  A simple SceneBuilder-designed interface with:
    - Text field for ZIP code input
    - "Fetch Weather" button
    - Labels showing location and weather details
    - Creative emoji icons for temperature, wind, and conditions (☀️, ❄️, 🌧️)

- 🖥️ **Console Driver**  
  A command-line version (`WeatherConsoleDriver`) is also included for quick testing without the UI.

---

## 🚀 How to Run

### Prerequisites
- Java 17+ (tested with OpenJDK 24)
- JavaFX SDK (download from [https://openjfx.io](https://openjfx.io))
- Jackson libraries (`jackson-core`, `jackson-databind`, `jackson-annotations`)

### Steps
1. **Clone, Compile, and Run the Application**
    - Clone the repository:
      ```bash
      git clone https://github.com/yourusername/WeatherAppJava.git
      cd WeatherAppJava
      ```
    - Compile the project (ensure JavaFX SDK is on your module path):
      ```bash
      javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml \
            -cp "lib/*" src/*.java -d out
      ```
    - Run the **Console Driver**:
      ```bash
      java -cp "out:lib/*" WeatherConsoleDriver
      ```
      Enter a ZIP code when prompted.
    - Or run the **JavaFX App**:
      ```bash
      java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml \
           -cp "out:lib/*" WeatherApp
      ```

---

## 📸 Example Output

**Console Driver:** \
Enter a U.S. zip code: 68701 \
Norfolk, NE 68701 US (42.0329, -97.4229) \
Weather Report for Norfolk, NE 68701 US (42.0329, -97.4229) \
Observed at: 2025-11-30T17:00 \
Temperature: 32.0 °F \
Wind Speed: 10.5 mph \
Wind Direction: 180.0° \
Precipitation Probability: 20.0%
