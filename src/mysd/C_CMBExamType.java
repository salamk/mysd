/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
 

/**
 *
 * @author salamk
 */
public class C_CMBExamType extends JComboBox {
    public C_CMBExamType(){
        this.removeAllItems();
        DBSystem dbs = new DBSystem();
        Connection con = dbs.getConnection();
        try
        {
            Statement stmt = con.createStatement();
            String query = "SELECT EXAM_CODE, EXAM_NAME FROM mys.tbl_exam_type";

            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                String id = rs.getString("EXAM_CODE");
                String nm = rs.getString("EXAM_NAME");
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


     public String getExamCode(){
        String item = (String)this.getSelectedItem();
        String[] el = item.split(" - ");
        return el[0];
    }

    public String getExamName(){
        String item = (String)this.getSelectedItem();
        String[] el = item.split(" - ");
        return el[1];
    }


    public void setSelectedExamCode(String code){
        int size = this.getItemCount();
        for(int i=0; i<=size-1; i++){
            String item = (String)this.getItemAt(i);
            if(item.startsWith(code)){
                setSelectedIndex(i);
                break;
            }
        }
    }

    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, new C_CMBExamType());
    }

}
