package softwareproject;

import java.util.ArrayList;
import java.util.Date;
import softwareproject.controller.PanelController;
import softwareproject.model.Assessment;
import softwareproject.model.CourseTest;
import softwareproject.model.Coursework;
import softwareproject.model.Exam;
import softwareproject.model.Module;
import softwareproject.model.SemesterProfile;
import softwareproject.view.NavPane;
import softwareproject.view.OverviewDash;
import softwareproject.view.Window;


/**
 * TODO
 * - 
 * @author ybm14yju
 */
public class SoftwareProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        SemesterProfile semp = genDummy();
        Window window = new Window("Study Planner (ALPHA BUILD 1.0)");
        NavPane np = new NavPane();
        PanelController pc = new PanelController(window, np);
        np.setPanelController(pc);
        OverviewDash od = new OverviewDash(pc);
        pc.setOd(od);
        pc.toOverViewDash();
    }
    
    //FOR TESTING WITHOUT FILE
    public static SemesterProfile genDummy(){
        SemesterProfile semp = new SemesterProfile(2015, new Date(), new Date());
        
        Module m = new Module("Mr Organiser", "CMP-555Y", "Software");
        Module m2 = new Module("Mr Other Guy", "CMP-644B", "Progs");
        
        Exam e = new Exam("Exam 1", 20, "ROOM1", new Date(), true, 15);
        Exam e1 = new Exam("Exam 2", 50, "ROOM2", new Date(), false, 80);
        
        Coursework cw = new Coursework("Coursework 1", new Date(), new Date(), new Date(), "Marker 1", "Hand In", true, false, 60);
        Coursework cw1 = new Coursework("Coursework 2", new Date(), new Date(), new Date(), "Marker 2", "Bin", false, false, 90);
        
        CourseTest ct = new CourseTest("CourseTest 1", "www.uea.test", new Date(), false, true, 90);
        CourseTest ct1 = new CourseTest("CourseTest 2", "www.test.com", new Date(), false, false, 12);
        
        ArrayList<Assessment> as = new ArrayList();
        ArrayList<Assessment> as2 = new ArrayList();
        
        as.add(e);
        as.add(ct1);
        as.add(e1);
        
        as2.add(cw);
        as2.add(cw1);
        as2.add(ct);
        
        m.setAssessments(as);
        m2.setAssessments(as2);
        
        semp.addModule(m);
        semp.addModule(m2);
        
        return semp;
    }
    
}
