package model;

public class Dane {

	private int id;
	private String name;
	private String info;
	//private String marker_icon;
	private double lat;
	private double lng;
	private int rating;
	private String www;
	private String adress;
	private String phone;
	private String type;
	private String place_image;

	public Dane(int id, String name, String info, double lat, double lng, int rating, String www,
			String adress, String phone, String type, String place_image) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		//this.marker_icon = marker_icon;
		this.lat = lat;
		this.lng = lng;
		this.rating = rating;
		this.www = www;
		this.adress = adress;
		this.phone = phone;
		this.type = type;
		this.place_image = place_image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/*public String getMarker_icon() {
		return marker_icon;
	}

	public void setMarker_icon(String marker_icon) {
		this.marker_icon = marker_icon;
	}*/

	public double getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlaceImage() {
		return place_image;
	}

	public void setPlaceImage(String place_image) {
		this.place_image = place_image;
	}

}
