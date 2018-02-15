/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

import mysd.dbo.TBLCourse;

/**
 *
 * @author salamk
 */
public class CCMBCourse extends JComboBox {
    public CCMBCourse(){
        DBSystem dbs = new DBSystem();
        Connection con = dbs.getConnection();
        try
        {
            Statement stmt = con.createStatement();
            
            String query = "SELECT COURSE_CODE, COURSE_NAME FROM "
                    + "tbl_course";

            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                String id = rs.getString("COURSE_CODE");
                String nm = rs.getString("COURSE_NAME");
                String item = id+" - "+nm;
                this.addItem(item);
            }

            con.close();
        }
        catch(Exception e)
        {
            dbs.closeConnection(con);
        }

    }


     public String getCourseCode(){
        String item = (String)this.getSelectedItem();
        String[] el = item.split(" - ");
        return el[0];
    }

    public String getCourseName(){
        String item = (String)this.getSelectedItem();
        String[] el = item.split(" - ");
        return el[1];
    }


    public void setSelectedCourseCode(String code){
        int size = this.getItemCount();
        for(int i=0; i<=size-1; i++){
            String item = (String)this.getItemAt(i);
            if(item.startsWith(code)){
                setSelectedIndex(i);
                break;
            }
        }
    }

}
