/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd.student.services;

import acr.component.CAlphaNumericField;
import acr.component.CTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysd.StandardFormInterface;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author salam
 */
public class FStudentImage implements StandardFormInterface{
    protected CAlphaNumericField tfStudentID;
    protected CTextField tfStudentPic;
    protected JButton btnBrowse;
    protected JPanel pnlMain;

    public FStudentImage(){
        initComponents();
        setCharacterLimits();
        designComponents();
        layoutComponents();
        JOptionPane.showMessageDialog(null,pnlMain);
    }

    public void designComponents() {

    }

    public void initComponents() {
        tfStudentID = new CAlphaNumericField();
        tfStudentPic = new CTextField();
        btnBrowse = new JButton("Browse");
        final JFileChooser fileChooser = new JFileChooser();
        btnBrowse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int answer = fileChooser.showOpenDialog(pnlMain);
                if(answer == JFileChooser.APPROVE_OPTION){
                    String fileName = fileChooser.getSelectedFile().getAbsolutePath();
                    tfStudentPic.setText(fileName);
                }
            }
        });
        pnlMain = new JPanel();

    }

    public void layoutComponents() {
        pnlMain.setLayout(new MigLayout());

        JPanel q = new JPanel();
        q.setLayout(new MigLayout());
        q.add(new JLabel("Student ID"));
        q.add(tfStudentID, "gapleft 0,width 120, wrap");

        JPanel p = new JPanel();
        p.setLayout(new MigLayout());
        p.add(new JLabel("Picture"));
        p.add(tfStudentPic,"width 250");
        p.add(btnBrowse);
        p.setBorder(BorderFactory.createRaisedBevelBorder());

        pnlMain.add(q,"wrap");
        pnlMain.add(p,"gaptop 0");


    }

    public void setCharacterLimits() {

    }


    public static void main(String[] args){
        new FStudentImage();
    }








}
