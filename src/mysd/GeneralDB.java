/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author salamk
 */
public class GeneralDB {

    protected DBSystem dbs;

    public GeneralDB() {
        dbs = new DBSystem();
    }

    public ArrayList searchRecord(String query) {
        
        ArrayList al = new ArrayList();

        Connection con = dbs.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            System.out.println(rs.getFetchSize());
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= colCount - 1; i++) {
                    v.add(rs.getString(i + 1));
                }
                al.add(v);
            }

            dbs.closeConnection(con);

        } catch (SQLException e) {
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/" + caller + "/" + method + "/"
                    + "\nInside(GeneralDB/searchRecord\n"
                    + "" + e.getClass().toString() + "\n"
                    + "" + e.getMessage());

            dbs.closeConnection(con);
            
        } catch (Exception ae) {
            String caller = ae.getStackTrace()[1].getClassName();
            String method = ae.getStackTrace()[1].getMethodName();
            String ename = ae.getClass().toString();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/" + caller + "/" + method + "/"
                    + "\nInside(GeneralDB/searchRecord\n"
                    + "" + ename + "\n"
                    + "" + ae.getMessage());
            ae.printStackTrace();
            dbs.closeConnection(con);
        }

        return al;

    }

    public ArrayList getSingleRowData(String query) {
        ArrayList al = new ArrayList();
        Connection con = dbs.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 0; i <= colCount - 1; i++) {
                    al.add(rs.getString(i + 1));
                }
            }

            dbs.closeConnection(con);

        } catch (SQLException se) {
            String caller = se.getStackTrace()[1].getClassName();
            String method = se.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/" + caller + "/" + method + "/"
                    + "\nInside(GeneralDB/getSingleRowData\n"
                    + "" + se.getClass().toString() + "\n"
                    + "" + se.getMessage());

            dbs.closeConnection(con);
        } catch (Exception e) {
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/" + caller + "/" + method + "/"
                    + "\nInside(GeneralDB/getSingleRowData\n"
                    + "" + e.getClass().toString() + "\n"
                    + "" + e.getMessage());

            dbs.closeConnection(con);
        }

        return al;
    }

    public String execute(String query) {

        String success = "";
        Connection con = dbs.getConnection();

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            success = "OK";
            dbs.closeConnection(con);

        } catch (Exception e) {
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/" + caller + "/" + method + "/"
                    + "\nInside(GeneralDB/execute\n"
                    + "" + e.getClass().toString() + "\n"
                    + "" + e.getMessage());
            dbs.closeConnection(con);

        }

        

        return success;
    }

    public String getSingleColumnData(String query) {
        String result = "";
        Connection con = dbs.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = rs.getString(1);
            }

            dbs.closeConnection(con);

        } catch (Exception e) {
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/" + caller + "/" + method + "/"
                    + "\nInside(GeneralDB/getSingleColumnData\n"
                    + "" + e.getClass().toString() + "\n"
                    + "" + e.getMessage());

            dbs.closeConnection(con);

        }

        return result;
    }

    public String createStudentID(int id) {
        String studentID = Integer.toString(id);
        studentID = Utils.appendZero(studentID, 5);
        studentID = "ST" + studentID;

        return studentID;
    }

    public String getTimeStamp() {
        String query = "SELECT CURRENT_TIMESTAMP()";
        return this.getSingleColumnData(query);

    }

    public String getCurrentDate() {
        String query = "SELECT CURRENT_DATE()";
        return this.getSingleColumnData(query);
    }

    public String getParamValue(String paramID, String tableName){
        String query = "SELECT PARAM_VALUE FROM "+tableName+" WHERE "
                + "PARAM_ID like '"+paramID+"'";
        String rec = getSingleColumnData(query);
        return rec;
    }

    
    public void loguser(String txt, String winName){

        String query = "INSERT INTO OPLOG("
                + "OP_NAME, OP_DESCRIPTION, OP_USER)VALUES("
                + "'"+winName+"',"
                + "'"+txt+"',"
                + "'"+dbs.getLoginUser()+"')";

        this.execute(query);

    }

    public static Vector getSingleRow(String query){
        Vector v = null;
        DBSystem dbsys = new DBSystem();
        Connection con = dbsys.getConnection();
 
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            int n = rs.getMetaData().getColumnCount();

            while(rs.next()){
                v = new Vector();
                for(int i=0; i<=n-1; i++){
                    v.add(rs.getString(i+1));
                }
            }

            con.close();

        }catch(Exception e){
            Utils.msg(e.getMessage());
            try{con.close();}catch(Exception ex){}
        }

        return v;
    }


    public Date getDateSQLFormatInput(String dateStr){
        Date theDay = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            theDay = df.parse(dateStr);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return theDay;
    }

     public Date getDateNormalInput(String dateStr){
        Date theDay = null;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            
            theDay = df.parse(dateStr);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return theDay;
    }


     public String getStrDateSQLFormat(Date theDay){
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String reportDate = df.format(theDay);
         return reportDate;
     }

     public String getStrDateNormalFormat(Date theDay){
         DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
         String reportDate = df.format(theDay);
         return reportDate;
     }

    
}
