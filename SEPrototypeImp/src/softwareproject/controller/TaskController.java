package softwareproject.controller;

import java.util.ArrayList;
import java.util.Date;
import softwareproject.model.StudyTask;
import softwareproject.model.TaskActivityType;

public class TaskController {
    
    public static String getStringFromTask(StudyTask t){
        StringBuilder sb = new StringBuilder();
        sb.append(t.getTitle());
        return sb.toString();
    }
    
    public static StudyTask createNewTask(
            String title, 
            String description, 
            int hours,
            TaskActivityType type,
            String endDate,
            ArrayList<StudyTask> dependencies){
        Date date = FormController.getDateFromStrings(endDate);
        return new StudyTask(title, description, hours, type, date, dependencies);
    }
}
