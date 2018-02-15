/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import acr.component.CAlphaField;
import acr.component.CAlphaNumericField;
import acr.component.CDateField;
import acr.component.CGenderField;
import acr.component.CNICField;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysd.GeneralDB;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudent implements StandardFormInterface {

    protected CAlphaField tfFirstName, tfLastName, tfFullName, tfFatherName,
            tfMotherName, tfGuardianName, tfFirstName_, tfLastName_,
            tfFullName_, tfFatherName_, tfMotherName_, tfGuardianName_;
    protected CGenderField tfGender, tfGender_;
    protected CDateField tfDateOfBirth, tfDateOfBirth_;
    protected CNICField tfFatherNIC, tfMotherNIC, tfGuardianNIC,
            tfFatherNIC_, tfMotherNIC_, tfGuardianNIC_;
    protected CAlphaNumericField tfCRCNo, tfCRCNo_;
    protected JPanel pnlMain;
    //protected CStandardButtonPanel buttonPanel;
    //protected JFrame frame;
    // private int mode = CStandardButtonPanel.VIEWMODE;

    public FStudent() {
        initComponents();
        setCharacterLimits();
        layoutComponents();
         //JOptionPane.showMessageDialog(null, pnlMain);
        //setOperations();
        //showWindow();
    }

    public void designComponents() {
    }

    public void initComponents() {

        tfFirstName = new CAlphaField();
        tfLastName = new CAlphaField();
        tfFullName = new CAlphaField();
        tfFatherName = new CAlphaField();
        tfMotherName = new CAlphaField();
        tfGuardianName = new CAlphaField();

        tfFirstName_ = new CAlphaField();
        tfLastName_ = new CAlphaField();
        tfFullName_ = new CAlphaField();
        tfFatherName_ = new CAlphaField();
        tfMotherName_ = new CAlphaField();
        tfGuardianName_ = new CAlphaField();

        tfGender = new CGenderField();
        tfGender_ = new CGenderField();

        tfDateOfBirth = new CDateField();
        tfDateOfBirth_ = new CDateField();

        tfFatherNIC = new CNICField();
        tfMotherNIC = new CNICField();
        tfGuardianNIC = new CNICField();

        tfFatherNIC_ = new CNICField();
        tfMotherNIC_ = new CNICField();
        tfGuardianNIC_ = new CNICField();

        tfCRCNo = new CAlphaNumericField();
        tfCRCNo_ = new CAlphaNumericField();

        //buttonPanel = new CStandardButtonPanel(mode);
        pnlMain = new JPanel();
        //frame = new JFrame("Student Basin Info");

    }

    public void setCharacterLimits() {
        int nameLength = 50;
        int crcLength = 20;

        tfFirstName.setCharacter_limit(nameLength);
        tfFirstName_.setCharacter_limit(nameLength);

        tfLastName.setCharacter_limit(nameLength);
        tfLastName_.setCharacter_limit(nameLength);

        tfFullName.setCharacter_limit(nameLength);
        tfFullName_.setCharacter_limit(nameLength);

        tfFatherName.setCharacter_limit(nameLength);
        tfFatherName_.setCharacter_limit(nameLength);

        tfMotherName.setCharacter_limit(nameLength);
        tfMotherName_.setCharacter_limit(nameLength);

        tfGuardianName.setCharacter_limit(nameLength);
        tfGuardianName_.setCharacter_limit(nameLength);

        tfCRCNo.setCharacter_limit(crcLength);
        tfCRCNo_.setCharacter_limit(crcLength);
    }

    public void layoutComponents() {


        pnlMain.setLayout(new MigLayout());

        pnlMain.add(new JLabel("First Name"));
        pnlMain.add(tfFirstName, "width 175, height 30");
        pnlMain.add(tfFirstName_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Last Name"));
        pnlMain.add(tfLastName, "width 175, height 30");
        pnlMain.add(tfLastName_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Full Name"));
        pnlMain.add(tfFullName, "width 175, height 30");
        pnlMain.add(tfFullName_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Date of Birth"));
        pnlMain.add(tfDateOfBirth, "width 175, height 30");
        pnlMain.add(tfDateOfBirth_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Gender"));
        pnlMain.add(tfGender, "width 175, height 30");
        pnlMain.add(tfGender_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("CRC/CBC #"));
        pnlMain.add(tfCRCNo, "width 175, height 30");
        pnlMain.add(tfCRCNo_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel(""), "gaptop 20, span 3, wrap");

        pnlMain.add(new JLabel("Father Name"));
        pnlMain.add(tfFatherName, "width 175, height 30");
        pnlMain.add(tfFatherName_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Father CNIC"));
        pnlMain.add(tfFatherNIC, "width 175, height 30");
        pnlMain.add(tfFatherNIC_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Mother Name"));
        pnlMain.add(tfMotherName, "width 175, height 30");
        pnlMain.add(tfMotherName_, "width 175, height 30 ,wrap");

        pnlMain.add(new JLabel("Mother CNIC"));
        pnlMain.add(tfMotherNIC, "width 175, height 30");
        pnlMain.add(tfMotherNIC_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Guardian Name"));
        pnlMain.add(tfGuardianName, "width 175, height 30");
        pnlMain.add(tfGuardianName_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel("Guardian CNIC"));
        pnlMain.add(tfGuardianNIC, "width 175, height 30");
        pnlMain.add(tfGuardianNIC_, "width 175, height 30, wrap");

        pnlMain.add(new JLabel(""), "gaptop 20, span 3, wrap");
        //pnlMain.add(buttonPanel, "span 3, growx, wrap");

    }

    public String validateRecord() {

        String str = "ok";

        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String fullName = tfFullName.getText();
        String dateOfBirth = tfDateOfBirth.getText();
        String gender = tfGender.getText();
        String crcNo = tfCRCNo.getText();
        String fatherName = tfFatherName.getText();
        String motherName = tfMotherName.getText();
        String fatherNIC = tfFatherNIC.getText();
        String motherNIC = tfMotherNIC.getText();
        String guardianName = tfGuardianName.getText();
        String guardianNIC = tfGuardianNIC.getText();

        String firstName_ = tfFirstName_.getText();
        String lastName_ = tfLastName_.getText();
        String fullName_ = tfFullName_.getText();
        String dateOfBirth_ = tfDateOfBirth_.getText();
        String gender_ = tfGender_.getText();
        String crcNo_ = tfCRCNo_.getText();
        String fatherName_ = tfFatherName_.getText();
        String motherName_ = tfMotherName_.getText();
        String fatherNIC_ = tfFatherNIC_.getText();
        String motherNIC_ = tfMotherNIC_.getText();
        String guardianName_ = tfGuardianName_.getText();
        String guardianNIC_ = tfGuardianNIC_.getText();

        if (firstName.compareToIgnoreCase(firstName_) != 0) {
            str += "Spelling mistake in first name fields\n";
        }
        if (lastName.compareToIgnoreCase(lastName_) != 0) {
            str += "Spelling mistake in last name fields\n";
        }
        if (fullName.compareToIgnoreCase(fullName_) != 0) {
            str += "Spelling mistake in full name fields\n";
        }
        if (fatherName.compareToIgnoreCase(fatherName_) != 0) {
            str += "Spelling mistake in father name fields\n";
        }
        if (motherName.compareToIgnoreCase(motherName_) != 0) {
            str += "Spelling mistake in mother name fields\n";
        }
        if (guardianName.compareToIgnoreCase(guardianName_) != 0) {
            str += "Spelling mistake in guardian name fields\n";
        }
        if (gender.compareToIgnoreCase(gender_) != 0) {
            str += "Spelling mistake in gender fields\n";
        }
        if (crcNo.compareToIgnoreCase(crcNo_) != 0) {
            str += "Spelling mistake in crc No fields\n";
        }
        if (fatherNIC.compareToIgnoreCase(fatherNIC_) != 0) {
            str += "Spelling mistake in father CNIC fields\n";
        }
        if (motherNIC.compareToIgnoreCase(motherNIC_) != 0) {
            str += "Spelling mistake in mother CNIC fields\n";
        }
        if (guardianNIC.compareToIgnoreCase(guardianNIC_) != 0) {
            str += "Spelling mistake in guardian CNIC fields\n";
        }

        return str;
    }

    public void setRecord(String studentID) {
        String query = "SELECT FIRST_NAME, LAST_NAME,"
                + "FULL_NAME, DATE_OF_BIRTH, GENDER, CRCNO, "
                + "FATHER_NAME, FATHER_NIC, MOTHER_NAME, MOTHER_NIC,"
                + "GUARDIAN_NAME, GUARDIAN_NIC FROM STUDENT WHERE "
                + "STUDENT_ID LIKE '" + studentID + "'";
        Vector v = GeneralDB.getSingleRow(query);

        if (v == null) {
        } else {

            tfFirstName.setText((String) v.get(0));
            tfLastName.setText((String) v.get(1));
            tfFullName.setText((String) v.get(2));
            tfDateOfBirth.setNormalDate((String) v.get(3));
            tfGender.setText((String) v.get(4));
            tfCRCNo.setText((String) v.get(5));
            tfFatherName.setText((String) v.get(6));
            tfFatherNIC.setText((String) v.get(7));
            tfMotherName.setText((String) v.get(8));
            tfMotherNIC.setText((String) v.get(9));
            tfGuardianName.setText((String) v.get(10));
            tfGuardianNIC.setText((String) v.get(11));

            tfFirstName_.setText((String) v.get(0));
            tfLastName_.setText((String) v.get(1));
            tfFullName_.setText((String) v.get(2));
            tfDateOfBirth_.setNormalDate((String) v.get(3));
            tfGender_.setText((String) v.get(4));
            tfCRCNo_.setText((String) v.get(5));
            tfFatherName_.setText((String) v.get(6));
            tfFatherNIC_.setText((String) v.get(7));
            tfMotherName_.setText((String) v.get(8));
            tfMotherNIC_.setText((String) v.get(9));
            tfGuardianName_.setText((String) v.get(10));
            tfGuardianNIC_.setText((String) v.get(11));
        }
    }

    public String saveRecord() {

        GeneralDB gdb = new GeneralDB();

        String fullName = tfFullName.getText();
        String dateOfBirth = tfDateOfBirth.getSQLDate();
        String fatherNIC = tfFatherNIC.getText();
        String str = fullName + dateOfBirth + fatherNIC;

        String uidn = Integer.toString(str.hashCode());

        String idQuery = "SELECT MAX(ID) FROM STUDENT";
        String mid = gdb.getSingleColumnData(idQuery);
        if (mid == null) {
            mid = "0";
        }

        int id = 0;

        try {
            id = Integer.parseInt(mid);
        } catch (NumberFormatException nfe) {
            id = 0;
        }

        id = id + 1;

        String studentID = gdb.createStudentID(id);

        String query = "INSERT INTO STUDENT("
                + "STUDENT_ID, FIRST_NAME, LAST_NAME, FULL_NAME,"
                + "DATE_OF_BIRTH, GENDER, CRCNO, FATHER_NAME, FATHER_NIC,"
                + "MOTHER_NAME, MOTHER_NIC, GUARDIAN_NAME, GUARDIAN_NIC,"
                + "UIDN, USER_ID, TRANSACTION_TIME)VALUES("
                + "'" + studentID + "',"
                + "'" + tfFirstName.getText().toUpperCase() + "',"
                + "'" + tfLastName.getText().toUpperCase() + "',"
                + "'" + tfFullName.getText().toUpperCase() + "',"
                + "'" + tfDateOfBirth.getSQLDate() + "',"
                + "'" + tfGender.getText().toUpperCase() + "',"
                + "'" + tfCRCNo.getText().toUpperCase() + "',"
                + "'" + tfFatherName.getText().toUpperCase() + "',"
                + "'" + tfFatherNIC.getText().toUpperCase() + "',"
                + "'" + tfMotherName.getText().toUpperCase() + "',"
                + "'" + tfMotherNIC.getText() + "',"
                + "'" + tfGuardianName.getText().toUpperCase() + "',"
                + "'" + tfGuardianNIC.getText() + "',"
                + "'" + uidn + "',"
                + "'" + System.getProperty("LOGIN_USER_ID") + "',"
                + "'" + gdb.getTimeStamp() + "')";

        String stats = gdb.execute(query);

        return stats;

    }

    public String updateRecord(String studentID) {

        GeneralDB gdb = new GeneralDB();

        String fullName = tfFullName.getText();
        String dateOfBirth = tfDateOfBirth.getSQLDate();
        String fatherNIC = tfFatherNIC.getText();
        String str = fullName + dateOfBirth + fatherNIC;

        String uidn = Integer.toString(str.hashCode());

//        String idQuery = "SELECT MAX(ID) FROM STUDENT";
//        String mid = gdb.getSingleColumnData(idQuery);
//        if(mid == null){
//            mid = "0";
//        }
//
//        int id = 0;
//
//        try{
//            id = Integer.parseInt(mid);
//        }catch(NumberFormatException nfe){
//            id = 0;
//        }
//
//        id = id + 1;
//
//        String studentID = gdb.createStudentID(id);

        String query = "REPLACE INTO STUDENT("
                + "STUDENT_ID, FIRST_NAME, LAST_NAME, FULL_NAME,"
                + "DATE_OF_BIRTH, GENDER, CRCNO, FATHER_NAME, FATHER_NIC,"
                + "MOTHER_NAME, MOTHER_NIC, GUARDIAN_NAME, GUARDIAN_NIC,"
                + "UIDN, USER_ID, TRANSACTION_TIME)VALUES("
                + "'" + studentID + "',"
                + "'" + tfFirstName.getText().toUpperCase() + "',"
                + "'" + tfLastName.getText().toUpperCase() + "',"
                + "'" + tfFullName.getText().toUpperCase() + "',"
                + "'" + tfDateOfBirth.getSQLDate() + "',"
                + "'" + tfGender.getText().toUpperCase() + "',"
                + "'" + tfCRCNo.getText().toUpperCase() + "',"
                + "'" + tfFatherName.getText().toUpperCase() + "',"
                + "'" + tfFatherNIC.getText().toUpperCase() + "',"
                + "'" + tfMotherName.getText().toUpperCase() + "',"
                + "'" + tfMotherNIC.getText() + "',"
                + "'" + tfGuardianName.getText().toUpperCase() + "',"
                + "'" + tfGuardianNIC.getText() + "',"
                + "'" + uidn + "',"
                + "'" + System.getProperty("LOGIN_USER_ID") + "',"
                + "'" + gdb.getTimeStamp() + "')";

        String stats = gdb.execute(query);

        return stats;
    }

    public void showWindow() {
        //JFrame frame = new JFrame("Student Basic Information");
//        frame.setLayout(new GridBagLayout());
//        frame.add(pnlMain);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setSize(520, 450);
//        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new FStudent();
    }
}
