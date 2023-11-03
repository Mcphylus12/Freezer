package softwareproject.controller;

import java.text.SimpleDateFormat;
import softwareproject.model.Assessment;
import softwareproject.model.Milestone;
import softwareproject.model.StudyTask;


public class AssessmentController {
    
    public static String getAssessmentAsString(Assessment as){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        sb.append(as.getName()).append(" - ").append(fmt.format(as.getDueDate())).append(" - ").append(as.getWeight()).append("%");
        return sb.toString();
        
    }
    
    public static void attachTask(Assessment a, StudyTask t){
        a.addTask(t);
    }
    public static void attachMilestone(Assessment a, Milestone m){
        a.addMilestone(m);
    }
}