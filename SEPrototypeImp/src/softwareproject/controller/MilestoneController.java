package softwareproject.controller;

import java.util.ArrayList;
import java.util.Date;
import softwareproject.model.Milestone;
import softwareproject.model.StudyTask;

public class MilestoneController {
    public static Milestone createNewMilestone(
            String title, 
            String description, 
            String dateString, 
            ArrayList<StudyTask> relatedTasks){
        Date date = FormController.getDateFromStrings(dateString);
        return new Milestone(title, description, date, relatedTasks);
    }
    
    public static String getStringFromMilestone(Milestone m){
        StringBuilder sb = new StringBuilder();
        sb.append(m.getTitle());
        return sb.toString();
    }
}
