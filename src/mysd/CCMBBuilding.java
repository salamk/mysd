/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author salam
 */
public class CCMBBuilding extends JComboBox{
    public CCMBBuilding(){
        this.removeAllItems();
        String query = "SELECT BUILDING_ID, BUILDING_NAME FROM BUILDING";
        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            String bid = (String)v.get(0);
            String bnm = (String)v.get(1);
            String str = bid+"-"+bnm;
            addItem(str);
        }
    }

    public String getBuildingID(){
        String str = (String)getSelectedItem();
        String[] toke = str.split("-");
        String bid = toke[0];
        String bnm = toke[1];

        bid = bid.trim();
        bnm = bnm.trim();

        return bid;
    }

    public String getBuildingName(){
        String str = (String)getSelectedItem();
        String[] toke = str.split("-");
        String bid = toke[0];
        String bnm = toke[1];

        bid = bid.trim();
        bnm = bnm.trim();

        return bnm;
    }

    public void setSelectedBuilding(String buildingID){
        int selectedIndex = 0;
        for(int i=0; i<=this.getItemCount()-1; i++){
            String item = (String)this.getItemAt(i);
            item = item.toUpperCase();


            buildingID = buildingID.toUpperCase();
            String[] toke = buildingID.split("-");
            if(item.startsWith(toke[0])){
                selectedIndex = i;
            }
        }

        setSelectedIndex(selectedIndex);
    }

    
}
