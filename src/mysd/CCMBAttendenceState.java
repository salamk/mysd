/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author salam
 */
public class CCMBAttendenceState extends JComboBox{
    public CCMBAttendenceState(){
        this.removeAllItems();
        String query = "SELECT ATCODE, ATDESCRIPTION FROM "
                + "ATTENDENCE_STATE";
        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            String atcode = (String)v.get(0);
            String atdesc = (String)v.get(1);
            String item = atcode+"-"+atdesc;
            this.addItem(item);
        }
    }

    public String getAttendenceCode(){
        String str = (String)this.getSelectedItem();
        String[] toke = str.split("-");
        return toke[0];
    }

    public void setAttendenceCode(String atcode){
        atcode = atcode+"-";
        for(int i=0; i<=this.getItemCount()-1; i++){
            String item = (String)this.getItemAt(i);
            if(item.compareToIgnoreCase(atcode)==0){
                this.setSelectedIndex(i);
                break;
            }
        }
    }

}
