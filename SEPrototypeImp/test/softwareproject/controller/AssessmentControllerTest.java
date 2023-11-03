/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import softwareproject.model.Exam;

/**
 *
 * @author gmj14gru
 */
public class AssessmentControllerTest {
    
    /**
     * Test of getAssessmentAsString method, of class AssessmentController.
     */
    @Test
    public void testGetAssessmentAsString() {
        System.out.println("getAssessmentAsString");
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dt = fmt.format(date);
        Exam e = new Exam("Exam 1", 20, "ROOM1", new Date(), true, 15);
        String expResult = "Exam 1 - "+dt+" - 15%";
        String result = AssessmentController.getAssessmentAsString(e);
        assertEquals(expResult, result);
    }
}
