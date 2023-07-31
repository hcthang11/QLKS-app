/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KhachHang;
import entity.ThuePhong;
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
public class daoKhachHang {
    public static List<KhachHang> getAllKH() throws SQLException, ClassNotFoundException
    {    //getall
        List<KhachHang> lstThongTin = new ArrayList<>();
        Connection cnn = tienich.TienIch.getConnection();
        String sql = "select * from KhachHang";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            KhachHang kh1 = new KhachHang();
            kh1.setMaKhachHang(rs.getString("MaKhachHang"));
            kh1.setTenKhachHang(rs.getString("TenKhachHang"));
            kh1.setSoDienThoai(rs.getString("SoDienThoai"));
            kh1.setDiaChi(rs.getString("DiaChi"));
            kh1.setCCCD(rs.getString("CCCD"));
            kh1.setGioiTinh(rs.getString("GioiTinh"));
            lstThongTin.add(kh1);
        }
        return lstThongTin;
    }

    // Insert One
    public static void InsertKH(KhachHang kh1) throws SQLException, ClassNotFoundException
    {
        Connection conn = tienich.TienIch.getConnection();
        String sql = "insert into KhachHang(MaKhachHang,TenKhachHang,SoDienThoai,DiaChi,CCCD,GioiTinh) values (N'"+kh1.getMaKhachHang()+"','"+kh1.getTenKhachHang()+"','"+kh1.getSoDienThoai()+"','"+kh1.getDiaChi()+"','"+kh1.getCCCD()+"','"+kh1.getGioiTinh()+"')";        
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
    // Update One
     public static void UpdateKH(KhachHang kh1) throws SQLException, ClassNotFoundException
    {
        Connection conn = tienich.TienIch.getConnection();
        String sql = "update KhachHang set TenKhachHang = '"+kh1.getTenKhachHang()+"', SoDienThoai = '"+kh1.getSoDienThoai()+"', DiaChi = '"+kh1.getDiaChi()+"', CCCD = '"+kh1.getCCCD()+"', GioiTinh = '"+kh1.getGioiTinh()+"' where MaKhachHang = '"+kh1.getMaKhachHang()+"' ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    } 
     
        // Delete One   
    public static void DeleteKH(String _MaKhachHang) throws SQLException, ClassNotFoundException
    {
        Connection conn = tienich.TienIch.getConnection();
        String sql = "delete from KhachHang where MaKhachHang = '"+_MaKhachHang+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
}
