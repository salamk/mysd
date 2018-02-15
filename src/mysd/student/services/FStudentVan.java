/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import acr.component.CTextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mysd.CCMBVanID;
import mysd.GeneralDB;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentVan implements StandardFormInterface {

    protected CCMBVanID cmbVanID;
    protected CTextField tfVanNo, tfDriverName, tfLicenseNo, tfContactNo;
    protected JPanel pnlMain;

    public FStudentVan() {
        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();
        setVanInfo((String) cmbVanID.getSelectedItem());

    }

    public void designComponents() {
    }

    public void initComponents() {
        cmbVanID = new CCMBVanID();
        cmbVanID.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                setVanInfo((String) cmbVanID.getSelectedItem());
            }
        });

        tfVanNo = new CTextField();
        tfDriverName = new CTextField();
        tfLicenseNo = new CTextField();
        tfContactNo = new CTextField();

        tfVanNo.setEnabled(false);
        tfDriverName.setEnabled(false);
        tfLicenseNo.setEnabled(false);
        tfContactNo.setEnabled(false);

        pnlMain = new JPanel();
    }

    public void layoutComponents() {
        pnlMain.setLayout(new MigLayout());

        pnlMain.add(new JLabel("Van ID"));
        pnlMain.add(cmbVanID, "width 150,wrap");

        pnlMain.add(new JLabel("Driver Name"));
        pnlMain.add(tfDriverName, "width 150,wrap");

        pnlMain.add(new JLabel("License No"));
        pnlMain.add(tfLicenseNo, "width 150,wrap");

        pnlMain.add(new JLabel("Vhicle No"));
        pnlMain.add(tfVanNo, "width 150,wrap");

        pnlMain.add(new JLabel("Contact #"));
        pnlMain.add(tfContactNo, "width 150,wrap");
    }

    public void setCharacterLimits() {
    }

    public static void main(String[] args) {
        new FStudentVan();
    }

    public void setRecord(String studentID) {
        String query = "SELECT VANID FROM STUDENTVAN WHERE "
                + "STUDENTID like '" + studentID + "'";
        Vector v = GeneralDB.getSingleRow(query);
        if (v == null) {
        } else {
            cmbVanID.setSelectedItem((String) v.get(0));
        }

        query = "SELECT VANNO, DRIVERNAME, LICENSE_NO, CONTACT_NO "
                + "FROM SCHOOLVAN WHERE VANID "
                + "LIKE '" + cmbVanID.getSelectedItem() + "'";

        v = GeneralDB.getSingleRow(query);
        if (v == null) {
        } else {
            tfVanNo.setText((String) v.get(0));
            tfDriverName.setText((String) v.get(1));
            tfLicenseNo.setText((String) v.get(2));
            tfContactNo.setText((String) v.get(3));
        }

    }

    public void setVanInfo(String vanID) {

        String query = "SELECT VANNO, DRIVERNAME, LICENSE_NO, CONTACT_NO "
                + "FROM SCHOOLVAN WHERE VANID "
                + "LIKE '" + vanID + "'";

        Vector v = GeneralDB.getSingleRow(query);

        if (v == null) {
        } else {

            tfVanNo.setText((String) v.get(0));
            tfDriverName.setText((String) v.get(1));
            tfLicenseNo.setText((String) v.get(2));
            tfContactNo.setText((String) v.get(3));
        }

    }

    public String saveRecord(String studentID) {

        String stats = "ok";
        String query = "REPLACE INTO STUDENTVAN (STUDENTID, VANID)"
                + "VALUES("
                + "'" + studentID + "',"
                + "'" + cmbVanID.getSelectedItem() + "'"
                + ")";

        GeneralDB gdb = new GeneralDB();
        stats = gdb.execute(query);

        return stats;
    }
}
