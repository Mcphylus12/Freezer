/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gmj14gru
 */
public class FormControllerTest {
    /**
     * Test of dateToString method, of class FormController.
     */
    @Test
    public void testDateToString() {
        System.out.println("dateToString");
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dt = fmt.format(date);
        
        String expResult = dt;
        String result = FormController.dateToString(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateFromStrings method, of class FormController.
     */
    @Test
    public void testGetDateFromStrings() {
        System.out.println("getDateFromStrings");
        String dateString = "16/08/2030";
        Date expResult = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        try {
            expResult = sd.parse(dateString);
        } catch (ParseException ex) {
        }
        Date result = FormController.getDateFromStrings(dateString);
        assertEquals(expResult, result);
    }
    
}
