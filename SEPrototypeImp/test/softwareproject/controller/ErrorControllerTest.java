/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareproject.controller;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author gmj14gru
 */
public class ErrorControllerTest {

    /**
     * Test of dateValidation method, of class ErrorController.
     */
    @Test
    public void testDateValidation() {
        System.out.println("dateValidation");
        String inputDate = "05/08/2020";
        boolean expResult = true;
        boolean result = ErrorController.dateValidation(inputDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of dateValidation method to Fail, of class ErrorController.
     */
    @Test
    public void testDateValidationFail() {
        System.out.println("dateValidation");
        String inputDate = "05/08/2010";
        boolean expResult = false;
        boolean result = ErrorController.dateValidation(inputDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of txtEmptyValidation method, of class ErrorController.
     */
    @Test
    public void testTxtEmptyValidation() {
        System.out.println("txtEmptyValidation");
        String s = "test";
        boolean expResult = true;
        boolean result = ErrorController.txtEmptyValidation(s);
        assertEquals(expResult, result);
    }
    
}
