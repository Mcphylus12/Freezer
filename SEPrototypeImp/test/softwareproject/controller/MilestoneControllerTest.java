/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareproject.controller;

import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import softwareproject.model.Milestone;
import softwareproject.model.StudyTask;

/**
 *
 * @author gmj14gru
 */
public class MilestoneControllerTest {
    
    /**
     * Test of getStringFromTask method, of class MilestoneController.
     */
    @Test
    public void testGetStringFromTask() {
        System.out.println("getStringFromTask");
        Milestone m = new Milestone("name", "desc", new Date(), new ArrayList<StudyTask>());
        String expResult = "name";
        String result = MilestoneController.getStringFromMilestone(m);
        assertEquals(expResult, result);
    }
    
}
