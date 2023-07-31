/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienich;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class TienIch {
     public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection oConn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");        
        oConn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-NCK66EK\\SQLEXPRESS:1433;"
                               + "database=DATAqlKhachSan;"
                               + "user=sa;"
                               + "password=123;"
                               + "encrypt=false;"
                               + "trustServerCertificate=false;"
                               + "loginTimeout=30;");
        return oConn;
    }

    public static void closeConnection(Connection oConn) throws SQLException {
        if (oConn != null) {
            oConn.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException {
        if (callableStatement != null) {
            callableStatement.close();
        }
    }
    
}
