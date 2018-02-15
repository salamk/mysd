/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.student.services;

import acr.component.CIntegerField;
import acr.component.CTextField;
import acr.component.CYesNoField;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysd.DBSystem;
import mysd.GeneralDB;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentHealth implements StandardFormInterface {
    protected CIntegerField tfWeight, tfHeight, tfAge, tfBMI;
    protected JComboBox cmbBloodGroup, cmbSkinColor, cmbEyeColor,
            cmbStature, cmbDisability, cmbMentality, cmbIq;
    
    protected CTextField tfAllergies;
    protected CYesNoField tfVhpt, tfVpolio, tfVdtp, tfVmmr;
    protected JPanel pnlMain;


    public FStudentHealth(){
         initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();
        //JOptionPane.showMessageDialog(null, pnlMain);

    }

    public void designComponents() {
    }

    public void initComponents() {
        tfWeight = new CIntegerField();
        tfHeight = new CIntegerField();
        tfAge = new CIntegerField();
        tfBMI = new CIntegerField();

        cmbBloodGroup = new JComboBox();
        cmbBloodGroup.addItem("A+");
        cmbBloodGroup.addItem("A-");
        cmbBloodGroup.addItem("AB+");
        cmbBloodGroup.addItem("AB-");
        cmbBloodGroup.addItem("B+");
        cmbBloodGroup.addItem("B-");
        cmbBloodGroup.addItem("O+");
        cmbBloodGroup.addItem("O-");
        
        cmbSkinColor = new JComboBox();
        cmbSkinColor.addItem("White");
        cmbSkinColor.addItem("Grey");
        cmbSkinColor.addItem("Reddish");
        cmbSkinColor.addItem("Pale");
        cmbSkinColor.addItem("Other");
        
        cmbEyeColor = new JComboBox();
        cmbEyeColor.addItem("Black");
        cmbEyeColor.addItem("Grey");
        cmbEyeColor.addItem("Brown");
        cmbEyeColor.addItem("Green");
        cmbEyeColor.addItem("Blue");
        cmbEyeColor.addItem("Crystal");
        cmbEyeColor.addItem("Other");

        
        cmbStature = new JComboBox();
        cmbStature.addItem("Athelitic");
        cmbStature.addItem("Strong");
        cmbStature.addItem("Weak");
        cmbStature.addItem("Thin");
        cmbStature.addItem("Fat");
        
        cmbDisability = new JComboBox();
        cmbDisability.addItem("No Disability");
        cmbDisability.addItem("Lame");
        cmbDisability.addItem("Deaf");
        cmbDisability.addItem("Dumb");
        cmbDisability.addItem("Blind");
        cmbDisability.addItem("Deaf & Blind");
        cmbDisability.addItem("Deaf & Dumb");
        cmbDisability.addItem("Other");

        cmbMentality = new JComboBox();
        cmbMentality.addItem("Normal");
        cmbMentality.addItem("Extra Normal");
        cmbMentality.addItem("Controlled");
        cmbMentality.addItem("Abnormal");
        cmbMentality.addItem("Retard");

        cmbIq = new JComboBox();
        cmbIq.addItem("Fair");
        cmbIq.addItem("Good");
        cmbIq.addItem("Better");
        cmbIq.addItem("Best");
        cmbIq.addItem("Low");
        cmbIq.addItem("Poor");

        
        tfAllergies = new CTextField();

        tfVhpt = new CYesNoField();
        tfVpolio = new CYesNoField();
        tfVdtp = new CYesNoField();
        tfVmmr = new CYesNoField();

        pnlMain = new JPanel();
    }

    public void layoutComponents() {

        JPanel p = new JPanel();
        p.setLayout(new MigLayout());
        p.setBorder(BorderFactory.createTitledBorder("General Physique"));

        p.add(new JLabel("Weight"));
        p.add(tfWeight,"width 120");
        p.add(new JLabel("Height"));
        p.add(tfHeight,"width 120,wrap");

        p.add(new JLabel("Age"));
        p.add(tfAge,"width 120");
        p.add(new JLabel("BMI"));
        p.add(tfBMI,"width 120,wrap");

        JPanel q = new JPanel();
        q.setLayout(new MigLayout());
        q.setBorder(BorderFactory.createTitledBorder("Allergies"));

        q.add(new JLabel("Allergies"));
        q.add(tfAllergies,"width 300");

        JPanel r = new JPanel();
        r.setLayout(new MigLayout());
        r.setBorder(BorderFactory.createTitledBorder("Attributes"));

        r.add(new JLabel("Blood Group"));
        r.add(cmbBloodGroup,"width 120");
        r.add(new JLabel("Skin Color"));
        r.add(cmbSkinColor,"width 120,wrap");

        r.add(new JLabel("Eye Color"));
        r.add(cmbEyeColor,"width 120");
        r.add(new JLabel("Stature"));
        r.add(cmbStature,"width 120,wrap");

        

        r.add(new JLabel("Mentality"));
        r.add(cmbMentality,"width 120");
        r.add(new JLabel("IQ"));
        r.add(cmbIq,"width 120,wrap");
        
        r.add(new JLabel("Disability"));
        r.add(cmbDisability,"width 120");

        JPanel s = new JPanel();
        s.setLayout(new MigLayout());
        s.setBorder(BorderFactory.createTitledBorder("Vaccination"));

        s.add(new JLabel("Hepatitus"));
        s.add(tfVhpt,"width 120");
        s.add(new JLabel("Polio"));
        s.add(tfVpolio,"width 120,wrap");

        s.add(new JLabel("DTP"));
        s.add(tfVdtp,"width 120");
        s.add(new JLabel("MMR"));
        s.add(tfVmmr,"width 120,wrap");

        pnlMain.setLayout(new MigLayout());
        pnlMain.add(p,"width 400, wrap");
        pnlMain.add(s,"gaptop 20,width 450, wrap");
        pnlMain.add(q,"gaptop 20,width 450, wrap");
        pnlMain.add(r,"gaptop 20,width 450, wrap");

    }

    public void setCharacterLimits() {
        tfWeight.setCharacter_limit(4);
        tfHeight.setCharacter_limit(4);
        tfAge.setCharacter_limit(2);
        tfBMI.setCharacter_limit(4);
    }

    public static void main(String[] args){
        new FStudentHealth();
    }

    public void setRecord(String studentID){
        
        String query = "SELECT WEIGHT, HEIGHT, AGE, BMI, "
                + "BLOODGROUP, SKINCOLOR, EYECOLOR, STATURE, ALLERGIES,"
                + "VHPT, VPOLIO, VDTP, VMMR, DISABILITY, MENTALITY,"
                + "IQ FROM STUDENTHEALTH WHERE STUDENTID LIKE '"+studentID+"'";

        GeneralDB gdb = new GeneralDB();
        Vector v = gdb.getSingleRow(query);

        if(v == null){

        }else{
            
            tfWeight.setText((String)v.get(0));
            tfHeight.setText((String)v.get(1));
            tfAge.setText((String)v.get(2));
            tfBMI.setText((String)v.get(3));
            cmbBloodGroup.setSelectedItem((String)v.get(4));
            cmbSkinColor.setSelectedItem((String)v.get(5));
            cmbEyeColor.setSelectedItem((String)v.get(6));
            cmbStature.setSelectedItem((String)v.get(7));
            tfAllergies.setText((String)v.get(8));
            tfVhpt.setText((String)v.get(9));
            tfVpolio.setText((String)v.get(10));
            tfVdtp.setText((String)v.get(11));
            tfVmmr.setText((String)v.get(12));
            cmbDisability.setSelectedItem((String)v.get(13));
            cmbMentality.setSelectedItem((String)v.get(14));
            cmbIq.setSelectedItem((String)v.get(15));
            
        }
        
    }


    public String saveRecord(String studentID){

        String stats = "";
        GeneralDB gdb = new GeneralDB();
        DBSystem dbs = new DBSystem();
        
        String mQuery = "REPLACE INTO STUDENTHEALTH("
                + "STUDENTID, WEIGHT, HEIGHT, AGE, BMI, BLOODGROUP,"
                + "SKINCOLOR, EYECOLOR, STATURE, ALLERGIES, VHPT,"
                + "VPOLIO, VDTP, VMMR, DISABILITY, MENTALITY, IQ,"
                + "TESTDATE)VALUES("
                + "'"+studentID+"',"
                + "'"+tfWeight.getText()+"',"
                + "'"+tfHeight.getText()+"',"
                + "'"+tfAge.getText()+"',"
                + "'"+tfBMI.getText()+"',"
                + "'"+cmbBloodGroup.getSelectedItem()+"',"
                + "'"+cmbSkinColor.getSelectedItem()+"',"
                + "'"+cmbEyeColor.getSelectedItem()+"',"
                + "'"+cmbStature.getSelectedItem()+"',"
                + "'"+tfAllergies.getText()+"',"
                + "'"+tfVhpt.getText()+"',"
                + "'"+tfVpolio.getText()+"',"
                + "'"+tfVdtp.getText()+"',"
                + "'"+tfVmmr.getText()+"',"
                + "'"+cmbDisability.getSelectedItem()+"',"
                + "'"+cmbMentality.getSelectedItem()+"',"
                + "'"+cmbIq.getSelectedItem()+"',"
                + "'"+gdb.getCurrentDate()+"')";
        
        String hQuery = "INSERT INTO STUDENTHEALTH_HISTORY("
                + "STUDENTID, WEIGHT, HEIGHT, AGE, BMI, BLOODGROUP,"
                + "SKINCOLOR, EYECOLOR, STATURE, ALLERGIES, VHPT,"
                + "VPOLIO, VDTP, VMMR, DISABILITY, MENTALITY, IQ, "
                + "TESTDATE)VALUES("
                + "'"+studentID+"',"
                + "'"+tfWeight.getText()+"',"
                + "'"+tfHeight.getText()+"',"
                + "'"+tfAge.getText()+"',"
                + "'"+tfBMI.getText()+"',"
                + "'"+cmbBloodGroup.getSelectedItem()+"',"
                + "'"+cmbSkinColor.getSelectedItem()+"',"
                + "'"+cmbEyeColor.getSelectedItem()+"',"
                + "'"+cmbStature.getSelectedItem()+"',"
                + "'"+tfAllergies.getText()+"',"
                + "'"+tfVhpt.getText()+"',"
                + "'"+tfVpolio.getText()+"',"
                + "'"+tfVdtp.getText()+"',"
                + "'"+tfVmmr.getText()+"',"
                + "'"+cmbDisability.getSelectedItem()+"',"
                + "'"+cmbMentality.getSelectedItem()+"',"
                + "'"+cmbIq.getSelectedItem()+"',"
                + "'"+gdb.getCurrentDate()+"')";

        Connection con = dbs.getConnection();
        Statement stmt = null;

        try{
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(mQuery);
            stmt.executeUpdate(hQuery);
            con.commit();
            stats = "ok";
            con.setAutoCommit(true);
            dbs.closeConnection(con);

        }catch(Exception e){
            try{
                con.rollback();
                con.setAutoCommit(true);
                dbs.closeConnection(con);
            }catch(Exception ae){
                
            }

            stats = e.getMessage();
        }

        return stats;
    }



}
