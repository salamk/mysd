/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.student.services;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class CStudentInfo extends JPanel{
    private JTextArea tfText;
    private JScrollPane scroller;

    public CStudentInfo(){
        initComponents();
        designComponents();
        layoutComponents();
    }

    public CStudentInfo(String text){
        initComponents();
        designComponents();
        layoutComponents();
        tfText.setText(text);
    }

    public void initComponents(){
        tfText = new JTextArea(10,10);
        scroller = new JScrollPane(tfText);
    }

    public void designComponents(){
        tfText.setEnabled(false);
        tfText.setBackground(Color.darkGray);
        tfText.setForeground(Color.BLUE);
        tfText.setDisabledTextColor(Color.BLUE);
        scroller.setBackground(this.getBackground());
        scroller.setBorder(null);
        tfText.setBorder(null);
    }

    public void layoutComponents(){
        setLayout(new MigLayout());
        add(scroller,"width 500");
    }

    
}
