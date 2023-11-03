package softwareproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Activity implements Notable, Serializable{
    private static final long serialVersionUID = 7863962235394607247L;
    private String name;
    private String description;
    private ArrayList<Note> notes;
    private ArrayList<StudyTask> tasks;
    private boolean isFinished;
    private int hours;
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Activity(String name, String description, int hours, ArrayList<StudyTask> tasks) {
        this.name = name;
        this.description = description;
        this.hours = hours;
        isFinished = false;
        notes = new ArrayList();
        this.tasks = tasks;
        this.startDate = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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

    public void setTasks(ArrayList<StudyTask> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
     * 
     * @return whether the activity is finished
     */
    public boolean getIsFinished() {
        return isFinished;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
    
    @Override
    public void addNote(Note note){
        notes.add(note);
    }
    
    public void removeNote(Note note){
        notes.remove(note);
    }
    
    public void addTask(StudyTask task){
        tasks.add(task);
    }
    
    public void removeTask(StudyTask task){
        tasks.remove(task);
    }
    
    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ").append(this.hours).append("Hr(s)").append(" - ");
        if(isFinished){
            sb.append(" Complete");
        }else
            sb.append(" In Progress");
        return sb.toString();
    }
}
