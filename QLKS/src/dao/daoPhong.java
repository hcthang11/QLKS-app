/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daoPhong {
    //getall
     public static List<Phong> getAllphong() throws SQLException, ClassNotFoundException 
    {
        List<Phong> lstPhong = new ArrayList<>();
        
         Connection cnn = tienich.TienIch.getConnection();
        
        String sql = "select * from Phong   ";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        
        while(rs.next())
        {
            Phong px = new Phong();
            px.setMaPhong(rs.getString("MaPhong"));
            px.setTenPhong(rs.getString("TenPhong"));
            px.setLoaiPhong(rs.getString("LoaiPhong"));
           
            lstPhong.add(px);
        }
        return lstPhong;
    }
        
     public static void Insertphong( Phong px) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        //-- Xác định câu lệnh truy vấn
        String sql = "insert into Phong(MaPhong,TenPhong,LoaiPhong) values ('"+px.getMaPhong()+"','"+px.getTenPhong()+"','"+px.getLoaiPhong()+"')";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        // đóng kết nối
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
    
       
        public static void Deletephong(String _MaPhong) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        String sql = "delete from Phong where MaPhong = '"+_MaPhong+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
           public static void Updatephong(Phong px) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        String sql = "update Phong set TenPhong = '"+px.getTenPhong()+"',LoaiPhong = '"+px.getLoaiPhong()+"' where MaPhong = '"+px.getMaPhong()+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
    
}
