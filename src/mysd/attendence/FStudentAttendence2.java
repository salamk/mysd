/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.attendence;

import acr.component.CAlphaNumericField;
import acr.component.CDateField;
import acr.component.CIntegerField;
import acr.component.CTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentAttendence2 implements StandardFormInterface{
    private CAlphaNumericField tfStudentID;
    private CDateField tfDateFrom, tfDateTo;
    private CTextField tfStudentName, tfFatherName, tfDateOfBirth,
            tfGrade, tfRoomNo;

    private JEditorPane taAttendenceRecord;
    private CIntegerField tfTotalWorkingDays, tfTotalDaysPresent, tfTotalDaysNotPresent;
    private JButton btnGet, btnBuildReport;
    private JPanel pnlMain;

    public FStudentAttendence2(){
        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();
    }

    public void designComponents() {

    }

    public void initComponents() {
        tfStudentID = new CAlphaNumericField();
        tfDateFrom = new CDateField();
        tfDateTo = new CDateField();
        tfStudentName = new CTextField();
        tfFatherName = new CTextField();
        tfDateOfBirth = new CTextField();
        tfGrade = new CTextField();
        tfRoomNo = new CTextField();
        taAttendenceRecord = new JEditorPane();
        taAttendenceRecord.setContentType("text/html");
        tfTotalWorkingDays = new CIntegerField();
        tfTotalDaysPresent = new CIntegerField();
        tfTotalDaysNotPresent = new CIntegerField();
        btnBuildReport = new JButton("Build Report");
        btnGet = new JButton("Get");
        pnlMain = new JPanel();
    }

    public void layoutComponents() {

        //pnl A is the top most left side panel
        JPanel a = new JPanel();
        a.setLayout(new MigLayout());

        a.add(new JLabel("Student ID"));
        a.add(tfStudentID, "width 120, wrap");

        a.add(new JLabel("Date From"));
        a.add(tfDateFrom, "width 120, wrap");

        a.add(new JLabel("Date To"));
        a.add(tfDateTo, "width 120, wrap");

        a.add(new JLabel(""));
        a.add(btnGet, "width 50, wrap");

        //pnl B is the top most right side panel
        JPanel b = new JPanel();

    }

    public void setCharacterLimits() {
    
    }



}
