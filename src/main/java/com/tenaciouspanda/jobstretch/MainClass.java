/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenaciouspanda.jobstretch;

import com.tenaciouspanda.jobstretch.frontend.JobStretchFrame;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Simon
 */
 public class MainClass {
    public static void main(String[] args){  
        JobStretchFrame frame = new JobStretchFrame();
        frame.setTitle("My First Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setVisible(true);
    }
 }
