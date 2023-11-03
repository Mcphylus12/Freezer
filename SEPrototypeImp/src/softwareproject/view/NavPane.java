package softwareproject.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import softwareproject.controller.ListPopulator;
import softwareproject.controller.ModuleController;
import softwareproject.controller.PanelController;
import softwareproject.model.Module;
import softwareproject.model.SemesterProfile;

/**
 *
 * @author qxz14sru
 */
public class NavPane extends javax.swing.JPanel implements ListCellRenderer<Module>{

    PanelController pa;
    SemesterProfile sp;
    
    /**
     * Creates new form NavPane
     *
     */
    public NavPane() {
        this.sp = null;
        initComponents();
        fillComponents();
    }
    
    private void fillComponents(){
        ListPopulator<Module> lp = new ListPopulator();
        if(sp != null){
            lp.populateJList(sp.getModules(), lstNav);
        }
        lstNav.setCellRenderer(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstNav = new javax.swing.JList();
        btnSetToDash = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(188, 562));
        setMinimumSize(new java.awt.Dimension(188, 562));
        setPreferredSize(new java.awt.Dimension(188, 562));

        lstNav.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstNavMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstNav);

        btnSetToDash.setText("Back to Dashboard");
        btnSetToDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetToDashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSetToDash, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSetToDash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstNavMouseClicked
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 1) {
            int index = list.locationToIndex(evt.getPoint());
            pa.setModulePanel(new ModuleOverview(sp, (Module)lstNav.getSelectedValue()));
        }
    }//GEN-LAST:event_lstNavMouseClicked
    
    public void setSemesterProfile(SemesterProfile semp){
        this.sp = semp;
        fillComponents();
    }
    
    public SemesterProfile getSemesterProfile(){
        return this.sp;
    }
    
    private void btnSetToDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetToDashActionPerformed
        pa.toOverViewDash();
    }//GEN-LAST:event_btnSetToDashActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetToDash;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstNav;
    // End of variables declaration//GEN-END:variables
    @Override
    public Component getListCellRendererComponent(JList<? extends Module> jlist, Module e, int i, boolean bln, boolean bln1) {
        moduleListCellNav cellPane = new moduleListCellNav(
                e.getModuleName(), 
                e.getModuleCode(),
                e.getModuleOrganiser(), 
                ModuleController.getAssessments(e));
        if(bln){
            cellPane.setBackground(Color.gray);
        }
        
        return cellPane;
    }

    public void setPanelController(PanelController pa) {
        this.pa = pa;
    }
}
