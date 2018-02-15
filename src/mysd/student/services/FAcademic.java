/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import acr.component.CDateField;
import acr.component.CTextField;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysd.CCMBGrade;
import mysd.CStandardButtonPanel;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FAcademic implements StandardFormInterface {

    protected CTextField tfPreviousSchool, tfLastClass, tfReasonOfLeaving;
    protected CDateField tfDateOfLeaving, tfAdmissionDate;
    protected CCMBGrade cmbGradeAdmitted;
    protected CStandardButtonPanel buttonPanel;
    protected JPanel pnlMain;
    
    public FAcademic() {


        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();

        JOptionPane.showMessageDialog(null, pnlMain);


    }

   public void initComponents() {

        tfPreviousSchool = new CTextField();
        tfLastClass = new CTextField();
        tfReasonOfLeaving = new CTextField();
        tfDateOfLeaving = new CDateField();
        tfAdmissionDate = new CDateField();
        cmbGradeAdmitted = new CCMBGrade();
        //buttonPanel = new CStandardButtonPanel(mode);
        //csi = new CStudentInfo();
        pnlMain = new JPanel();
        //frame = new JFrame("Student Academic Information");


    }

    public void designComponents() {
    }

    public void setCharacterLimits() {
    }

    public void layoutComponents() {

//        JPanel p = new JPanel();
//        p.setLayout(new MigLayout());
//        //p.add(csi);

        JPanel q = new JPanel();
        q.setLayout(new MigLayout());

        q.add(new JLabel("Previous School"));
        q.add(tfPreviousSchool, "width 120, wrap");

        q.add(new JLabel("Last Class"));
        q.add(tfLastClass, "width 120, wrap");

        q.add(new JLabel("Reason(Leaving)"));
        q.add(tfReasonOfLeaving, "width 120, wrap");

        q.add(new JLabel("Date of Leaving"));
        q.add(tfDateOfLeaving, "width 120, wrap");

        JPanel r = new JPanel();
        r.setLayout(new MigLayout());

        r.add(new JLabel("Grade Admitted"));
        r.add(cmbGradeAdmitted, "width 120,wrap");

        r.add(new JLabel("Admission Date"));
        r.add(tfAdmissionDate, "width 120,wrap");


        pnlMain.setLayout(new MigLayout());
//        pnlMain.add(p, "span2, wrap");
        pnlMain.add(q);
        pnlMain.add(r, "wrap");
//        pnlMain.add(buttonPanel, "span2");



    }

    public void showWindow() {
        //frame.setLayout(new GridBagLayout());
        //frame.add(pnlMain);
        //frame.setLocationRelativeTo(null);
       // frame.setVisible(true);
       // frame.setSize(pnlMain.getSize());
       // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

  
   
}
