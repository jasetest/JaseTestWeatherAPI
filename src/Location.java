public class Location {
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;
    private final double latitude;
    private final double longitude;

    public Location(String zipCode, String city, String state, String country, double latitude, double longitude) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String toString() {
        return city + ", " + state + " " + zipCode + " " + country +
                " (" + latitude + ", " + longitude + ")";
    }

}