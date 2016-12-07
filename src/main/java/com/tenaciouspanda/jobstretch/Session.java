/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch;

import com.tenaciouspanda.jobstretch.database.DBconnection;
import com.tenaciouspanda.jobstretch.database.User;
import com.tenaciouspanda.jobstretch.database.StaticConnection;
import java.util.ArrayList;
/**
 *
 * @author Simon
 */
public class Session {
    protected User currentUser;
    private Object selected = null;
    
    public Session(){
    }
    public boolean authenticate(String username, String password){
        int returned = DBconnection.checkLoginCred(username, password);
        if(returned!=DBconnection.RESULT_CONNECT_FAILED && returned != DBconnection.RESULT_EXIST) {
            currentUser = new User(returned);
            currentUser.setContacts();
            return true;
        }
        return false;
    }
    public boolean isAuthenticated(){
        return currentUser != null;
    }

    public boolean register(
            String user, 
            String pass, 
            String fname, 
            String lname, 
            String city, 
            String street, 
            String state, 
            int zip, 
            String occu, 
            String bus, 
            String sum, 
            String startDate, 
            String endDate, 
            boolean employed){
        int result = DBconnection.createAccount(user, pass, fname, lname, city, street, state, zip, occu, bus, sum, startDate, endDate, employed);
        
        return (result == DBconnection.RESULT_OK);
    }

    public void logout() {
        this.currentUser = null;
        StaticConnection.closeConnection();
    }
    
    public User[] searchUsers(String fname, String lname){
         return DBconnection.searchUser(fname, lname);
     }
    public User[] searchConnectedUser(String queryString){
        return DBconnection.searchConnectedUser(currentUser.getUserID(), queryString);
    }
    public User[] searchUnconnectedUser(String fname, String lname){
        return DBconnection.searchUnconnectedUser(currentUser.getUserID(), fname, lname);
    }

    public void addConnection(User newUser) {
        DBconnection.addContact(currentUser.getUserID(), newUser.getUserID());
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void select(Object o) {
        selected = o;
    }

    public Object getSelected() {
        return selected;
    }
}
