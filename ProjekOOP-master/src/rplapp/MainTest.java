/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rplapp;

import com.*;
import exe.*;
/**
 *
 * @author userPC
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ExecuteTranskrip trans = new ExecuteTranskrip();
       Object[][] myTranskrip = trans.listTranskrip();
       System.out.println(myTranskrip[0][4]);
        
    }
    
}
