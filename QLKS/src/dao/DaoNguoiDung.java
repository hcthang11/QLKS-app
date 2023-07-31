/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NguoiDung;
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
public class DaoNguoiDung {
    public static List<NguoiDung> getAllND() throws SQLException, ClassNotFoundException
    {
        List<NguoiDung> lstNguoiDung = new ArrayList<>();
        //--- Kết nối CSDL, lấy dữ liệu
        Connection cnn = tienich.TienIch.getConnection();
        //-- Xây dựng câu lệnh truy vấn
        String sql = "select * from DangNhap";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        //-- Xử lý kết quả trả về
        while(rs.next())
        {
            NguoiDung ndx = new NguoiDung();
            ndx.setTaiKhoan(rs.getString("TaiKhoan"));
            ndx.setMatkhau(rs.getString("Matkhau"));
            lstNguoiDung.add(ndx);
        }
        return lstNguoiDung;
    }
    // get 1 người dùng
    public static List<NguoiDung> getOneND(String _taikhoan, String _pass) throws SQLException, ClassNotFoundException
    {
        List<NguoiDung> lstNguoiDung = new ArrayList<>();
        //--- Kết nối CSDL, lấy dữ liệu
        Connection cnn = tienich.TienIch.getConnection();
        //-- Xây dựng câu lệnh truy vấn
        String sql = "select * from DangNhap where TaiKhoan = '"+_taikhoan+"' and Matkhau = '"+_pass+"'";
        // -- Thực thi câu lệnh truy vấn
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        //-- Xử lý kết quả trả về
        while(rs.next())
        {
            NguoiDung ndx = new NguoiDung();
            ndx.setTaiKhoan(rs.getString("TaiKhoan"));
            ndx.setMatkhau(rs.getString("Matkhau"));
            lstNguoiDung.add(ndx);
        }
        return lstNguoiDung;
}}
