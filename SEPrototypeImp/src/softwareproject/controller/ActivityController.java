package softwareproject.controller;

import java.util.ArrayList;
import softwareproject.model.Activity;
import softwareproject.model.StudyTask;

public class ActivityController {

    public static Activity createActivity(String name, String description, int hours, ArrayList<StudyTask> tasks) {
        return new Activity(name, description, hours, tasks);
    }

    public static String getActivityAsString(Activity act) {
        StringBuilder sb = new StringBuilder();
        sb.append(act.getName()).append(" - ");
        if (act.getIsFinished()) {
            sb.append("Complete");
        } else {
            sb.append("In progress");
        }
        return sb.toString();
    }
}
