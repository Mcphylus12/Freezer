/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareproject.controller;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import softwareproject.model.Note;

/**
 *
 * @author gmj14gru
 */
public class NoteControllerTest {
    /**
     * Test of getNoteAsString method, of class NoteController.
     */
    @Test
    public void testGetNoteAsString() {
        System.out.println("getNoteAsString");
        Note n = new Note("Name", "Cont", new Date());
        String expResult = n.getDateCreated().toString()+" - Name - Cont";
        String result = NoteController.getNoteAsString(n);
        assertEquals(expResult, result);
    }
    
}
