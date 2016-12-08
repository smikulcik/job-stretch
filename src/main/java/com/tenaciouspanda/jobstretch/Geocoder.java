/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.tenaciouspanda.jobstretch.database.LatLng;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class Geocoder {
    private String api_key = "AIzaSyBIG3n-yCC830m-wQ5fkvWfZOYhDP8Ah58";
    private GeoApiContext context;
    
    
    public Geocoder(){
        context = new GeoApiContext().setApiKey(api_key);
    }
    
    public LatLng geocode(String location) {
        LatLng result = null;
        if(context == null)
            throw new IllegalStateException("Must initialize Geocoder before use");
        
        try {
            GeocodingResult gr = GeocodingApi.geocode(context,
                    location).await()[0];
            double lat = gr.geometry.location.lat;
            double lng = gr.geometry.location.lng;
            return new LatLng((float)lat, (float)lng);
        } catch (ArrayIndexOutOfBoundsException ex){
            Logger.getLogger(Geocoder.class.getName()).log(Level.INFO, "no location found for {0}", location);
        }catch (Exception ex) {
            Logger.getLogger(Geocoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LatLng(0, 0);
    }
}
