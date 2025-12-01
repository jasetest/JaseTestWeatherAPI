import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ZippopotamusLocationService implements LocationService {
    private final HttpClient httpClient;

    //constructor
    public ZippopotamusLocationService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    //pretty much the main method for the zippopotam api url
    @Override
    public Location getLocation(String zipCode) throws ValidateWeather.LocationLookupException {
        try {
            String url = "http://api.zippopotam.us/us/" + zipCode;

            //build and send request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            //check resonse status
            if (response.statusCode() != 200) {
                throw new ValidateWeather.LocationLookupException("Bad response: " + response.statusCode());
            }

            //parse JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            //extract location data
            JsonNode place = root.path("places").get(0);
            String city = place.path("place name").asText();
            String state = place.path("state abbreviation").asText();
            String country = root.path("country abbreviation").asText();
            double latitude = Double.parseDouble(place.path("latitude").asText());
            double longitude = Double.parseDouble(place.path("longitude").asText());

            return new Location(zipCode, city, state, country, latitude, longitude);

            //error handling
        } catch (IOException | InterruptedException | ValidateWeather.LocationLookupException e) {
            throw new ValidateWeather.LocationLookupException("Error calling Zippopotam.us", e);
        }
    }
}
