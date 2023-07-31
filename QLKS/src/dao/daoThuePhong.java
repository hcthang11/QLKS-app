/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.ThuePhong;
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
public class daoThuePhong {
    //getall
    public static List<ThuePhong> getAllTP() throws SQLException, ClassNotFoundException
    {    //getall
        List<ThuePhong> lstThongTinThuePhong = new ArrayList<>();
     
        Connection cnn = tienich.TienIch.getConnection();
     
        String sql = "select * from ThuePhong";
        PreparedStatement pStmt = cnn.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            ThuePhong tp1 = new ThuePhong();
            tp1.setMaThuePhong(rs.getString("MaThuePhong"));
            tp1.setMaKhachHang(rs.getString("MaKhachHang"));
            tp1.setMaPhong(rs.getString("MaPhong"));
            tp1.setNgayBatDau(rs.getDate("NgayBatDau"));
            tp1.setNgayKetThuc(rs.getDate("NgayKetThuc"));
            tp1.setThanhTien(rs.getFloat("ThanhTien"));
            lstThongTinThuePhong.add(tp1);
        }
        return lstThongTinThuePhong;
    }

      // Insert One
    public static void InsertTP(ThuePhong tp1) throws SQLException, ClassNotFoundException
    {        
        Connection conn = tienich.TienIch.getConnection();       
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String startDate = dateFormat.format(tp1.getNgayBatDau());
         String endDate = dateFormat.format(tp1.getNgayKetThuc());
         String sql = "insert into ThuePhong(MaThuePhong,MaKhachHang,MaPhong,NgayBatDau,NgayKetThuc,ThanhTien) values (N'"+tp1.getMaThuePhong()+"','"+tp1.getMaKhachHang()+"','"+tp1.getMaPhong()+"','"+startDate+"','"+endDate+"','"+tp1.getThanhTien()+"')";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
    //Delete One
     public static void DeleteTP(String _MaThuePhong) throws SQLException, ClassNotFoundException
    { 
        Connection conn = tienich.TienIch.getConnection();
        String sql = "delete from ThuePhong where MaThuePhong = '"+_MaThuePhong+"'";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }
     
       // Update One
     public static void UpdateTP(ThuePhong tp1) throws SQLException, ClassNotFoundException
    {
        
        Connection conn = tienich.TienIch.getConnection();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String startDate = dateFormat.format(tp1.getNgayBatDau());
         String endDate = dateFormat.format(tp1.getNgayKetThuc());
       String sql = "update ThuePhong set MaKhachHang = '"+tp1.getMaKhachHang()+"', MaPhong = '"+tp1.getMaPhong()+"', NgayBatDau = '"+startDate+"', NgayKetThuc= '"+endDate+"', ThanhTien = '"+tp1.getThanhTien()+"' where MaThuePhong = '"+tp1.getMaThuePhong()+"' ";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.executeUpdate();
        tienich.TienIch.closePreparedStatement(pStmt);
        tienich.TienIch.closeConnection(conn);
    }

 

  
      }
