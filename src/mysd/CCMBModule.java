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
public class CCMBModule extends JComboBox{
    public CCMBModule(){
        super();
        this.removeAllItems();
        String query = "SELECT OGID FROM OGROUP";
        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            addItem((String)v.get(0));
        }
    }
}
