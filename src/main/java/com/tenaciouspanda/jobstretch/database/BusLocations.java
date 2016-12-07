package com.tenaciouspanda.jobstretch.database;

/**
 *
 * @author Thomas
 */
public class BusLocations {
    private String street,city,state;
    private int locationID,zip;
    private LatLng latlng;
    
    public BusLocations() {
        
    }
    
    
    public int getLocationID() {
        return locationID;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getState() {
        return state;
    }
    public int getZip() {
        return zip;
    }
    public LatLng getLatLng(){
        return latlng;
    }
    public float getLat() {
        return latlng.getLat();
    }
    public float getLon() {
        return latlng.getLng();
    }
    
    protected void setLocation(int lID, String s, String c, String st, int z, float l, float lo) {
        locationID = lID;
        city = c;
        street = s;
        state = st;
        zip = z;
        latlng = new LatLng();
        latlng.setLat(l);
        latlng.setLng(lo);
    }
    
    @Override
    public String toString(){
        return street + ", " + city + ", " + state + " " + zip;
    }
}
