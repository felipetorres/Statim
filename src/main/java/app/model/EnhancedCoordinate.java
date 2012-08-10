package app.model;

public class EnhancedCoordinate {

	private double latitude;
	private double longitude;
	private final String deviceName;
	
	public EnhancedCoordinate(double latitude, double longitude, String deviceName) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.deviceName = deviceName;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
}
