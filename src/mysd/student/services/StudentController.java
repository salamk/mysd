/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.student.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mysd.GeneralDB;
import mysd.Utils;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class StudentController {

    private GeneralDB gdb;

    public StudentController() {
        gdb = new GeneralDB();
    }

    public void setStudentPic(String studentID, JLabel lbImage) {
        lbImage.setIcon(null);

        String query = "SELECT PARAM_VALUE FROM MYSPARAM WHERE "
                + "PARAM_NAME LIKE 'STUDENT_PICS_PATH'";

        String path = gdb.getSingleColumnData(query);
        String image = path + studentID + ".JPG";
        System.out.println(image);

        lbImage.setIcon(new ImageIcon(image));

    }

    public void setRecord(String studentID, JEditorPane taBasicInfo) {

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
            fnic = (String) v.get(6);
            mnic = (String) v.get(7);
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

        

        String str = "<FONT FACE='arial' size=4>"
                + "<TABLE cellpadding=0 cellspacing=0 width=100%>";


        str += "<TR><TD><font face='arial' size=3>STUDENT ID</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + studentID + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>STUDENT NAME</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + fullName + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>DATE OF BIRTH</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + dob + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>GENDER</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + gender + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>CRC/CBC #</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + crcno + "</B></TD></TR>";

        str += "</TABLE></font><BR>";
        //str += address;

        //taBasicInfo.setText(str);

        str += "<FONT FACE='arial' size=4>"
                + "<TABLE cellpadding=0 cellspacing=0 width=100%>";

        str += "<TR><TD><font face='arial' size=3>CAMPUS ID</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + buildingID + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>CLASSROOM #</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + classRoomID + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>GRADE ID</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + gradeID + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>ENROLL DATE</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + enrollDate + "</B></TD></TR>";

        str += "<TR><TD><font face='arial' size=3>STATUS</TD>"
                + "<TD><font face='arial' size=3 color=blue>"
                + "<B>" + cstatus + "</B></TD></TR>";

        str += "</TABLE></font><BR>";
        

        taBasicInfo.setText(str);

    }

    public void setAddressWindow(final String studentID) {

        final JFrame frame = new JFrame("Student Address");
        final FStudentAddress address = new FStudentAddress();
        JButton btnSave = new JButton("Save");
        address.pnlMain.add(btnSave, "gaptop 20");




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
        frame.add(address.pnlMain, "gaptop 50, gapleft 50");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    public void setContactWindow(final String studentID) {

        final JFrame frame = new JFrame("Student Contact");
        final FStudentContact contact = new FStudentContact();
        JButton btnSave = new JButton("Save");
        contact.pnlMain.add(btnSave, "gaptop 20");




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
        frame.add(contact.pnlMain, "gapleft 50, gaptop 50");
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    public void setHealthWindow(final String studentID) {

        final JFrame frame = new JFrame("Student Health Conduction");
        final FStudentHealth health = new FStudentHealth();
        JButton btnSave = new JButton("Save");
        health.pnlMain.add(btnSave);
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

    public void setVanWindow(final String studentID) {

        final JFrame frame = new JFrame("Student Van Information");
        final FStudentVan van = new FStudentVan();
        JButton btnSave = new JButton("Save");
        van.pnlMain.add(btnSave);
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


    public void editStudentMainRecord(final String studentID) {


        final JFrame frame = new JFrame("Student Main Record");
        final FStudent student = new FStudent();
        JButton btnSave = new JButton("Update");
        student.pnlMain.add(btnSave,"gaptop 30");

        
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
        frame.setSize(student.pnlMain.getPreferredSize().width+50,
                student.pnlMain.getPreferredSize().height+50);
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
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
        frame.setSize(student.pnlMain.getPreferredSize().width+50,
                student.pnlMain.getPreferredSize().height+50);
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    
    
}
