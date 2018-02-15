/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.student.services;

import acr.component.CIntegerField;
import acr.component.CTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mysd.DBSystem;
import mysd.StandardFormInterface;
import mysd.Utils;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentContact implements StandardFormInterface{
    protected CIntegerField tfHomePhone, tfMobilePhone, tfOfficePhone, tfEmergencyPhone;
    protected CTextField tfEmailID;
    protected JPanel pnlMain;
    
    public FStudentContact(){
        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();

        //JOptionPane.showMessageDialog(null, pnlMain);


    }

    public void designComponents() {

    }

    public void initComponents() {
        tfHomePhone = new CIntegerField();
        tfMobilePhone = new CIntegerField();
        tfOfficePhone = new CIntegerField();
        tfEmergencyPhone = new CIntegerField();
        tfEmailID = new CTextField();
        pnlMain = new JPanel();
    }

    public void layoutComponents() {
        pnlMain.setLayout(new MigLayout());

        pnlMain.add(new JLabel("Home Ph"));
        pnlMain.add(tfHomePhone,"width 120,wrap");

        pnlMain.add(new JLabel("Mobile Ph"));
        pnlMain.add(tfMobilePhone,"width 120,wrap");

        pnlMain.add(new JLabel("Office Ph"));
        pnlMain.add(tfOfficePhone,"width 120,wrap");

        pnlMain.add(new JLabel("Emergency Ph"));
        pnlMain.add(tfEmergencyPhone,"width 120,wrap");

        pnlMain.add(new JLabel("Email"));
        pnlMain.add(tfEmailID,"width 120,wrap");
    }

    public void setCharacterLimits() {
        tfHomePhone.setCharacter_limit(15);
        tfMobilePhone.setCharacter_limit(15);
        tfOfficePhone.setCharacter_limit(15);
        tfEmergencyPhone.setCharacter_limit(15);
        tfEmailID.setCharacter_limit(50);
    }

    public void setRecord(String studentID){
        String query = "SELECT * FROM STUDENTCONTACT WHERE "
                + "STUDENTID like '"+studentID+"'";
        DBSystem dbs = new DBSystem();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        con = dbs.getConnection();

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                tfHomePhone.setText(rs.getString("HOME_PHONE"));
                tfMobilePhone.setText(rs.getString("MOBILE_PHONE"));
                tfOfficePhone.setText(rs.getString("OFFICE_PHONE"));
                tfEmergencyPhone.setText(rs.getString("EMERGENCY_PHONE"));
                tfEmailID.setText(rs.getString("EMAIL_ID"));
            }

        }catch(Exception e){
            Utils.msg(e.getMessage());
        }
    }


    public String saveRecord(String studentID){

        String stats = "";

        String deleteQuery = "DELETE FROM STUDENTCONTACT WHERE "
                + "STUDENTID LIKE '"+studentID+"'";

        String insertRecord = "INSERT INTO STUDENTCONTACT("
                + "STUDENTID, HOME_PHONE, MOBILE_PHONE, OFFICE_PHONE,"
                + "EMERGENCY_PHONE, EMAIL_ID)VALUES("
                + "'"+studentID+"',"
                + "'"+tfHomePhone.getText()+"',"
                + "'"+tfMobilePhone.getText()+"',"
                + "'"+tfOfficePhone.getText()+"',"
                + "'"+tfEmergencyPhone.getText()+"',"
                + "'"+tfEmailID.getText()+"')";

        DBSystem dbs = new DBSystem();
        Connection con = dbs.getConnection();
        Statement stmt = null;

        try{
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(deleteQuery);
            stmt.executeUpdate(insertRecord);
            con.commit();
            stats = "ok";
            con.setAutoCommit(true);
            dbs.closeConnection(con);
        }
        catch(Exception e)
        {
            try
            {
                con.rollback();
                con.setAutoCommit(true);
            }
            catch(Exception ae)
            {

            }

            stats = e.getMessage();

            dbs.closeConnection(con);
        }

        return stats;

    }


    

    public static void main(String[] args){
        new FStudentContact();
    }



}
