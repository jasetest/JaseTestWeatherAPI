public class Location {
    //instance variables
    private final String zipCode;
    private final String city;
    private final String state;
    private final String country;
    private final double latitude;
    private final double longitude;

    //constructor
    public Location(String zipCode, String city, String state, String country, double latitude, double longitude) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //getter methods (others were deleted)
    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    //i think this is for the console variant of my weather API program
    public String toString() {
        return city + ", " + state + " " + zipCode + " " + country +
                " (" + latitude + ", " + longitude + ")";
    }
}