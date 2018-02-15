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
public class CCMBFeeCategory extends JComboBox{
    public CCMBFeeCategory(){
        super();
        this.removeAllItems();
        String query = "SELECT FEECATEGORY_ID, FEECATEGORY_DESCRIPTION,"
                + "DEFAULT_AMOUNT FROM FEECATEGORY";
        
        
        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            String categoryID = (String)v.get(0);
            String categoryDesc = (String)v.get(1);
            String defAmount = (String)v.get(2);

            String str = categoryID+"-"+categoryDesc+"-"+defAmount;
            this.addItem(str);
        }

    }
    

    public String getCategory(){
        String str = (String)this.getSelectedItem();
        String[] toke = str.split("-");
        return toke[0];
    }

    public String getDescription(){
        String str = (String)this.getSelectedItem();
        String[] toke = str.split("-");
        return toke[1];
    }

    public String getDefaultAmount(){
        String str = (String)this.getSelectedItem();
        String[] toke = str.split("-");
        return toke[2];
    }

  
}
