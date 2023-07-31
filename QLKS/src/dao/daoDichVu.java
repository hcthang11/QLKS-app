/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.DichVu;
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
public class daoDichVu {
    public static List<DichVu> getAllDV() throws SQLException, ClassNotFoundException
    {    //getall
        List<DichVu> lstThongTinDichVu = new ArrayList<>();
        //--- Kết nối CSDL, lấy dữ liệu
        Connection cnn = tienich.TienIch.getConnection();
        //-- Xây dựng câu lệnh truy vấn
        String sql = "select * from DichVu";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            DichVu dv1 = new DichVu();
            dv1.setMaDichVu(rs.getString("MaDichVu"));
            dv1.setTenDichVu(rs.getString("TenDichVu"));
            dv1.setMaKhachHang(rs.getString("MaKhachHang"));
            dv1.setNgayBatDauSuDung(rs.getDate("NgayBatDauSuDung"));
            dv1.setNgayKetThucSuDung(rs.getDate("NgayKetThucSuDung"));
            dv1.setGiaDichVu(rs.getFloat("GiaDichVu"));
            lstThongTinDichVu.add(dv1);
        }
        return lstThongTinDichVu;
    }
    //Delete One
     public static void DeleteDV(String _MaDichVu) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        String sql = "delete from DichVu where MaDichVu = '"+_MaDichVu+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
     
     //INSERT
     public static void InsertDV(DichVu dv1) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        
        //-- Xác định câu lệnh truy vấn
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String startDate = dateFormat.format(dv1.getNgayBatDauSuDung());
         String endDate = dateFormat.format(dv1.getNgayKetThucSuDung());
         
         String sql = "insert into DichVu (MaDichVu,TenDichVu,MaKhachHang,NgayBatDauSuDung,NgayKetThucSuDung,GiaDichVu) values (N'"+dv1.getMaDichVu()+"','"+dv1.getTenDichVu()+"','"+dv1.getMaKhachHang()+"','"+startDate+"','"+endDate+"','"+dv1.getGiaDichVu()+"')";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        // đóng kết nối
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
      // Update One
     public static void UpdateDV(DichVu dv1) throws SQLException, ClassNotFoundException
    {
        // Mở kết nối - xác định câu lệnh truy vấn -> thực thi
        Connection conn = tienich.TienIch.getConnection();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String startDate = dateFormat.format(dv1.getNgayBatDauSuDung());
         String endDate = dateFormat.format(dv1.getNgayKetThucSuDung());
       String sql = "update DichVu set TenDichVu = '"+dv1.getTenDichVu()+"', MaKhachHang = '"+dv1.getMaKhachHang()+"', NgayBatDauSuDung = '"+startDate+"', NgayKetThucSuDung = '"+endDate+"', GiaDichVu = '"+dv1.getGiaDichVu()+"' where MaDichVu = '"+dv1.getMaDichVu()+"' ";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
    
}
