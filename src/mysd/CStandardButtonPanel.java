/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class CStandardButtonPanel extends JPanel{
    public static final int EDITMODE = 0;
    public static final int NEWMODE = 1;
    public static final int VIEWMODE = 2;
    public static final int PRINTMODE = 3;
    

    private JButton btnSave, btnUpdate, btnPrint, btnClose;
    private JTextField tfStatus;
    private JPanel pnlStatus;

    public CStandardButtonPanel(){
        initComponents();
        designComponents();
        layoutComponents();
        
    }

    public CStandardButtonPanel(int mode){
        initComponents();
        designComponents();
        layoutComponents();

        if(mode == EDITMODE){
            btnUpdate.setEnabled(true);
            btnSave.setEnabled(false);
            btnPrint.setEnabled(false);
        }else if(mode == NEWMODE){
            btnUpdate.setEnabled(false);
            btnSave.setEnabled(true);
            btnPrint.setEnabled(false);
        }else if(mode == VIEWMODE){
            btnUpdate.setEnabled(false);
            btnSave.setEnabled(false);
            btnPrint.setEnabled(false);
        }else if(mode == PRINTMODE){
            btnUpdate.setEnabled(false);
            btnSave.setEnabled(false);
            btnPrint.setEnabled(true);
        }

    }

    public void initComponents(){
        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnPrint = new JButton("Print");
        btnClose = new JButton("Close");

        tfStatus = new JTextField();
        pnlStatus = new JPanel();
    }

    public void designComponents(){
        tfStatus.setEnabled(false);
        tfStatus.setBackground(this.getBackground());
        tfStatus.setBorder(null);
    }

    public void layoutComponents(){
        
        setLayout(new MigLayout());
        
        add(btnSave, "width 50");
        add(btnUpdate, "width 50");
        add(btnPrint, "width 50");
        add(btnClose, "width 50,wrap");
        add(tfStatus,"span 4, width 300, wrap");

    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public JButton getBtnPrint() {
        return btnPrint;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JPanel getPnlStatus() {
        return pnlStatus;
    }

    public JTextField getTfStatus() {
        return tfStatus;
    }

    

   

}
