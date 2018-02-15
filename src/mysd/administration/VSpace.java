/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.administration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import mysd.GeneralDB;
import mysd.Utils;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class VSpace extends FSpace{
    private JButton btnSave;
    
    public VSpace(){
        super();
        updateTable();
//        btnSave = new JButton("Save/Update");
        
//        btnNewBuilding.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                addNewBuilding();
//            }
//        });
//
//        btnNewClassRoom.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                int r = tblBuilding.getSelectedRow();
//                if(r == -1){
//                    Utils.msg("Please select a building to \nadd classes into");
//                }else{
//                    String buildingID = (String)tblBuilding.getValueAt(r, 0);
//                    addNewClassRoom(buildingID);
//                }
//
//            }
//        });
    }

//    public void addNewBuilding(){
//        final FCampus campus = new FCampus();
//        campus.add(btnSave);
//
//        final JFrame frame = new JFrame("New Building Addition");
//        frame.setLayout(new MigLayout());
//        frame.add(campus.pnlMain);
//        frame.setSize(300,400);
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        campus.tfBuildingID.addFocusListener(new FocusAdapter(){
//           public void focusLost(FocusEvent e) {
//               String query = "SELECT BUILDING_NAME, BUILDING_DESCRIPTION,"
//                       + "NUM_UNITS FROM BUILDING WHERE BUILDING_ID "
//                       + "LIKE '"+campus.tfBuildingID.getText()+"'";
//               Vector v = GeneralDB.getSingleRow(query);
//               campus.tfBuildingName.setText((String)v.get(0));
//               campus.tfBuildingDescription.setText((String)v.get(1));
//               campus.tfNumUnits.setText((String)v.get(2));
//           }
//        });
//
//        btnSave.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                String query = "INSERT INTO BUILDING("
//                        + "BUILDING_ID, BUILDING_NAME,"
//                        + "BUILDING_DESCRIPTION, NUM_UNITS)VALUES("
//                        + "'"+campus.tfBuildingID.getText()+"',"
//                        + "'"+campus.tfBuildingName.getText()+"',"
//                        + "'"+campus.tfBuildingDescription.getText()+"',"
//                        + "'"+campus.tfNumUnits.getText()+"')";
//
//                GeneralDB gdb = new GeneralDB();
//                String stats = gdb.execute(query);
//                if(stats.compareToIgnoreCase("ok")==0){
//                    updateTable();
//                    frame.setVisible(false);
//                    frame.dispose();
//                }else{
//                    Utils.msg(stats);
//                }
//
//            }
//        });
//    }
//
//
//
//    public void addNewClassRoom(final String buildingID){
//        final FClassRoom77 classRoom = new FClassRoom77();
//        classRoom.pnlMain.add(btnSave);
//        classRoom.cmbBuilding.setSelectedBuilding(buildingID);
//        classRoom.cmbBuilding.setEnabled(false);
//
//        final JFrame frame = new JFrame("New Class Room Addition");
//        frame.setLayout(new MigLayout());
//        frame.add(classRoom.pnlMain);
//        frame.setSize(400,250);
//
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//
//        btnSave.addActionListener(new ActionListener(){
//
//            public void actionPerformed(ActionEvent e){
//
//                String query = "REPLACE INTO CLASSROOM(CLASSROOM_ID, "
//                        + "BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
//                        + "ROOM_INTERCOMNO)VALUES("
//                        + "'"+classRoom.tfClassRoomID.getText()+"',"
//                        + "'"+classRoom.cmbBuilding.getBuildingID()+"',"
//                        + "'"+classRoom.tfRoomNo.getText()+"',"
//                        + "'"+classRoom.tfRoomDescription.getText()+"',"
//                        + "'"+classRoom.tfRoomIntercomNo.getText()+"')";
//
//                GeneralDB gdb = new GeneralDB();
//                String stats = gdb.execute(query);
//
//                if(stats.compareToIgnoreCase("ok") == 0){
//
//                    showClassRoomInfo(buildingID);
//                    frame.setVisible(false);
//                    frame.dispose();
//
//                }else{
//
//                    Utils.msg(stats);
//                }
//
//            }
//        });
//    }

    public void updateClassRoomRecord(){

        int selectedRow = tblClasses.getSelectedRow();
        final String buildingID = (String)tblClasses.getValueAt(selectedRow, 1);
        String classRoomID = (String)tblClasses.getValueAt(selectedRow, 0);
        String roomNo = (String)tblClasses.getValueAt(selectedRow, 2);
        String roomDescription = (String)tblClasses.getValueAt(selectedRow, 3);
        String intercomNo = (String)tblClasses.getValueAt(selectedRow, 4);
        
        final FClassRoom classRoom = new FClassRoom();
        JButton btnSave = new JButton("Update");
        classRoom.add(btnSave);
        classRoom.cmbBuilding.setSelectedBuilding(buildingID);
        classRoom.cmbBuilding.setEnabled(false);

        classRoom.tfClassRoomID.setText(classRoomID);
        classRoom.tfClassRoomID.setEnabled(false);
        classRoom.tfRoomNo.setText(roomNo);
        classRoom.tfRoomDescription.setText(roomDescription);
        classRoom.tfRoomIntercomNo.setText(intercomNo);

        final JFrame frame = new JFrame("Update Class Room ");
        frame.setLayout(new MigLayout());
        frame.add(classRoom);
        frame.setSize(400,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        btnSave.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                String query = "REPLACE INTO CLASSROOM(CLASSROOM_ID, "
                        + "BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
                        + "ROOM_INTERCOMNO)VALUES("
                        + "'"+classRoom.tfClassRoomID.getText()+"',"
                        + "'"+classRoom.cmbBuilding.getBuildingID()+"',"
                        + "'"+classRoom.tfRoomNo.getText()+"',"
                        + "'"+classRoom.tfRoomDescription.getText()+"',"
                        + "'"+classRoom.tfRoomIntercomNo.getText()+"')";

                GeneralDB gdb = new GeneralDB();
                String stats = gdb.execute(query);

                if(stats.compareToIgnoreCase("ok") == 0){

                    showClassRoomInfo(buildingID);
                    frame.setVisible(false);
                    frame.dispose();

                }else{

                    Utils.msg(stats);
                }

            }
        });
    }


    
    public void updateTable(){

        DefaultTableModel model = (DefaultTableModel)tblBuilding.getModel();
        model.setRowCount(0);

        String query = "SELECT BUILDING_ID, BUILDING_NAME, "
                + "BUILDING_DESCRIPTION, NUM_UNITS FROM "
                + "BUILDING ";
        GeneralDB gdb = new GeneralDB();
        ArrayList list = gdb.searchRecord(query);

        Iterator i = list.iterator();
        while(i.hasNext()){
            model.addRow((Vector)i.next());
        }
    }

    public void showClassRoomInfo(String buildingID){
        DefaultTableModel model = (DefaultTableModel)tblClasses.getModel();
        model.setRowCount(0);
        
        String query = "SELECT CLASSROOM_ID, BUILDING_ID, ROOM_NO, ROOM_DESCRIPTION,"
                + "ROOM_INTERCOMNO FROM CLASSROOM WHERE BUILDING_ID "
                + "LIKE '"+buildingID+"'";

        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        int j = 0;
        
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            model.addRow(v);
        }

        
        
    }


    public void updateBuildingRecord(String buildingID){
        final FCampus campus = new FCampus();
//        JButton btnSave = new JButton("Update");
//        campus.pnlMain.add(btnSave);

        final JFrame frame = new JFrame("Update building Record");

        String query = "SELECT BUILDING_ID, BUILDING_NAME,"
                + "BUILDING_DESCRIPTION, NUM_UNITS FROM "
                + "BUILDING WHERE BUILDING_ID LIKE '"+buildingID+"'";

        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.getSingleRowData(query);
        campus.tfBuildingID.setText((String)al.get(0));
        campus.tfBuildingID.setEnabled(false);
        
        campus.tfBuildingName.setText((String)al.get(1));
        campus.tfBuildingDescription.setText((String)al.get(2));
        campus.tfNumUnits.setText((String)al.get(3));

        frame.setLayout(new MigLayout());
        frame.add(campus);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String query = "REPLACE INTO BUILDING("
                        + "BUILDING_ID, BUILDING_NAME,"
                        + "BUILDING_DESCRIPTION, NUM_UNITS)VALUES("
                        + "'"+campus.tfBuildingID.getText()+"',"
                        + "'"+campus.tfBuildingName.getText()+"',"
                        + "'"+campus.tfBuildingDescription.getText()+"',"
                        + "'"+campus.tfNumUnits.getText()+"')";

                

                GeneralDB gdb = new GeneralDB();
                String stats = gdb.execute(query);
                if(stats.compareToIgnoreCase("ok")==0){
                    updateTable();
                    frame.setVisible(false);
                    frame.dispose();
                }else{
                    Utils.msg(stats);
                }

            }
        });
    }


    public static void main(String[] args){
        new VSpace().setVisible(true);
    }

}
