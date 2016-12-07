/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tenaciouspanda.jobstretchtest;

import com.tenaciouspanda.jobstretch.Session;
import com.tenaciouspanda.jobstretch.database.User;

/**
 *
 * @author Simon
 */
public class SessionTester {
    public void testAll(){
        testAuthentication();
        testSearchUnconnectedUser();
    }
    public void testAuthentication(){
        Session s = new Session();
        
        if(s.isAuthenticated())
            throw new IllegalStateException("Session cannot be authenticated initially");
        
        s.authenticate("test", "test");
        if(!s.isAuthenticated())
            throw new IllegalStateException("Session failed to authenticate");
        
        s.logout();
        if(s.isAuthenticated())
            throw new IllegalStateException("Session failed to logout");
    }
    public void testSearchUnconnectedUser(){
        Session s = new Session();
        s.authenticate("test", "test");
        User[] users = s.searchUnconnectedUser("","");
        System.out.println("UNCONNECTED USERS");
        for(User u : users){
            System.out.println(u);
        }
    }
}
