package softwareproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class StudyTask implements Notable, Serializable{
    private static final long serialVersionUID = 7863862235394607247L;
    private String title;
    private String description;
    private ArrayList<StudyTask> dependencies;
    private ArrayList<Note> notes;
    private ArrayList<Activity> activities;
    private ArrayList<Milestone> relatedMilestones;
    private int hours;
    private int progress;
    private boolean isComplete;
    private Date startDate;
    private Date endDate;
    private TaskActivityType type;    

    public StudyTask(String title, String description, int hours, TaskActivityType type, Date endDate, ArrayList<StudyTask> dependencies) {
        this.isComplete = false;
        this.title=title;
        this.description = description;
        this.hours = hours;
        this.type = type;
        this.progress = 0;
        this.dependencies = dependencies;
        this.notes = new ArrayList();
        this.activities = new ArrayList<>();
        this.relatedMilestones = new ArrayList<>();
        this.startDate = new Date();
        this.endDate = endDate;
    }
    
    public TaskActivityType getType() {
        return type;
    }

    public void setType(TaskActivityType type) {
        this.type = type;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Milestone> getRelatedMilestones() {
        return relatedMilestones;
    }

    public void setRelatedMilestones(ArrayList<Milestone> relatedMilestones) {
        this.relatedMilestones = relatedMilestones;
    }
    
    public void addRelatedMilestones(Milestone m){
        relatedMilestones.add(m);
    }
    
    public void removeRelatedMilestones(Milestone m){
       relatedMilestones.remove(m);
    }
    

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<StudyTask> getDependencies() {
        return dependencies;
    }

    public void setDependencies(ArrayList<StudyTask> dependencies) {
        this.dependencies = dependencies;
    }
    
    public void addDependency(StudyTask t){
        dependencies.add(t);
    }
    
    public void removeDependency(StudyTask t){
       dependencies.remove(t);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
        
    @Override
    public void addNote(Note t){
        notes.add(t);
    }
    
    public void removeNote(Note t){
       notes.remove(t);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
    
    public void addActivity(Activity a){
        activities.add(a);
    }
    
    public void removeActivity(Activity a){
       activities.remove(a);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        return sb.toString();
    }
}
