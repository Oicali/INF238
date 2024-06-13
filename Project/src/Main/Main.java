package Main;

import java.sql.*;
import otherForms.*;

public class Main {

    public static String username = "";
    public static String userPosition = "";
    public static String status = "";
    private static String storedPassword = "";
    public static int lowerLimit = 25;

    private static Connection con = null;
//    public static String fname = "";
//    public static String fullname = "";
//    public static String mname = "";
//    public static String lname = "";
    //public static String sname = "";
    //public static String gender = "";
    //public static String number = "";
    //public static String birth = "";

//    public static String email = "";
    //public static String date = "";
    //public static byte[] imageBytes;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                progressScreen loading = new progressScreen(null, true);
                loading.setVisible(true);

                new logIn().show();

            }
        });
    }

    // Code for Database Connection
    public static Connection getDbCon() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_system", "root", "#MySQL2220");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return con;

    }

    public static void closeCon() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    

    // Encapsulate Password
    public static String getStoredPassword() {
        return storedPassword;
    }

    public static void setStoredPassword(String aStoredPassword) {
        storedPassword = aStoredPassword;
    }
}
