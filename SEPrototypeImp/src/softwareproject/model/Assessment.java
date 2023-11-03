package softwareproject.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Assessment implements Serializable{
    private static final long serialVersionUID = 7863232235394607247L;
    private String name;
    private boolean isSummative;
    private boolean isOnline;
    private int weight;
    private ArrayList<Milestone> milestones;
    private ArrayList<Activity> activities;
    private ArrayList<StudyTask> tasks;
    private Date dueDate;
    private int progress;

    public Assessment(String name, boolean isSummative, boolean isOnline, int weight, Date dueDate) {
        this.name = name;
        this.isSummative = isSummative;
        this.isOnline = isOnline;
        this.weight = weight;
        this.dueDate = dueDate;
        progress = 0;
        
        this.activities = new ArrayList();
        this.tasks = new ArrayList();
        this.milestones = new ArrayList();
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
    
    abstract public Date getSetDate();
    
    public ArrayList<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(ArrayList<Milestone> milestones) {
        this.milestones = milestones;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public void addTask(StudyTask t){
        this.tasks.add(t);
    }
    
    public void addActivity(Activity a){
        this.activities.add(a);
    }
    
    public void addMilestone(Milestone m){
        this.milestones.add(m);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<StudyTask> getTasks() {
        return tasks;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void setTasks(ArrayList<StudyTask> tasks) {
        this.tasks = tasks;
    }
    
    public boolean isIsSummative() {
        return isSummative;
    }

    public void setIsSummative(boolean isSummative) {
        this.isSummative = isSummative;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sb.append(this.name).append(" - ").append(fmt.format(dueDate)).append(" - ").append(this.weight).append("%");
        return sb.toString();
    }
    
    
    
    
}
