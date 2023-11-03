/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareproject.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import softwareproject.model.Activity;

/**
 *
 * @author gmj14gru
 */
public class ActivityControllerTest {
    Activity act;
    
    @Before
    public void setup(){
        act = new Activity("test", "test desc", 10, null);
    }
    
    /**
     * Test of getActivityAsString method set to finished, of class ActivityController.
     */
    @Test
    public void testGetActivityAsStringComplete() {
        System.out.println("getActivityAsString");
        act.setIsFinished(true);
        String expResult = "test - Complete";
        String result = ActivityController.getActivityAsString(act);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getActivityAsString method set to not finished, of class ActivityController.
     */
    @Test
    public void testGetActivityAsStringInProgress() {
        System.out.println("getActivityAsString");
        act.setIsFinished(false);
        String expResult = "test - In progress";
        String result = ActivityController.getActivityAsString(act);
        assertEquals(expResult, result);
    }
    
}
