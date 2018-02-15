/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import acr.component.CDateField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mysd.CCMBBuilding;
import mysd.CCMBClassRoom;
import mysd.CCMBEnrollRemarks;
import mysd.CCMBEnrollStatus;
import mysd.CCMBGrade;
import mysd.GeneralDB;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FCurrentEnrollment implements StandardFormInterface {

    protected CCMBBuilding cmbBuilding;
    protected CCMBClassRoom cmbClassRoom;
    protected CCMBGrade cmbGrade;
    protected CCMBEnrollRemarks cmbEnrollRemarks;
    protected CCMBEnrollStatus cmbEnrollStatus;
    protected CDateField tfEnrollDate;
    protected JPanel pnlMain;

    public FCurrentEnrollment() {
        initComponents();
        designComponents();
        layoutComponents();
        cmbBuilding.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                String campusID = cmbBuilding.getBuildingID();
                fetchCampusClasses(campusID);
            }
        });

        String campusID = cmbBuilding.getBuildingID();
        fetchCampusClasses(campusID);

        //JOptionPane.showMessageDialog(null,pnlMain);
    }

    public void designComponents() {
        tfEnrollDate.setEnabled(false);
    }

    public void initComponents() {
        cmbBuilding = new CCMBBuilding();
        cmbClassRoom = new CCMBClassRoom();
        cmbGrade = new CCMBGrade();
        cmbEnrollRemarks = new CCMBEnrollRemarks();
        cmbEnrollStatus = new CCMBEnrollStatus();
        tfEnrollDate = new CDateField();
        pnlMain = new JPanel();
    }

    public void layoutComponents() {
        pnlMain.setLayout(new MigLayout());

        pnlMain.add(new JLabel("Campus ID"));
        pnlMain.add(cmbBuilding, "gapleft 25,width 150, wrap");

        pnlMain.add(new JLabel("Class Room ID"));
        pnlMain.add(cmbClassRoom, "gapleft 25,width 150, wrap");

        pnlMain.add(new JLabel("Grade/Class"));
        pnlMain.add(cmbGrade, "gapleft 25,width 150, wrap");

        pnlMain.add(new JLabel("Enrolled Per"));
        pnlMain.add(cmbEnrollRemarks, "gapleft 25,width 150, wrap");

        pnlMain.add(new JLabel("Enroll Status"));
        pnlMain.add(cmbEnrollStatus, "gapleft 25,width 150, wrap");

        pnlMain.add(new JLabel("Enroll Date"));
        pnlMain.add(tfEnrollDate, "gapleft 25,width 150, wrap");

    }

    public void setCharacterLimits() {
    }

    public void setRecord(String studentID) {
        String query = "SELECT BUILDINGID, CLASSROOMID, GRADEID,"
                + "ENROLLDATE, REMARKS, CSTATUS FROM CURRENTENROLLMENT "
                + "WHERE STUDENTID LIKE '" + studentID + "'";

        Vector v = GeneralDB.getSingleRow(query);

        if (v == null) {
        } else {
            cmbBuilding.setSelectedBuilding((String) v.get(0));
            cmbClassRoom.setSelectedItem((String) v.get(1));
            cmbGrade.setSelectedItem((String) v.get(2));
            tfEnrollDate.setNormalDate((String) v.get(3));
            cmbEnrollRemarks.setSelectedItem((String) v.get(4));
            cmbEnrollStatus.setSelectedItem((String) v.get(5));
        }
    }

    public String saveRecord(String studentID) {
        GeneralDB gdb = new GeneralDB();

        String queryM = "REPLACE INTO CURRENTENROLLMENT("
                + "STUDENTID, BUILDINGID, CLASSROOMID, GRADEID,"
                + "ENROLLDATE, REMARKS, CSTATUS, USERID, TRANSACTION_TIME)"
                + "VALUES("
                + "'" + studentID + "',"
                + "'" + cmbBuilding.getBuildingID() + "',"
                + "'" + cmbClassRoom.getSelectedItem() + "',"
                + "'" + cmbGrade.getSelectedItem() + "',"
                + "'" + tfEnrollDate.getSQLDate() + "',"
                + "'" + cmbEnrollRemarks.getSelectedItem() + "',"
                + "'" + cmbEnrollStatus.getSelectedItem() + "',"
                + "'" + System.getProperty("LOGIN_USER_ID") + "',"
                + "'" + gdb.getTimeStamp() + "'"
                + ")";

        String queryH = "INSERT INTO CURRENTENROLLMENTHISTORY("
                + "STUDENTID, BUILDINGID, CLASSROOMID, GRADEID,"
                + "ENROLLDATE, REMARKS, CSTATUS, USERID, TRANSACTION_TIME)"
                + "VALUES("
                + "'" + studentID + "',"
                + "'" + cmbBuilding.getBuildingID() + "',"
                + "'" + cmbClassRoom.getSelectedItem() + "',"
                + "'" + cmbGrade.getSelectedItem() + "',"
                + "'" + tfEnrollDate.getSQLDate() + "',"
                + "'" + cmbEnrollRemarks.getSelectedItem() + "',"
                + "'" + cmbEnrollStatus.getSelectedItem() + "',"
                + "'" + System.getProperty("LOGIN_USER_ID") + "',"
                + "'" + gdb.getTimeStamp() + "'"
                + ")";

        String stats = gdb.execute(queryM);

        if (stats.compareToIgnoreCase("ok") == 0) {
            gdb.execute(queryH);
        }

        return stats;

    }

    public void fetchCampusClasses(String campusID) {
//        this.cmbClassRoom.removeAllItems();
//        String query = "SELECT CLASSROOM_ID FROM CLASSROOM WHERE "
//                + "BUILDING_ID LIKE '" + campusID + "'";
//        Vector v = GeneralDB.getSingleRow(query);
//
//        if (v != null) {
//            for (int i = 0; i <= v.size() - 1; i++) {
//                cmbClassRoom.addItem((String) v.get(0));
//            }
//        }

    }

    public static void main(String[] args) {
        new FCurrentEnrollment();
    }
}
