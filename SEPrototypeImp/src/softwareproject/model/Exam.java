package softwareproject.model;

import java.util.Date;

public class Exam extends Assessment{
    private int duration;
    private String location;

    public Exam(String name, int duration, String location, Date date, boolean isSummative, int weight) {
        super(name, false, isSummative, weight, date);
        this.duration = duration;
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    @Override
    public Date getSetDate() {
        Date a = new Date(super.getDueDate().getTime()+(duration*60000));
        return a;
    }
    
}