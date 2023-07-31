/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietPhong;
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
public class daoChiTietPhong {
    
     public static List<ChiTietPhong> getAllctp() throws SQLException, ClassNotFoundException 
    {
         List<ChiTietPhong> lstChiTietPhong = new ArrayList<>();
        
         Connection cnn = tienich.TienIch.getConnection();
        
        String sql = "select * from ChiTietPhong   ";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        
        while(rs.next())
        {
            ChiTietPhong ctpx  = new ChiTietPhong();
            ctpx.setLoaiPhong(rs.getString("LoaiPhong"));
            ctpx.setDienTich(rs.getFloat("DienTich"));
            ctpx.setGiaPhong(rs.getFloat("GiaPhong"));
            lstChiTietPhong.add(ctpx);
        }
        return lstChiTietPhong;
    }
      public static void Insertctp( ChiTietPhong ctpx) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        //-- Xác định câu lệnh truy vấn
        String sql = "insert into ChiTietPhong(LoaiPhong,DienTich,GiaPhong) values ('"+ctpx.getLoaiPhong()+"','"+ctpx.getDienTich()+"','"+ctpx.getGiaPhong()+"')";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        // đóng kết nối
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
    
       
        public static void Deletectp(String _LoaiPhong) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        String sql = "delete from ChiTietPhong where LoaiPhong = '"+_LoaiPhong+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        // -- Đóng kết nối
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
           public static void Updatepctp(ChiTietPhong ctpx) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        String sql = "update ChiTietPhong set DienTich = '"+ctpx.getDienTich()+"',GiaPhong = '"+ctpx.getGiaPhong()+"' where LoaiPhong = '"+ctpx.getLoaiPhong()+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        // -- Đóng kết nối
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
}
