/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch.frontend;

import com.tenaciouspanda.jobstretch.Session;
import javax.swing.JPanel;

/**
 *
 * @author Simon
 */
public abstract class CardSubpanel extends JPanel{
    
    Session session;
    ViewManager view;
    
    public CardSubpanel(Session session, ViewManager theView) {
        this.session = session;
        this.view = theView;
    }
    
    public void onShow(){};

}
