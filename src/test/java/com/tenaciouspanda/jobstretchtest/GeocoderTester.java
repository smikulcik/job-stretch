package com.tenaciouspanda.jobstretchtest;


import com.tenaciouspanda.jobstretch.Geocoder;
import com.tenaciouspanda.jobstretch.database.LatLng;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simon
 */
public class GeocoderTester {
    public void testAll(){
        testGeocoder();
    }
    
    public void testGeocoder(){
        Geocoder g = new Geocoder();
        
        LatLng latlng = g.geocode("1600 Amphitheatre Parkway Mountain View, CA 94043");
        
        if(latlng == null)
            throw new IllegalStateException("Got null for geocoded coordinate");
    }
}
