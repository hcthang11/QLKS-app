/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package giaodien;

import entity.KhachHang;
import java.awt.JobAttributes;
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
public class frmKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form frmKhachHang
     */
    private JSplitPane spMain;
    private JPanel spPhai;

    frmKhachHang(JSplitPane spMain, JPanel spPhai) {
        try {
            this.spMain = spMain;
            this.spPhai = spPhai;
            initComponents();
            LoadData2Table();
            LoadData2Control();
        } catch (SQLException ex) {
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoadData2Table() throws SQLException, ClassNotFoundException 
    {
        List<KhachHang> lstKhachHang = dao.daoKhachHang.getAllKH();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã Khách Hàng");
        tblModel.addColumn("Tên Khách Hàng");
        tblModel.addColumn("Địa Chỉ");
        tblModel.addColumn("Số Điện Thoại");
        tblModel.addColumn("CCCD");
        tblModel.addColumn("GioiTinh");
        for(KhachHang _khachhang : lstKhachHang) {
            Vector<String> row = new Vector<String>();
            row.addElement(String.valueOf(_khachhang.getMaKhachHang()));
            row.addElement(String.valueOf(_khachhang.getTenKhachHang()));
            row.addElement(String.valueOf(_khachhang.getDiaChi()));
            row.addElement(String.valueOf(_khachhang.getSoDienThoai()));
            row.addElement(String.valueOf(_khachhang.getCCCD()));
            row.addElement(String.valueOf(_khachhang.getGioiTinh()));
            tblModel.addRow(row);
        }
        tableKhachHang.setModel(tblModel);
    }
    
    private void LoadData2Control() throws SQLException, ClassNotFoundException
    {
        if(tableKhachHang.getSelectedRow() != -1){
            int i = tableKhachHang.getSelectedRow();
            List<KhachHang> lstKhachHang = dao.daoKhachHang.getAllKH();
            KhachHang kh1 = lstKhachHang.get(i);
            //set giá trị cho các control
            txtMaKhachHang.setText(kh1.getMaKhachHang());
            txtTenKhachHang.setText(kh1.getTenKhachHang());
            txtSoDienThoai.setText(kh1.getSoDienThoai());
            txtDiaChi.setText(kh1.getDiaChi());
            txtCCCD.setText(kh1.getCCCD());
            cbGioiTinh.setSelectedItem(kh1.getGioiTinh());
            
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
        jLabel5 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKhachHang = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Mã Khách Hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Tên Khách Hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Địa Chỉ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Số Điện Thoại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("CCCD");

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKhachHang);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\icon\\add.png")); // NOI18N
        jButton1.setText("Thêm ");
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

        btXoa.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon("D:\\JAVA\\icon\\delete.png")); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Giới Tính");

        cbGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("THÔNG TIN KHÁCH HÀNG");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\icon\\customer7.png")); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\icon\\customer7.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKhachHangMouseClicked
        try {
            // TODO add your handling code here:
            LoadData2Control();
        } catch (SQLException ex) {
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableKhachHangMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
            try {
            // TODO add your handling code here:
            dao.daoKhachHang.DeleteKH(txtMaKhachHang.getText());
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btXoaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        KhachHang _khachhang = new KhachHang();
        _khachhang.setMaKhachHang(txtMaKhachHang.getText());
        _khachhang.setTenKhachHang(txtTenKhachHang.getText());
        _khachhang.setSoDienThoai(txtSoDienThoai.getText());
        _khachhang.setDiaChi(txtDiaChi.getText());
        _khachhang.setCCCD(txtCCCD.getText());
        _khachhang.setGioiTinh(cbGioiTinh.getSelectedItem().toString());
  
        try {
            dao.daoKhachHang.InsertKH(_khachhang);
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        KhachHang _khachhang = new KhachHang();
        _khachhang.setMaKhachHang(txtMaKhachHang.getText());
        _khachhang.setTenKhachHang(txtTenKhachHang.getText());
        _khachhang.setSoDienThoai(txtSoDienThoai.getText());
        _khachhang.setDiaChi(txtDiaChi.getText());
        _khachhang.setCCCD(txtCCCD.getText());
        _khachhang.setGioiTinh(cbGioiTinh.getSelectedItem().toString());
        
        try {
            dao.daoKhachHang.UpdateKH(_khachhang);
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
       spMain.setRightComponent(spPhai);
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable tableKhachHang;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}