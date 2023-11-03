package softwareproject.controller;


import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.imagemap.OverLIBToolTipTagFragmentGenerator;
import softwareproject.model.SemesterProfile;
import softwareproject.view.*;

/**
 *
 * @author qxz14sru
 */
public class PanelController implements WindowListener {
    
    private static final int xOff = 5;
    private static final int yOff = 5;
    private static final double navPanePercentage = 0.30;
    
    Container windowContentPane;
    NavPane nav;

    public PanelController(Window window, NavPane nav) {
        this.windowContentPane = window.getContentPane();
        this.nav = nav;
        window.addWindowListener(this);
    }

    public void setOd(OverviewDash od) {
        this.od = od;
    }
    OverviewDash od;
    
    public void setModulePanel(ModuleOverview mo){
        windowContentPane.removeAll();
        windowContentPane.setLayout(null);
        Rectangle r = new Rectangle((int)((double)(windowContentPane.getWidth())*navPanePercentage) + xOff, yOff, 
                (int)((double)(windowContentPane.getWidth())*(1-navPanePercentage)) - xOff*2, windowContentPane.getHeight() - yOff*2);
        System.out.println("module rect = " + r);
        mo.setBounds(r);
        windowContentPane.add(mo);
        r = new Rectangle(xOff, yOff, (int)((double)(windowContentPane.getWidth())*navPanePercentage) - xOff*2, windowContentPane.getHeight() - yOff*2);   
        System.out.println("nav rect = " + r);
        nav.setBounds(r);
        windowContentPane.add(nav);
        windowContentPane.revalidate();
        windowContentPane.repaint();
    }
    
    public void toDashBoardPanel(){
        windowContentPane.removeAll();
        windowContentPane.setLayout(null);
        Rectangle r = new Rectangle(xOff, yOff, windowContentPane.getWidth() - xOff*2, windowContentPane.getHeight() - yOff*2);
        System.out.println("dashboard rect = " + r);
        windowContentPane.revalidate();
        windowContentPane.repaint();
    }
    
    public void toOverViewDash(){
        windowContentPane.removeAll();
        windowContentPane.setLayout(null);
        Rectangle r = new Rectangle(xOff, yOff, windowContentPane.getWidth() - xOff*2, windowContentPane.getHeight() - yOff*2);
        System.out.println("dashboard rect = " + r);
        od.setBounds(r);
        windowContentPane.add(od);
        windowContentPane.revalidate();
        windowContentPane.repaint();
    }
    
    public void setSemesterProfile(SemesterProfile sp){
        nav.setSemesterProfile(sp);
    }

    @Override
    public void windowOpened(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        String path = "";
        if(od.openFileName.isEmpty()){
            path = JOptionPane.showInputDialog("Semester Profile not Saved, Enter file name to save:");
            if(path == null){
                path = "";
            }
            if(path.trim().isEmpty()){
                path = "defaultSemesterProfile.ser";
            }else{
                if(!path.endsWith(".ser")){
                    path += ".ser";
                }
            }
        }else{
            path = od.openFileName;
        }
        if(FileController.writeToFile(nav.getSemesterProfile(), path)){
            JOptionPane.showMessageDialog(new JFrame(), "Semester profile saved to "+path, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
