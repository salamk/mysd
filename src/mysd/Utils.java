/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author salam
 */
public class Utils {

    public Utils(){

    }

    public static void msg(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static String resize(String str, int w_space_count) {
        int len = str.length();
        int space_length = w_space_count - len;
        for (int i = 0; i <= space_length; i++) {
            str = str + " ";
        }

        return str;
    }

    public static String appendZero(String str, int nLength) {
        int len = str.length();
        int space_length = nLength - len;
        for (int i = 0; i < space_length; i++) {
            str = "0" + str;
        }

        return str;
    }

    public static String getCurrentYear(String format) {
        Calendar cal = new GregorianCalendar();
        String currentYear = "";
        if (format.compareToIgnoreCase("YYYY") == 0) {
            currentYear = Integer.toString(cal.get(Calendar.YEAR));
        } else if (format.compareToIgnoreCase("YY") == 0) {
            currentYear = Integer.toString(cal.get(Calendar.YEAR));
            currentYear = currentYear.substring(2, 4);
        }

        return currentYear;
    }

    public static String getCurrentDate(){
        GeneralDB gdb = new GeneralDB();
        return gdb.getCurrentDate();
    }

}
