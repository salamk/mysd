/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.attendence;

import acr.component.CAlphaNumericField;
import acr.component.CDateField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysd.CCMBAttendenceState;
import mysd.CCMBClassRoom;
import mysd.CCMBGrade;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FAttendence implements StandardFormInterface{

    protected CAlphaNumericField tfStudentID;
    protected CCMBGrade cmbGrade;
    protected CCMBClassRoom cmbClassRoom;
    protected CDateField tfAttendenceDate;
    protected CCMBAttendenceState cmbAttendenceState;
    protected JPanel pnlMain;

    public FAttendence(){
        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();

    }

    public void designComponents() {
        
    }

    public void initComponents() {
        tfStudentID = new CAlphaNumericField();
        cmbGrade = new CCMBGrade();
        cmbClassRoom = new CCMBClassRoom();
        tfAttendenceDate = new CDateField();
        cmbAttendenceState = new CCMBAttendenceState();
        pnlMain = new JPanel();
        
    }

    public void layoutComponents() {
        pnlMain.setLayout(new MigLayout());

        pnlMain.add(new JLabel("Attendence State"));
        pnlMain.add(cmbAttendenceState, "width 150, wrap");

        pnlMain.add(new JLabel("Student ID"));
        pnlMain.add(tfStudentID, "width 150, wrap");

        pnlMain.add(new JLabel("Grade/Class"));
        pnlMain.add(cmbGrade, "width 150, wrap");

        pnlMain.add(new JLabel("Room ID"));
        pnlMain.add(cmbClassRoom, "width 150, wrap");


        pnlMain.add(new JLabel("Date"));
        pnlMain.add(tfAttendenceDate, "width 150, wrap");

    }

    public void setCharacterLimits() {
        
    }

    public static void main(String[] args){
        new FAttendence();
    }



}
