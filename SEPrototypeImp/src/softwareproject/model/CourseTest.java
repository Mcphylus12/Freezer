package softwareproject.model;

import java.util.Date;

public class CourseTest extends Assessment {
    private String websiteURL;

    public CourseTest(String name, String websiteURL, Date dueDate, boolean isSummative, boolean isOnline, int weight) {
        super(name, isSummative, isOnline, weight, dueDate);
        this.websiteURL = websiteURL;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    @Override
    public Date getSetDate() {
        return this.getDueDate();
    }

}