/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import acr.component.CDateField;
import acr.component.CTextField;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysd.CCMBGrade;
import mysd.CStandardButtonPanel;
import mysd.GeneralDB;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentAcademic implements StandardFormInterface {

    protected CTextField tfPreviousSchool, tfLastClass, tfReasonOfLeaving;
    protected CDateField tfDateOfLeaving, tfAdmissionDate;
    protected CCMBGrade cmbGradeAdmitted;
    protected CStandardButtonPanel buttonPanel;
    protected JPanel pnlMain;
    
    public FStudentAcademic() {


        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();

        //JOptionPane.showMessageDialog(null, pnlMain);


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

    public void setRecord(String studentID){
        String query = "SELECT "
                + " PREVIOUS_SCHOOL,"
                + "LAST_CLASS, REASON_OF_LEAVING, "
                + "DATE_OF_LEAVING, CLASS_ADMITTED,"
                + "ADMISSION_DATE FROM STUDENTACADEMIC WHERE "
                + "STUDENTID like '"+studentID+"'";

        Vector v = GeneralDB.getSingleRow(query);

        if(v == null){

        }else{
            tfPreviousSchool.setText((String)v.get(0));
            tfLastClass.setText((String)v.get(1));
            tfReasonOfLeaving.setText((String)v.get(2));
            tfDateOfLeaving.setNormalDate((String)v.get(3));
            cmbGradeAdmitted.setSelectedItem((String)v.get(4));
            tfAdmissionDate.setNormalDate((String)v.get(5));
        }

    }

    public String saveRecord(String studentID){
        String stats = "";

        String query = "REPLACE INTO STUDENTACADEMIC("
                + "STUDENTID, PREVIOUS_SCHOOL,"
                + "LAST_CLASS, REASON_OF_LEAVING, "
                + "DATE_OF_LEAVING, CLASS_ADMITTED,"
                + "ADMISSION_DATE)VALUES("
                + "'"+studentID+"',"
                + "'"+tfPreviousSchool.getText()+"',"
                + "'"+tfLastClass.getText()+"',"
                + "'"+tfReasonOfLeaving.getText()+"',"
                + "'"+tfDateOfLeaving.getSQLDate()+"',"
                + "'"+cmbGradeAdmitted.getSelectedItem()+"',"
                + "'"+tfAdmissionDate.getSQLDate()+"')";

        GeneralDB gdb = new GeneralDB();
        stats = gdb.execute(query);

        return stats;
    }

    public void showWindow() {
        //frame.setLayout(new GridBagLayout());
        //frame.add(pnlMain);
        //frame.setLocationRelativeTo(null);
       // frame.setVisible(true);
       // frame.setSize(pnlMain.getSize());
       // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

  
    public static void main(String[] args) {
        new FStudentAcademic();
    }
}
