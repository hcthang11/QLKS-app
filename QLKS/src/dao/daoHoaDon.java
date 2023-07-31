/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daoHoaDon {
    
    //getall
    public static List<HoaDon> getAllHD() throws SQLException, ClassNotFoundException
    {    //getall
        List<HoaDon> lstThongTinHoaDon = new ArrayList<>();
        //--- Kết nối CSDL, lấy dữ liệu
        Connection cnn = tienich.TienIch.getConnection();
        //-- Xây dựng câu lệnh truy vấn
        String sql = "select * from HoaDon";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            HoaDon hd1 = new HoaDon();
            hd1.setMaHoaDon(rs.getString("MaHoaDon"));
            hd1.setMaKhachHang(rs.getString("MaKhachHang"));
            hd1.setTongThanhToan(rs.getFloat("TongThanhToan"));
            hd1.setTaiKhoan(rs.getString("TaiKhoan")); 
            lstThongTinHoaDon.add(hd1);
        }
        return lstThongTinHoaDon;
    }
     //Delete One
     public static void DeleteHD(String _MaHoaDon) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        String sql = "delete from HoaDon where MaHoaDon = '"+_MaHoaDon+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
      // Insert One
    public static void InsertHD(HoaDon hd1) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        
        //-- Xác định câu lệnh truy vấn
         String sql = "insert into HoaDon(MaHoaDon,MaKhachHang,TongThanhToan,TaiKhoan) values (N'"+hd1.getMaHoaDon()+"','"+hd1.getMaKhachHang()+"','"+hd1.getTongThanhToan()+"','"+hd1.getTaiKhoan()+"')";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        // đóng kết nối
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
      // Update One
     public static void UpdateHD(HoaDon hd1) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
       
       String sql = "update HoaDon set MaKhachHang = '"+hd1.getMaKhachHang()+"', TongThanhToan = '"+hd1.getTongThanhToan()+"', TaiKhoan = '"+hd1.getTaiKhoan()+"' where MaHoaDon = '"+hd1.getMaHoaDon()+"' ";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
}
