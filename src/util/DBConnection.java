
package util;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class DBConnection {
    
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        //-----------------------INSERT---------------------------
        System.out.println("----------------------------------For Insert-----------------------");
        System.out.print("Enter your id: ");
        int userID = input.nextInt();
        
        System.out.print("Enter your name: ");
        String userName = input.next();
        
        //-------------------------------DELETE--------------------------
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("------------------------------For DELETE---------------------------");
        System.out.print("Enter your id for delete: ");
        int userIDDelete = input.nextInt();
        
        //-------------------------------UPDATE--------------------------
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("------------------------------For Update------------------------------");
        System.out.print("Enter your id: ");
        int userIDUpdate = input.nextInt();
        System.out.print("Enter your name: ");
        String userNameUpdate = input.next();
        
        
        
        String sqlInsert = "INSERT INTO TEST (user_id, user_name) VALUES ('"+userID+"', '"+userName+"')";
        String sqlDelete = "DELETE FROM TEST WHERE user_id = '"+userIDDelete+"'";
        String sqlUpdate = "UPDATE TEST SET user_name = '"+userNameUpdate+"' WHERE user_id = '"+userIDUpdate+"'";
        
        Properties prop = new Properties();
        
        try {
            InputStream dbFile = new FileInputStream("C:\\Users\\Abdul Mannan.DESKTOP-EJ6PFLI\\Documents\\Java\\swing_jdbc_id\\src\\db.properties");
            prop.load(dbFile);
            
            String url = prop.getProperty("dburl");
            String user = prop.getProperty("dbusername");
            String password = prop.getProperty("dbpassword");
//            System.out.println(url +" " + user+ " " + password);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Test successful"); 
            
            // ----------------------------INSERT--------------------------------
            
            Statement stmt = connection.createStatement();
            int status = stmt.executeUpdate(sqlInsert);
            
            if (status > 0) {
                System.out.println("inserted");
            } else {
                System.out.println("failed");
            }
            stmt.close();
            
            // ----------------------------DELETE--------------------------------
                        
            Statement stmtDelete = connection.createStatement();
            
            int statusDelete = stmtDelete.executeUpdate(sqlDelete);
            
            if (statusDelete > 0) {
                System.out.println("Deleted");
            } else {
                System.out.println("failed");
            }
            
            stmtDelete.close();
                      
            // ----------------------------UPDATE--------------------------------

            
            Statement stmtUpdate = connection.createStatement();
            
            int statusUpdate = stmtUpdate.executeUpdate(sqlUpdate);
            
            if (statusUpdate > 0) {
                System.out.println("Updated");
               
            } else {
                System.out.println("failed");
            }
            stmtUpdate.close();
                    
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        input.close();
    }
}
