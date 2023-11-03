package softwareproject.controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import org.jfree.data.gantt.Task;
import softwareproject.model.StudyTask;

public class ListPopulator<T> {
    
    public void populateJList(ArrayList<T> src, JList jl){
        DefaultListModel<T> lm = new DefaultListModel();
        for(T o :src){
            lm.addElement(o);
        }
        jl.setModel(lm);
    }
    
    public void populateComboBox(ArrayList<T> src, JComboBox jcb){
        jcb.removeAllItems();
        for(T o : src){
            jcb.addItem(o);
        } 
        jcb.setSelectedIndex(0);
    }
    
    public void populateDependencyList(ArrayList<StudyTask> src, JList jl){
        DefaultListModel<StudyTask> lm = new DefaultListModel();
        for(StudyTask o :src){
            if(!o.getIsComplete()){
                lm.addElement(o);
            }
        }
        jl.setModel(lm);
    }

    public void populateActivityDependencyList(ArrayList<StudyTask> src, JList jl){
        DefaultListModel<StudyTask> lm = new DefaultListModel();
        for(StudyTask o :src){
            boolean add = true;
            for(StudyTask o1 : o.getDependencies()){
                if(!o1.getIsComplete()){
                    add = false;
                    break;
                }
            }
            if(o.getIsComplete()){
                add = false;
            }
            if(add){
                lm.addElement(o);  
            }
        }
        jl.setModel(lm);
    }
}