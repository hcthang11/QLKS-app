/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package giaodien;

import entity.HoaDon;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class frmHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form frmHoaDon
     */
private JSplitPane spMain;
private JPanel spPhai;
    frmHoaDon(JSplitPane spMain, JPanel spPhai) {
        try {
            this.spMain = spMain;
            this.spPhai= spPhai;
            initComponents();
            LoadData2Table();
        } catch (SQLException ex) {
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void LoadData2Table() throws SQLException, ClassNotFoundException 
    {
        List<HoaDon> lstHoaDon = dao.daoHoaDon.getAllHD();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã Hóa Đơn");
        tblModel.addColumn("Mã Khách Hàng");
        tblModel.addColumn("Tổng Thanh Toán");
        tblModel.addColumn("Tài Khoản");
        for(HoaDon _hoadon : lstHoaDon) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(_hoadon.getMaHoaDon()));
            row.addElement(String.valueOf(_hoadon.getMaKhachHang()));
            row.addElement(String.valueOf(_hoadon.getTongThanhToan()));
            row.addElement(String.valueOf(_hoadon.getTaiKhoan()));
            tblModel.addRow(row);
        }
        tableHoaDon.setModel(tblModel);
    }
      private void LoadData3Control() throws SQLException, ClassNotFoundException
    {
        if(tableHoaDon.getSelectedRow() != -1){
            //xác định hàng đc click
            int i = tableHoaDon.getSelectedRow();
            //lấy được danh sách khách hàng
            List<HoaDon> lstHoaDon = dao.daoHoaDon.getAllHD();
            //xác định khách hàng nào đang được Click
            HoaDon hd1 = lstHoaDon.get(i);
            //set giá trị cho các control
            txtMaHoaDon.setText(hd1.getMaHoaDon());
            txtMaKhachHang.setText(hd1.getMaKhachHang());
            txtTaiKhoan.setText(hd1.getTaiKhoan());
            txtTongThanhToan.setText(String.valueOf(hd1.getTongThanhToan()));          
           }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTongThanhToan = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoaDon = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Mã Hóa Đơn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Mã Khách Hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Tổng Thanh Toán");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Tài Khoản");

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtTongThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHoaDon);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\icon\\add.png")); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\icon\\fix.png")); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\icon\\delete.png")); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\icon\\exit.png")); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\icon\\bill222.png")); // NOI18N
        jLabel5.setText("THÔNG TIN HÓA ĐƠN");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\icon\\bill222.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(98, 98, 98)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(84, 84, 84)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHoaDonMouseClicked
        // TODO add your handling code here:
        try {
            LoadData3Control();
        } catch (SQLException ex) {
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableHoaDonMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
             try {
           
            dao.daoHoaDon.DeleteHD(txtMaHoaDon.getText());
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         HoaDon _hoadon = new HoaDon();
        _hoadon.setMaHoaDon(txtMaHoaDon.getText());
        _hoadon.setMaKhachHang(txtMaKhachHang.getText());
        _hoadon.setTongThanhToan(Float.valueOf(txtTongThanhToan.getText()));
        _hoadon.setTaiKhoan(txtTaiKhoan.getText());
  
        try {
            dao.daoHoaDon.InsertHD(_hoadon);
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
          HoaDon _hoadon = new HoaDon();
        _hoadon.setMaHoaDon(txtMaHoaDon.getText());
        _hoadon.setMaKhachHang(txtMaKhachHang.getText());
        _hoadon.setTongThanhToan(Float.valueOf(txtTongThanhToan.getText()));
        _hoadon.setTaiKhoan(txtTaiKhoan.getText());
    
        try {
            dao.daoHoaDon.UpdateHD(_hoadon);
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        spMain.setRightComponent(spPhai);
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tableHoaDon;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTongThanhToan;
    // End of variables declaration//GEN-END:variables
}