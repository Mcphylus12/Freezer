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
import softwareproject.model.StudyTask;
import softwareproject.model.TaskActivityType;

/**
 *
 * @author gmj14gru
 */
public class TaskControllerTest {
    /**
     * Test of getStringFromTask method, of class TaskController.
     */
    @Test
    public void testGetStringFromTask() {
        System.out.println("getStringFromTask");
        StudyTask t = new StudyTask("Name", "Desc", 10, TaskActivityType.OTHER, new Date(), new ArrayList<StudyTask>());
        String expResult = "Name";
        String result = TaskController.getStringFromTask(t);
        assertEquals(expResult, result);
    }    
}
