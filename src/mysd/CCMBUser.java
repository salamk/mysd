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
public class CCMBUser extends JComboBox{
    public CCMBUser(){
        super();
        this.removeAllItems();
        String query = "SELECT USER_ID FROM USERS";
        GeneralDB gdb = new GeneralDB();
        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while(i.hasNext()){
            Vector v = (Vector)i.next();
            addItem((String)v.get(0));
        }
    }

    

}
