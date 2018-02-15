/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mysd;

/**
 *
 * @author salam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.setProperty("LOGIN_USER_NAME", "salamk dev");
       System.setProperty("STUDENT_IMAGES_FOLDER","images/student/");
       new InterfaceMajor().setVisible(true);
       //new InterfaceMajor();
       // new FStudentNew();
    }

}
