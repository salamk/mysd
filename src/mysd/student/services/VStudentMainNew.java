/*
 *
 */
package mysd.student.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import mysd.GeneralDB;
import mysd.Utils;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public class VStudentMainNew extends WStudentMain {

    public static final int NEW_MODE = 0;
    public static final int EDIT_MODE = 1;
    private GeneralDB gdb;

    public VStudentMainNew() {
        super();
        gdb = new GeneralDB();

        btnNew.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setNewStudentWindow();
            }
        });

        btnAddress.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setAddressWindow();
            }
        });

        btnContact.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setContactWindow();
            }
        });

        btnHealth.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setHealthWindow();
            }
        });

        btnVanInfo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVanWindow();
            }
        });


        btnHistory.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setAcademicWindow();
            }
        });


        btnEnrollment.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setEnrollmentWindow();
            }
        });
        
        
//        btnPic.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                setStudentPic();
//            }
//        });




        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void setAddressWindow() {
        
        final JFrame frame = new JFrame("Student Address");
        final FStudentAddress address = new FStudentAddress();
        JButton btnSave = new JButton("Save");
        address.pnlMain.add(btnSave,"gaptop 20");

        int row = tblStudent.getSelectedRow();

        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        final String studentID = (String) tblStudent.getValueAt(row, 0);

        address.setRecord(studentID);



        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = address.updateRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(address.pnlMain,"gaptop 50, gapleft 50");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
      }
    }

    public void setNewStudentWindow() {

        final FStudent student = new FStudent();
        JButton btnSave = new JButton("Save");
        student.pnlMain.add(btnSave,"gaptop 20");
        final JFrame frame = new JFrame("Student Record");

        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String s = student.validateRecord();
                if (s.compareToIgnoreCase("ok") == 0) {
                    String stats = student.saveRecord();
                    if (stats.compareToIgnoreCase("ok") == 0) {
                        frame.setVisible(false);
                        frame.dispose();
                        //loadData();
                    } else {
                        Utils.msg(stats);

                    }
                } else {
                    Utils.msg(s);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(student.pnlMain,"gaptop 50, gapleft 50");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setHealthWindow() {
        
        final JFrame frame = new JFrame("Student Health Conduction");
        final FStudentHealth health = new FStudentHealth();
        JButton btnSave = new JButton("Save");
        health.pnlMain.add(btnSave);

        int row = tblStudent.getSelectedRow();

        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        final String studentID = (String) tblStudent.getValueAt(row, 0);


        health.setRecord(studentID);



        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = health.saveRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(health.pnlMain);
        frame.setSize(450, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        }
    }

    public void setVanWindow() {
        
        final JFrame frame = new JFrame("Student Van Information");
        final FStudentVan van = new FStudentVan();
        JButton btnSave = new JButton("Save");
        van.pnlMain.add(btnSave);

        int row = tblStudent.getSelectedRow();

        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        final String studentID = (String) tblStudent.getValueAt(row, 0);

        van.setRecord(studentID);



        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = van.saveRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(van.pnlMain);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        }
    }

    public void setContactWindow() {
        
        final JFrame frame = new JFrame("Student Contact");
        final FStudentContact contact = new FStudentContact();
        JButton btnSave = new JButton("Save");
        contact.pnlMain.add(btnSave,"gaptop 20");

        int row = tblStudent.getSelectedRow();
        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        final String studentID = (String) tblStudent.getValueAt(row, 0);

        contact.setRecord(studentID);



        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = contact.saveRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(contact.pnlMain,"gapleft 50, gaptop 50");
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        }
    }

    public void setAcademicWindow() {

        final JFrame frame = new JFrame("Student Admission/Academic");
        final FStudentAcademic academic = new FStudentAcademic();
        JButton btnSave = new JButton("Save");
        academic.pnlMain.add(btnSave,"gaptop 20");

        int row = tblStudent.getSelectedRow();
        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        final String studentID = (String) tblStudent.getValueAt(row, 0);

        academic.setRecord(studentID);



        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = academic.saveRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(academic.pnlMain,"gapleft 50, gaptop 50");
        frame.setSize(650, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        }
    }

    public void setEnrollmentWindow() {
        
        final JFrame frame = new JFrame("Student Enrollment/Class Allocation");
        final FCurrentEnrollment enrollment = new FCurrentEnrollment();
        JButton btnSave = new JButton("Save");
        enrollment.pnlMain.add(btnSave,"gaptop 20");

        int row = tblStudent.getSelectedRow();

        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        final String studentID = (String) tblStudent.getValueAt(row, 0);

        enrollment.setRecord(studentID);



        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = enrollment.saveRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(enrollment.pnlMain,"gapleft 50, gaptop 50");
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        }
    }

    public void editStudentMainRecord(final String studentID) {
        
        
        final JFrame frame = new JFrame("Student Main Record");
        final FStudent student = new FStudent();
        JButton btnSave = new JButton("Update");
        student.pnlMain.add(btnSave,"gaptop 30");

        int row = tblStudent.getSelectedRow();

        if(row == -1){
            Utils.msg("Please select a record from table to edit/update");
        }else{
        student.setRecord(studentID);

        btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stats = student.updateRecord(studentID);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    frame.setVisible(false);
                    frame.dispose();
                } else {
                    Utils.msg(stats);
                }
            }
        });


        frame.setLayout(new MigLayout());
        frame.add(student.pnlMain,"gaptop 50, gapleft 50");
        frame.setSize(550, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        }
    }

    public void setRecord(String studentID) {

        String query = "SELECT FULL_NAME, DATE_OF_BIRTH, GENDER, "
                + " CRCNO, FATHER_NAME, MOTHER_NAME, FATHER_NIC, MOTHER_NIC FROM "
                + "STUDENT WHERE STUDENT_ID like '" + studentID + "'";

        Vector v = GeneralDB.getSingleRow(query);

        String fullName = "", dob = "", gender = "", crcno = "", fname = "", mname = "";
        String mnic = "", fnic = "";

        if (v != null) {
            fullName = (String) v.get(0);
            dob = (String) v.get(1);
            gender = (String) v.get(2);
            crcno = (String) v.get(3);
            fname = (String) v.get(4);
            mname = (String) v.get(5);
            fnic  = (String) v.get(6);
            mnic = (String) v.get(7);
        }
       

        query = "SELECT HOUSENO, STREET, BLOCK, SECTOR, LOCALITY,"
                + "TOWN, OTHERINFO, DISTRICT FROM STUDENTADDRESS WHERE"
                + " STUDENTID LIKE '" + studentID + "'";

        v = GeneralDB.getSingleRow(query);

        String houseNo = "", street = "", block = "", sector = "", locality = "",
                town = "", otherInfo = "", district = "";

        if (v != null) {
            houseNo = (String) v.get(0);
            street = (String) v.get(1);
            block = (String) v.get(2);
            sector = (String) v.get(3);
            locality = (String) v.get(4);
            town = (String) v.get(5);
            otherInfo = (String) v.get(6);
            district = (String) v.get(7);
        }

        query = "SELECT HOME_PHONE, MOBILE_PHONE, OFFICE_PHONE,"
                + "EMERGENCY_PHONE, EMAIL_ID FROM STUDENTCONTACT "
                + "WHERE STUDENTID LIKE '" + studentID + "'";

        v = GeneralDB.getSingleRow(query);

        String homePhone = "", mobilePhone = "", officePhone = "", emergencyPhone = "",
                emailID = "";

        if (v != null) {
            homePhone = (String) v.get(0);
            mobilePhone = (String) v.get(1);
            officePhone = (String) v.get(2);
            emergencyPhone = (String) v.get(3);
            emailID = (String) v.get(4);
        }


        query = "SELECT BUILDINGID, CLASSROOMID, GRADEID, ENROLLDATE,"
                + "REMARKS, CSTATUS FROM CURRENTENROLLMENT WHERE "
                + "STUDENTID LIKE '" + studentID + "'";
        v = GeneralDB.getSingleRow(query);

        String buildingID = "",
                classRoomID = "",
                gradeID = "",
                enrollDate = "",
                remarks = "",
                cstatus = "";

        if (v != null) {
            buildingID = (String) v.get(0);
            classRoomID = (String) v.get(1);
            gradeID = (String) v.get(2);
            enrollDate = (String) v.get(3);
            remarks = (String) v.get(4);
            cstatus = (String) v.get(5);
        }


        if(houseNo.compareTo("")==0 || houseNo == null){houseNo = "";}
        if(street.compareTo("")==0 || street == null){street = "";}
        if(block.compareTo("")==0 || block == null){block = "";}
        if(sector.compareTo("")==0 || sector == null){sector = "";}
        if(locality.compareTo("")==0 || locality == null){locality = "";}
        if(otherInfo.compareTo("")==0 || otherInfo == null){otherInfo = "";}
        if(town.compareTo("")==0 || town == null){town = "";}
        if(district.compareTo("")==0 || district == null){district = "";}
        if(homePhone.compareTo("")==0 || homePhone == null){homePhone = "NA";}
        if(mobilePhone.compareTo("")==0 || mobilePhone == null){mobilePhone = "NA";}
        if(officePhone.compareTo("")==0 || officePhone == null){officePhone = "NA";}
        if(emergencyPhone.compareTo("")==0 || emergencyPhone == null){emergencyPhone = "NA";}
        if(emailID.compareTo("")==0 || emailID == null){emailID = "NA";}

        String address="<FONT COLOR=green face='arial' size=3>";
        address+= houseNo+" "+street+" "+block+" "+sector;
        address+="<BR>"+locality+" "+otherInfo+" "+town;
        address+="<BR>"+district+"\n";
        address+="<BR>Phone (Res): "+homePhone;
        address+="<BR>\nPhone (Mob): "+mobilePhone;
        address+="<BR>\nPhone (Off): "+officePhone;
        address+="<BR>\nPhone (Emr): "+emergencyPhone;
        address+="</FONT>";

        String str = "<FONT FACE='arial' size=4>"
                + "<TABLE cellpadding=0 cellspacing=0 width=100%>";
       

        str+="<TR><TD><font face='arial' size=3>STUDENT ID</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+studentID+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>STUDENT NAME</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+fullName+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>DATE OF BIRTH</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+dob+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>GENDER</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+gender+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>CRC/CBC #</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+crcno+"</B></TD></TR>";
        
        str+="</TABLE></font><BR>";
        str+=address;

        taBasicInfo.setText(str);

        str = "<FONT FACE='arial' size=4>"
                + "<TABLE cellpadding=0 cellspacing=0 width=100%>";
        
        str+="<TR><TD><font face='arial' size=3>CAMPUS ID</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+buildingID+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>CLASSROOM #</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+classRoomID+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>GRADE ID</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+gradeID+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>ENROLL DATE</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+enrollDate+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>STATUS</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+cstatus+"</B></TD></TR>";
        
        str+="</TABLE></font><BR>";


        str += "<FONT FACE='arial' size=4>"
                + "<TABLE cellpadding=0 cellspacing=0 width=100%>";

        str+="<TR><TD><font face='arial' size=3>FATHER NAME</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+fname+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>FATHER NIC</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+fnic+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>MOTHER NAME</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+mname+"</B></TD></TR>";

        str+="<TR><TD><font face='arial' size=3>MOTHER NIC</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>"+mnic+"</B></TD></TR>";

        str+="</TABLE></font>";
        taParent.setText(str);

        query = "SELECT PARAM_VALUE FROM MYSPARAM WHERE "
            + "PARAM_NAME LIKE 'STUDENT_PICS_PATH'";
        String path = gdb.getSingleColumnData(query);
        String image = path+studentID+".JPG";
        System.out.println(image);

        lbImage.setIcon(new ImageIcon(image));
        
    }

public void setStudentPic(){
    
//    String query = "SELECT PARAM_VALUE FROM MYSPARAM WHERE "
//            + "PARAM_NAME LIKE 'STUDENT_PICS_PATH'";
//    String path = gdb.getSingleColumnData(query);
//    String image = path+"noimage.jpg";


}

    public static void main(String[] args) {
        new VStudentMainNew();
    }
}
