/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

import javax.swing.JComboBox;

/**
 *
 * @author salam
 */
public class CCMBTimeCode extends JComboBox{
    public CCMBTimeCode(){
        this.addItem("01-2011");
        this.addItem("02-2011");
        this.addItem("03-2011");
        this.addItem("04-2011");
        this.addItem("05-2011");
        this.addItem("06-2011");
        this.addItem("07-2011");
        this.addItem("08-2011");
        this.addItem("09-2011");
        this.addItem("10-2011");
        this.addItem("11-2011");
        this.addItem("12-2011");
    }

    public String getTimeCode(){
        String selectedItem = (String)this.getSelectedItem();
        String[] toke = selectedItem.split("-");
        String timeCode = toke[0]+toke[1];
        return timeCode;
    }


    public String getMonth(){
        String selectedItem = (String)this.getSelectedItem();
        String[] toke = selectedItem.split("-");
        return toke[0];
    }

    public String getYear(){
        String selectedItem = (String)this.getSelectedItem();
        String[] toke = selectedItem.split("-");
        return toke[1];
    }


    public String getMonthName(){
        String[] month = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        };

        int selectedIndex = this.getSelectedIndex();
        
        return month[selectedIndex].toUpperCase();
    }

    

}
