package softwareproject.controller;

import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Daniel Banks
 */
public class ErrorController {
    
    public static boolean intValidation(JTextField txt){
        boolean success = true;
        try {
            Integer.parseInt(txt.getText());
        }catch(NumberFormatException exc){
            success = false;
        }
        if(success){
            if(Integer.parseInt(txt.getText()) > 0){
                txt.setBackground(UIManager.getColor("TextField.background"));
                return true;
            }else{
                txt.setBackground(Color.RED);
                return false;
            }
        }else{
            txt.setBackground(Color.RED);
            return false;
        }
    }
    
    public static boolean dateValidation(String inputDate){
        Date date = null;
        boolean validDate = true;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            date = formatter.parse(inputDate);
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.setTime(date);
            try {
                cal.getTime();
            }
            catch (Exception e) {
                validDate = false;
                System.out.println("Invalid date - Calendar");
            }
        } catch (ParseException e) { 
            validDate = false;
            System.out.println("Invalid date");
        }
        
        if(validDate && date.before(new Date())){
            validDate = false;
        }
        
        return validDate;
    }
    
    public static void resetColour(java.awt.event.FocusEvent evt){
        evt.getComponent().setBackground(UIManager.getColor("TextField.background"));
    }
    
    public static boolean txtEmptyValidation(String s){
        return !s.trim().equals("");
    }
    
    public static boolean listSelectionValidation(JList lst){
        return lst.getSelectedValuesList().size() > 0;
    }
    
    public static void setErrorBackground(boolean valid, Component c){
        if(!valid){
            c.setBackground(Color.RED);
        }else{
            c.setBackground(UIManager.getColor("TextField.background"));
        }
    }
}
