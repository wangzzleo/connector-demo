package xyz.wangzzleo;

import java.lang.reflect.Method;
import java.sql.*;

public class Demo {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Set your connection parameters
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false" +
                    "&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","12345678");
            // Set the breakpoint here or sleep the thread
            // Next, close the MySQL service and continue.
            Thread.sleep(30 * 1000);
            Method pingInternal = conn.getClass().getMethod("pingInternal", boolean.class, int.class);
            pingInternal.invoke(conn, true, 1000);
        } catch (Exception e) {
            //
            e.printStackTrace();
        } finally {
            try{
                if(statement!=null) statement.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

}
