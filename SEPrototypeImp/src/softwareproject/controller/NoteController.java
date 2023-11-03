package softwareproject.controller;

import java.util.Date;
import softwareproject.model.Notable;
import softwareproject.model.Note;

public class NoteController {
    
    public static Note createNote(String name, String contents, Date dateCreated){
        return new Note(name, contents, dateCreated);
    }

    public static void attachNote(Notable parent, Note newNote) {
        parent.addNote(newNote);
    }
    
    public static String getNoteAsString(Note n){
        StringBuilder sb = new StringBuilder();
        sb.append(n.getDateCreated()).append(" - ").append(n.getName())
                .append(" - ").append(n.getContents());
        
        return sb.toString();
    }
}
