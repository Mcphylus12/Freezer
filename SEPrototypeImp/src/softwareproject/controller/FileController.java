package softwareproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import softwareproject.model.CourseTest;
import softwareproject.model.Coursework;
import softwareproject.model.Exam;
import softwareproject.model.Module;
import softwareproject.model.SemesterProfile;


public class FileController {
    /**
     * Reads in data from a pre-defined file format and creates a semester profile
     * @param fileName - The name of the file you want to load from
     * @return A full semester profile
     */
    public static SemesterProfile readSemesterFile(String fileName){
        File semesterFile = null;
        Scanner scan = null;
        try {
            semesterFile = new File(fileName);
            scan = new Scanner(semesterFile);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy:HH:mm");
        
        String[] semester = scan.nextLine().split(",");
        int semYear = Integer.parseInt(semester[0]);
        Date semStart = null;
        try {
            semStart = dateFormat.parse(semester[1]);
        } catch (ParseException ex) {
            System.out.println("Error parsing date " + semester[1]);
        }
        Date semEnd = null;
        try {
            semEnd = dateFormat.parse(semester[2]);
        } catch (ParseException ex) {
            System.out.println("Error parsing date " + semester[2]);
        }
        
        SemesterProfile semp = new SemesterProfile(semYear, semStart, semEnd);
        Module m = null;
        Coursework cw = null;
        Exam e = null;
        CourseTest ct = null;
        
        while(scan.hasNextLine()){
            String line  = scan.nextLine();
            //New Module
            if(line.equals("MODULE")){
                String[] modInfo = scan.nextLine().split(", ");
                String modOrg = modInfo[0];
                String modCode = modInfo[1];
                String modName = modInfo[2];
                m = new Module(modOrg, modCode, modName);
            }
            //Coursework
            else if (line.equals("COURSEWORK")){
                String[] cwInfo = scan.nextLine().split(", ");
                String cwName = cwInfo[0];
                Date cwDueDate = null;
                try {
                    cwDueDate = dateFormat.parse(cwInfo[1]);
                } catch(ParseException ex){
                    System.out.println("Error parsing date " + cwInfo[1]);
                }
                Date cwSetDate = null;
                try {
                    cwSetDate = dateFormat.parse(cwInfo[2]);
                } catch(ParseException ex){
                    System.out.println("Error parsing date " + cwInfo[2]);
                }
                Date cwReturnDate = null;
                try {
                    cwReturnDate = dateFormat.parse(cwInfo[3]);
                } catch(ParseException ex){
                    System.out.println("Error parsing date " + cwInfo[3]);
                }
                String marker = cwInfo[4];
                String subType = cwInfo[5];
                boolean isSummative = Boolean.parseBoolean(cwInfo[6]);
                boolean isOnline = Boolean.parseBoolean(cwInfo[7]);
                int weight = Integer.parseInt(cwInfo[8]);
                
                cw = new Coursework(
                        cwName, 
                        cwDueDate, 
                        cwSetDate, 
                        cwReturnDate, 
                        marker, 
                        subType, 
                        isSummative, 
                        isOnline, 
                        weight);
                
                
                m.addAssessment(cw);
            }
            //Exams
            else if (line.equals("EXAMS")){
                String[] examInfo = scan.nextLine().split(", ");
                String examName = examInfo[0];
                int duration = Integer.parseInt(examInfo[1]);
                String location = examInfo[2];
                Date examDate = null;
                try {
                    examDate = dateFormat.parse(examInfo[3]);
                } catch(ParseException ex){
                    System.out.println("Error parsing date " + examInfo[3]);
                }
                boolean isSummative = Boolean.parseBoolean(examInfo[4]);
                int weight = Integer.parseInt(examInfo[5]);
                
                e = new Exam(
                        examName,
                        duration, 
                        location, 
                        examDate, 
                        isSummative, 
                        weight);
                
                m.addAssessment(e);
            }
            //Coursetests
            else if (line.equals("COURSETESTS")){
                String[] ctInfo = scan.nextLine().split(", ");
                String ctName = ctInfo[0];
                String url = ctInfo[1];
                Date ctDueDate = null;
                try {
                    ctDueDate = dateFormat.parse(ctInfo[2]);
                } catch(ParseException ex){
                    System.out.println("Error parsing date " + ctInfo[2]);
                }
                boolean isSummative = Boolean.parseBoolean(ctInfo[3]);
                boolean isOnline = Boolean.parseBoolean(ctInfo[4]);
                int weight = Integer.parseInt(ctInfo[5]);
                
                ct = new CourseTest(ctName, url, ctDueDate, isSummative, isOnline, weight);
                
                m.addAssessment(ct);
            }
            //Add module to semesterprofile
            else if(line.equals("ENDMODULE")){
                semp.addModule(m);
            }
        }
        return semp;
    }
    
    public static boolean writeToFile(SemesterProfile semp, String path) {
        if(semp != null){
            try {
                FileOutputStream fout = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(semp);
                oos.close();
                return true;
            } catch(IOException ex){
                System.out.println("Error writing semp to file");
            }
        }
        else {
            JOptionPane.showMessageDialog(new JFrame(), "Semester Profile is Empty, Not Written to File.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public static SemesterProfile readFromSer(String fileName){
        SemesterProfile semp = null;
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            semp = (SemesterProfile) ois.readObject();
            ois.close();
            return semp;
        } catch(IOException | ClassNotFoundException ex){
            System.out.println("Error reading from ser");
            return null;
        }
    }
}
