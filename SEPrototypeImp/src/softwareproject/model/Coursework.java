package softwareproject.model;

import java.util.Date;

public class Coursework extends Assessment {
    private Date setDate;
    private Date returnDate;
    private String marker;
    private String submissionType;

    public Coursework(String name, Date dueDate, Date setDate, Date returnDate, String marker, String submissionType, boolean isSummative, boolean isOnline, int weight) {
        super(name, isSummative, isOnline, weight, dueDate);
        this.setDate = setDate;
        this.returnDate = returnDate;
        this.marker = marker;
        this.submissionType = submissionType;
    }
    
    @Override
    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }
}