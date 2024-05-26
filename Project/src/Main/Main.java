
package Main;

import java.sql.*;
import otherForms.*;


public class Main {
    
    public static String username = "";
    public static String selectedRole = "";
    public static String fname = "";
    public static String mname = "";
    public static String lname = "";
    public static String gender = "";
    public static String number = "";
    public static String birth = "";
    public static String storedPassword = "";
    public static String email = "";
    public static String date = "";
    public static byte[] imageBytes;

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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_system", "root", "#MySQL2220");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static void closeCon() {
        try {
            if (getDbCon() != null) {
                getDbCon().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

