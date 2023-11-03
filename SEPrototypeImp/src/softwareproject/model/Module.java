package softwareproject.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable{
    private static final long serialVersionUID = 7863262245494607247L;
    private ArrayList<Assessment> assessments;
    private String moduleOrganiser;
    private String moduleCode;
    private String moduleName;

    public Module(String moduleOrganiser, String moduleCode, String moduleName) {
        this.moduleOrganiser = moduleOrganiser;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.assessments = new ArrayList();
    }
    
    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(ArrayList<Assessment> assessments) {
        this.assessments = assessments;
    }
    
    public void addAssessment(Assessment a){
        this.assessments.add(a);
    }

    public String getModuleOrganiser() {
        return moduleOrganiser;
    }

    public void setModuleOrganiser(String moduleOrganiser) {
        this.moduleOrganiser = moduleOrganiser;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}