/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch;

import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.tenaciouspanda.jobstretch.database.DBconnection;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Simon
 */
public class LoadDataFromCSV {
    
    public static void main(String[] args){
        try {
            Session s = new Session();
            s.authenticate("smix", "smix");
            Geocoder g = new Geocoder();
            File csvData = new File("c:\\users\\simon\\Desktop\\simonLinkedInDataset.csv");
            CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.EXCEL);
            for (CSVRecord csvRecord : parser) {
                try{
                    String fname = csvRecord.get(0);
                    String lname = csvRecord.get(1);
                    String job_title = csvRecord.get(2);
                    String company = csvRecord.get(3);
                    String city = csvRecord.get(4);
                    String state = csvRecord.get(5);
                    GeocodingResult r;
                    
                    r = g.geocodeGR(company + ", " + city + ", " + state);
                    if(r == null){
                        r = g.geocodeGR(company);
                        System.out.println("Trying again with " + company);
                    }
                    if(r == null){
                        r = g.geocodeGR(city + ", " + state);
                        System.out.println("Trying again with " + city + ", " + state);
                    }
                    if(r == null){
                        throw new Exception("No address found");
                    }
                    
                    // get zip
                    Integer zipcode = null;
                    for(AddressComponent c : r.addressComponents){
                        for(AddressComponentType t : c.types){
                            if(t == AddressComponentType.POSTAL_CODE){
                                zipcode = Integer.parseInt(c.shortName);
                            }
                        }
                    }
                    if(zipcode == null)
                        System.out.println("Cant find zip " + zipcode);
                    
                    // get state abbr
                    String stateabbr = "";
                    for(AddressComponent c : r.addressComponents){
                        for(AddressComponentType t : c.types){
                            if(t == AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1){
                                stateabbr = c.shortName;
                            }
                        }
                    }
                    if(stateabbr.equals(""))
                        System.out.println("Cant find state " + state);
                    
                    float lat = (float)r.geometry.location.lat;
                    float lon = (float)r.geometry.location.lng;
                    
                    // add connection
                    DBconnection.addNonexistantContact(s.getCurrentUser().getUserID(), 
                            fname, lname, city, "", stateabbr, zipcode, job_title, 
                            company, lat, lon);
                    
                    System.out.println(String.format("SUCCESS: %s -- %s -- %s -- %s -- %s -- %s", csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3), csvRecord.get(4), csvRecord.get(5)));
                    System.out.println();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(String.format("FAILED: %s -- %s -- %s -- %s -- %s -- %s", csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3), csvRecord.get(4), csvRecord.get(5)));
                    System.out.println();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadDataFromCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
