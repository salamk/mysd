/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import acr.component.CTextField;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mysd.GeneralDB;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentAddress implements StandardFormInterface {

    protected CTextField tfHouseNo, tfStreet, tfBlock, tfSector, tfLocality,
            tfTown, tfOtherInfo, tfDistrict;
    protected JPanel pnlMain;

    public FStudentAddress() {
        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();
        //JOptionPane.showMessageDialog(null, pnlMain);

    }

    public void designComponents() {
    }

    public void initComponents() {
        tfHouseNo = new CTextField();
        tfStreet = new CTextField();
        tfBlock = new CTextField();
        tfSector = new CTextField();
        tfLocality = new CTextField();
        tfTown = new CTextField();
        tfOtherInfo = new CTextField();
        tfDistrict = new CTextField();
        pnlMain = new JPanel();
    }

    public void layoutComponents() {
        pnlMain.setLayout(new MigLayout());
        pnlMain.add(new JLabel("House No"));
        pnlMain.add(tfHouseNo,"width 120");
        pnlMain.add(new JLabel("Street"));
        pnlMain.add(tfStreet, "width 120,wrap");

        pnlMain.add(new JLabel("Block"));
        pnlMain.add(tfBlock,"width 120");
        pnlMain.add(new JLabel("Sector"));
        pnlMain.add(tfSector, "width 120,wrap");

        pnlMain.add(new JLabel("Locality"));
        pnlMain.add(tfLocality,"width 120");
        pnlMain.add(new JLabel("Town"));
        pnlMain.add(tfTown, "width 120,wrap");

        pnlMain.add(new JLabel("Other Inf"));
        pnlMain.add(tfOtherInfo,"width 120");
        pnlMain.add(new JLabel("District"));
        pnlMain.add(tfDistrict,"width 120, wrap");
    }

    public void setCharacterLimits() {
        tfHouseNo.setCharacter_limit(15);
        tfStreet.setCharacter_limit(50);
        tfBlock.setCharacter_limit(10);
        tfSector.setCharacter_limit(10);
        tfLocality.setCharacter_limit(50);
        tfTown.setCharacter_limit(50);
        tfOtherInfo.setCharacter_limit(50);
        tfDistrict.setCharacter_limit(50);
    }

     public String validateRecord(){
        String str = "ok";
        return str;
    }

     public void setRecord(String studentID){
         
         String query = "SELECT HOUSENO, STREET, "
                + "BLOCK, SECTOR, LOCALITY, TOWN, "
                + "OTHERINFO, DISTRICT FROM STUDENTADDRESS WHERE "
                + "STUDENTID like '"+studentID+"'";

         GeneralDB gdb = new GeneralDB();
        Vector v = gdb.getSingleRow(query);
        if(v == null){
            ;
        }else{

            tfHouseNo.setText((String)v.get(0));
            tfStreet.setText((String)v.get(1));
            tfBlock.setText((String)v.get(2));
            tfSector.setText((String)v.get(3));
            tfLocality.setText((String)v.get(4));
            tfTown.setText((String)v.get(5));
            tfOtherInfo.setText((String)v.get(6));
            tfDistrict.setText((String)v.get(7));

        }

     }

    public String saveRecord(String studentID){
        String query = "INSERT INTO STUDENTADDRESS("
                + "STUDENTID, HOUSENO, STREET, BLOCK, SECTOR,"
                + "LOCALITY, TOWN, OTHERINFO, DISTRICT)VALUES("
                + "'"+studentID+"',"
                + "'"+tfHouseNo.getText()+"',"
                + "'"+tfStreet.getText()+"',"
                + "'"+tfBlock.getText()+"',"
                + "'"+tfSector.getText()+"',"
                + "'"+tfLocality.getText()+"',"
                + "'"+tfTown.getText()+"',"
                + "'"+tfOtherInfo.getText()+"',"
                + "'"+tfDistrict.getText()+"')";

        GeneralDB gdb = new GeneralDB();
        String stats = gdb.execute(query);
        return stats;
    }

    public String updateRecord(String studentID){
        String query = "REPLACE INTO STUDENTADDRESS("
                + "STUDENTID, HOUSENO, STREET, BLOCK, SECTOR,"
                + "LOCALITY, TOWN, OTHERINFO, DISTRICT)VALUES("
                + "'"+studentID+"',"
                + "'"+tfHouseNo.getText()+"',"
                + "'"+tfStreet.getText()+"',"
                + "'"+tfBlock.getText()+"',"
                + "'"+tfSector.getText()+"',"
                + "'"+tfLocality.getText()+"',"
                + "'"+tfTown.getText()+"',"
                + "'"+tfOtherInfo.getText()+"',"
                + "'"+tfDistrict.getText()+"')";

        GeneralDB gdb = new GeneralDB();
        String stats = gdb.execute(query);
        return stats;
    }






    public static void main(String[] args){
        new FStudentAddress();
    }
}
