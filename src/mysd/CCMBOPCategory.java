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
public class CCMBOPCategory extends JComboBox{
    public CCMBOPCategory(){
        super();
        this.removeAllItems();
        String query = "SELECT CATEGORY_ID FROM OPCATEGORY";
        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            addItem((String)v.get(0));
        }
    }

}
