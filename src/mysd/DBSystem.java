/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author salamk
 */
public class DBSystem {
    String driver = "com.mysql.jdbc.Driver";
    String url = "";
    String user = "root";
    String password = "trinitron";

    public DBSystem(){
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/mys";
        user = "root";
        password = "trinitron";
//        url =  "jdbc:mysql://mysql6.000webhost.com:3306/a1835956_mys";
//        user =  "a1835956_salamk";
//        password =  "trinitron123";
    }

    public DBSystem(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection(){

        Connection con = null;

        try{
            Class.forName(driver);
        }catch(Exception e){
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/"+caller+"/"+method+"/"
                    + "\nInside(DBSystem/getConnection\n"
                    + ""+e.getMessage());
        }

        try{
            con = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/"+caller+"/"+method+"/"
                    + "\nInside(DBSystem/getConnection\n"
                    + ""+e.getMessage());
        }

        return con;

    }


    public void closeConnection(Connection con){
        //String closed = "";
        try{
            con.close();
            //closed = "";
        }catch(Exception e){
            String caller = e.getStackTrace()[1].getClassName();
            String method = e.getStackTrace()[1].getMethodName();
            JOptionPane.showMessageDialog(null,
                    "SysMsg:/"+caller+"/"+method+"/"
                    + "\nInside(DBSystem/closeConnection\n"
                    + ""+e.getMessage());
        }


    }


    public String getLoginUser(){
        return "dev";
    }


    public String getTransactionTime(){
        return "";
    }




}
