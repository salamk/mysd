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
 * @author salamk
 */
@SuppressWarnings("serial")
public class CCMBExamID extends JComboBox {

    public CCMBExamID() {

        GeneralDB gdb = new GeneralDB();
        this.removeAllItems();

        String query = "SELECT EXAM_ID FROM mys.tbl_exam";

        ArrayList al = gdb.searchRecord(query);
        Iterator i = al.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            this.addItem((String) v.get(0));
        }

    }
}
