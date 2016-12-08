/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch.database;

/**
 *
 * @author Simon
 */
public class LatLng {
    
    float lat;
    float lng;
    
    public LatLng(){
        lat = 0;
        lng = 0;
    }
    public LatLng(float lat, float lng){
        this.lat = lat;
        this.lng = lng;
    }
    
    public float getLat(){
        return lat;
    }
    public float getLng(){
        return lng;
    }
    public void setLat(float lat){
        this.lat = lat;
    }
    public void setLng(float lng){
        this.lng = lng;
    }
}
