package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class InsertData {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter user_id: ");
        int userID = input.nextInt();
        
        System.out.print("Enter user_name: ");
        String userName = input.next();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/login_schema";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO USER_TABLE(user_id, user_name) VALUES (?, ?)";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, userName);
            
            int status = pstmt.executeUpdate();
            
            if (status > 0) {
                System.out.println("Inserted!");
            } else {
                System.out.println("Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        input.close();
    }
}
