package softwareproject.controller;

import java.util.ArrayList;
import softwareproject.model.Assessment;
import softwareproject.model.Module;

public class ModuleController{
    public static ArrayList<Assessment> getAssessments(Module m){
        return m.getAssessments();
    }
}