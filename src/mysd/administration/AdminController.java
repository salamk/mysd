/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd.administration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mysd.GeneralDB;
import mysd.Utils;
import net.miginfocom.swing.MigLayout;

/**
 *s
 * @author salam
 */
public class AdminController {

    private GeneralDB gdb;

    public AdminController() {
        gdb = new GeneralDB();
    }

    public void addNewBuilding() {
        final FCampus campus = new FCampus();
        updateBuildingTable(campus.tblCampus);
        //JButton btnSave = new JButton("Save");
        //campus.pnlMain.add(btnSave);

        campus.tfBuildingID.addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent e) {
                String query = "SELECT BUILDING_NAME, BUILDING_DESCRIPTION,"
                        + "NUM_UNITS FROM BUILDING WHERE BUILDING_ID "
                        + "LIKE '" + campus.tfBuildingID.getText() + "'";
                Vector v = GeneralDB.getSingleRow(query);
                campus.tfBuildingName.setText((String) v.get(0));
                campus.tfBuildingDescription.setText((String) v.get(1));
                campus.tfNumUnits.setText((String) v.get(2));
            }
        });

        final JFrame frame = new JFrame("New Building Addition");
        frame.setLayout(new MigLayout());
        frame.add(campus);
        frame.setSize(campus.getPreferredSize().width + 25,
                campus.getPreferredSize().height + 25);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        campus.btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String query = "INSERT INTO BUILDING("
                        + "BUILDING_ID, BUILDING_NAME,"
                        + "BUILDING_DESCRIPTION, NUM_UNITS)VALUES("
                        + "'" + campus.tfBuildingID.getText() + "',"
                        + "'" + campus.tfBuildingName.getText() + "',"
                        + "'" + campus.tfBuildingDescription.getText() + "',"
                        + "'" + campus.tfNumUnits.getText() + "')";


                String stats = gdb.execute(query);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    updateBuildingTable(campus.tblCampus);
                } else {
                    Utils.msg(stats);
                }

            }
        });

        campus.btnUpdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String query = "REPLACE INTO BUILDING("
                        + "BUILDING_ID, BUILDING_NAME,"
                        + "BUILDING_DESCRIPTION, NUM_UNITS)VALUES("
                        + "'" + campus.tfBuildingID.getText() + "',"
                        + "'" + campus.tfBuildingName.getText() + "',"
                        + "'" + campus.tfBuildingDescription.getText() + "',"
                        + "'" + campus.tfNumUnits.getText() + "')";


                String stats = gdb.execute(query);
                if (stats.compareToIgnoreCase("ok") == 0) {
                    updateBuildingTable(campus.tblCampus);
                } else {
                    Utils.msg(stats);
                }

            }
        });

        campus.tblCampus.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                int clickCount = evt.getClickCount();
                if (clickCount == 1) {
                    int selectedRow = ((JTable) evt.getComponent()).getSelectedRow();
                    String buildingID = (String) ((JTable) evt.getComponent()).getValueAt(selectedRow, 0);
                    String query = "SELECT BUILDING_ID, BUILDING_NAME,"
                            + "BUILDING_DESCRIPTION, NUM_UNITS FROM "
                            + "BUILDING WHERE BUILDING_ID LIKE '" + buildingID + "'";


                    ArrayList al = gdb.getSingleRowData(query);
                    campus.tfBuildingID.setText((String) al.get(0));
                    campus.tfBuildingID.setEnabled(false);

                    campus.tfBuildingName.setText((String) al.get(1));
                    campus.tfBuildingDescription.setText((String) al.get(2));
                    campus.tfNumUnits.setText((String) al.get(3));
                } else if (clickCount == 2) {
//                    int selectedRow = ((JTable) evt.getComponent()).getSelectedRow();
//                    String buildingID = (String) ((JTable) evt.getComponent()).getValueAt(selectedRow, 0);
//                    //updateBuildingRecord(buildingID,((JTable)evt.getComponent()));
                }

            }
        });


    }

    public void viewCampusInfo() {
        new VSpace().setVisible(true);

    }

    public void addNewClassRoom() {
        final FClassRoom classRoom = new FClassRoom();
        updateClassRoomTable(classRoom.tblRooms);

        final JFrame frame = new JFrame("New Class Room Addition");
        frame.setLayout(new MigLayout());
        frame.add(classRoom);
        frame.setSize(classRoom.getPreferredSize().width + 25,
                classRoom.getPreferredSize().height + 25);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        classRoom.btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String query = "INSERT INTO CLASSROOM(CLASSROOM_ID, "
                        + "BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
                        + "ROOM_INTERCOMNO)VALUES("
                        + "'" + classRoom.tfClassRoomID.getText() + "',"
                        + "'" + classRoom.cmbBuilding.getBuildingID() + "',"
                        + "'" + classRoom.tfRoomNo.getText() + "',"
                        + "'" + classRoom.tfRoomDescription.getText() + "',"
                        + "'" + classRoom.tfRoomIntercomNo.getText() + "')";


                String stats = gdb.execute(query);

                if (stats.compareToIgnoreCase("ok") == 0) {
                    updateClassRoomTable(classRoom.tblRooms);

                } else {

                    Utils.msg(stats);
                }

            }
        });


        classRoom.btnUpdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String query = "REPLACE INTO CLASSROOM(CLASSROOM_ID, "
                        + "BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
                        + "ROOM_INTERCOMNO)VALUES("
                        + "'" + classRoom.tfClassRoomID.getText() + "',"
                        + "'" + classRoom.cmbBuilding.getBuildingID() + "',"
                        + "'" + classRoom.tfRoomNo.getText() + "',"
                        + "'" + classRoom.tfRoomDescription.getText() + "',"
                        + "'" + classRoom.tfRoomIntercomNo.getText() + "')";


                String stats = gdb.execute(query);

                if (stats.compareToIgnoreCase("ok") == 0) {

                    updateClassRoomTable(classRoom.tblRooms);

                } else {

                    Utils.msg(stats);
                }

            }
        });



    }

    public void updateClassRoomTable(JTable tblRooms) {
        DefaultTableModel model = (DefaultTableModel) tblRooms.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Room ID");
        model.addColumn("Camp ID");
        model.addColumn("Room#");
        model.addColumn("Desc");
        model.addColumn("ICom#");

        String query = "SELECT CLASSROOM_ID, BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
                + "ROOM_INTERCOMNO FROM CLASSROOM";


        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        int j = 0;

        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            model.addRow(v);
        }

    }

    public void updateBuildingTable(JTable tblBuilding) {
        DefaultTableModel model = (DefaultTableModel) tblBuilding.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Camp ID");
        model.addColumn("Name");
        model.addColumn("Desc");
        model.addColumn("#Of Units");


        String query = "SELECT BUILDING_ID, BUILDING_NAME, "
                + "BUILDING_DESCRIPTION, NUM_UNITS FROM "
                + "BUILDING ";

        ArrayList list = gdb.searchRecord(query);

        Iterator i = list.iterator();
        while (i.hasNext()) {
            model.addRow((Vector) i.next());
        }
    }

    public void showClassRoomInfo(String buildingID, JTable tblClasses) {
        DefaultTableModel model = (DefaultTableModel) tblClasses.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);

        model.addColumn("Room ID");
        model.addColumn("Camp ID");
        model.addColumn("Room#");
        model.addColumn("Desc");
        model.addColumn("I.Com#");

        String query = "SELECT CLASSROOM_ID, BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
                + "ROOM_INTERCOMNO FROM CLASSROOM WHERE BUILDING_ID "
                + "LIKE '" + buildingID + "'";


        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();

        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            model.addRow(v);
        }

    }

    public void addUpdateUser() {

        final FUser usr = new FUser();
        this.updateUserTable(usr.tblUsers);
        usr.setVisible(true);
        usr.btnSave.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userID = usr.tfUserID.getText();
                String userPassword = usr.tfUserPassword.getText();
                String userEmployeeNo = usr.tfUserEmployeeNo.getText();
                String userFullName = usr.tfUserFullName.getText();
                String userContactNo = usr.tfUserContactNo.getText();
                String regDate = gdb.getCurrentDate();
                String accountActive = "";
                boolean selected = usr.chkAccountActive.isSelected();
                if (selected) {
                    accountActive = usr.ACTIVE;
                } else {
                    accountActive = usr.DISABLED;
                }

                String query = "INSERT INTO USERS("
                        + "USER_ID, USER_PASSWORD, USER_EMPLOYEE_NO,"
                        + "USER_FULL_NAME, USER_CONTACT_NO, REG_DATE,"
                        + "ACCOUNT_ACTIVE)VALUES("
                        + "'" + userID + "',"
                        + "'" + userPassword + "',"
                        + "'" + userEmployeeNo + "',"
                        + "'" + userFullName + "',"
                        + "'" + userContactNo + "',"
                        + "'" + regDate + "',"
                        + "'" + accountActive + "')";

                String stat = gdb.execute(query);
                if (stat.compareToIgnoreCase("ok") == 0) {
                    updateUserTable(usr.tblUsers);
                } else {
                    JOptionPane.showMessageDialog(null, stat);
                }

            }
        });

        usr.btnUpdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userID = usr.tfUserID.getText();
                String userPassword = usr.tfUserPassword.getText();
                String userEmployeeNo = usr.tfUserEmployeeNo.getText();
                String userFullName = usr.tfUserFullName.getText();
                String userContactNo = usr.tfUserContactNo.getText();
                String regDate = gdb.getCurrentDate();
                String accountActive = "";
                boolean selected = usr.chkAccountActive.isSelected();
                if (selected) {
                    accountActive = usr.ACTIVE;
                } else {
                    accountActive = usr.DISABLED;
                }

                String query = "REPLACE INTO USERS("
                        + "USER_ID, USER_PASSWORD, USER_EMPLOYEE_NO,"
                        + "USER_FULL_NAME, USER_CONTACT_NO, REG_DATE,"
                        + "ACCOUNT_ACTIVE)VALUES("
                        + "'" + userID + "',"
                        + "'" + userPassword + "',"
                        + "'" + userEmployeeNo + "',"
                        + "'" + userFullName + "',"
                        + "'" + userContactNo + "',"
                        + "'" + regDate + "',"
                        + "'" + accountActive + "')";

                String stat = gdb.execute(query);
                if (stat.compareToIgnoreCase("ok") == 0) {
                    updateUserTable(usr.tblUsers);
                } else {
                    JOptionPane.showMessageDialog(null, stat);
                }

            }
        });

        usr.tblUsers.addMouseListener(new MouseAdapter() {

            public void MouseClicked(MouseEvent evt) {
                System.out.println("Mouse is clicked");
                int clickCount = evt.getClickCount();
                if (clickCount == 1) {
                    System.out.println("Mouse is clicked 1 times");
                    int selectedRow = ((JTable) evt.getComponent()).getSelectedRow();
                    String userID = (String) ((JTable) evt.getComponent()).getValueAt(selectedRow, 0);
                    String query = "SELECT USER_ID, USER_PASSWORD,"
                            + "USER_EMPLOYEE_NO, USER_FULL_NAME,"
                            + "USER_CONTACT_NO, ACCOUNT_ACTIVE FROM "
                            + "USERS WHERE USER_ID LIKE '" + userID + "'";


                    ArrayList al = gdb.getSingleRowData(query);
                    usr.tfUserID.setText((String) al.get(0));
                    usr.tfUserPassword.setText((String) al.get(1));
                    usr.tfUserEmployeeNo.setText((String) al.get(2));
                    usr.tfUserFullName.setText((String) al.get(3));
                    usr.tfUserContactNo.setText((String) al.get(4));
                    String activity = (String) al.get(5);

                    if (activity.compareToIgnoreCase("ACTIVE") == 0) {
                        usr.chkAccountActive.setSelected(true);
                    } else {
                        usr.chkAccountActive.setSelected(false);
                    }
                }

            }
        });


    }

    public void updateUserTable(JTable tblUser) {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("UserID");
        model.addColumn("Emp#");
        model.addColumn("Name");
        model.addColumn("Contact");
        model.addColumn("Status");
        String query = "SELECT USER_ID, USER_EMPLOYEE_NO, USER_FULL_NAME"
                + ", USER_CONTACT_NO, ACCOUNT_ACTIVE FROM "
                + "USERS";
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            model.addRow(v);
        }
    }

    public void updateRights() {
        final FUserAccessControl ac = new FUserAccessControl();


        ac.btnFetch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model =
                        (DefaultTableModel) ac.tblRights.getModel();

                model.setRowCount(0);
                model.setColumnCount(0);
                model.addColumn("Category");
                model.addColumn("Description");
                model.addColumn("Status");

                String query = "SELECT OGID, OGDESCRIPTION "
                        + " FROM OGROUP WHERE "
                        + " OPCATEGORY "
                        + "LIKE '" + ac.cmbCategory.getSelectedItem() + "'";

                ArrayList al = gdb.searchRecord(query);
                Iterator i = al.iterator();
                while (i.hasNext()) {
                    Vector v = (Vector) i.next();
                    boolean allowed = isAllowed((String) v.get(0),
                            (String) ac.cCMBUser1.getSelectedItem());
                    v.add(Boolean.valueOf(allowed));
                    model.addRow(v);

                }

            }
        });

        ac.btnUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int c = ac.tblRights.getRowCount();
                String msgReturn = "";
                for(int i=0; i<=c-1; i++){
                    String categoryID = (String)ac.cmbCategory.getSelectedItem();
                    String userID = (String)ac.cCMBUser1.getSelectedItem();
                    String oid = (String)ac.tblRights.getValueAt(i, 0);
                    String aid = userID+"@"+oid;
                    Boolean allowed = (Boolean)ac.tblRights.getValueAt(i, 2);
                    String state = "";
                    if(allowed.booleanValue() == true){
                        state = "ALLOWED";
                    }else{
                        state = "RESTRICTED";
                    }

                    String query = "REPLACE INTO USERACCESS("
                            + "AID, OID, CATEGORYID, ACCESS_ALLOWED, USER_ID)"
                            + "VALUES("
                            + "'"+aid+"',"
                            + "'"+oid+"',"
                            + "'"+categoryID+"',"
                            + "'"+state+"',"
                            + "'"+userID+"')";

                    String msg = gdb.execute(query);
                    if(msg.compareToIgnoreCase("ok")==0){
                        msgReturn+=oid+" for "+userID+"Updated successfully\n";
                    }else{
                        msgReturn+="\nERROR:"+oid+" for "+userID+"Cannot be updated\n";
                    }
                    
                }

                JOptionPane.showMessageDialog(null, msgReturn);
            }
        });

        ac.setVisible(true);
    }

    public boolean isAllowed(String objectid, String userID) {
        boolean allowed = false;
        String aid = userID + "@" + objectid;
        String query = "SELECT ACCESS_ALLOWED FROM USERACCESS WHERE "
                + "AID LIKE '" + aid + "'";
        String rec = gdb.getSingleColumnData(query);
        if (rec == null) {
            allowed = false;
        } else if (rec.compareToIgnoreCase("allowed") == 0) {
            allowed = true;
        } else if (rec.compareToIgnoreCase("restricted") == 0) {
            allowed = false;
        }

        return allowed;
    }
}
