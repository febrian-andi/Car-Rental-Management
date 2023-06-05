/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOCustomer;
import DAO.DAORentCar;
import DAOInterface.IDAOCustomer;
import DAOInterface.IDAORentCar;
import Model.Customer;
import Model.RentCar;
import Model.TabelModelCustomer;
import View.CustomerView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kumil
 */
public class ControllerCustomer {
    public ControllerCustomer(CustomerView frmCustomer)
    {
        this.frmCustomer = frmCustomer;
        iCustomer = new DAOCustomer();
        iRentCar = new DAORentCar();
    }
    
    public void isiTable()
    {
        lstCustomer = iCustomer.getAllCustomer();
        TabelModelCustomer tabelCustomer = new TabelModelCustomer(lstCustomer);
        frmCustomer.getTabelCustomer().setModel(tabelCustomer);
    }
    
    public void insert()
    {
        Customer customer = new Customer();
        customer.setId_customer(Integer.parseInt(frmCustomer.getid_customer().getText()));
        customer.setNama(frmCustomer.getnama().getText());
        customer.setAlamat(frmCustomer.getalamat().getText());
        customer.setNo_telpon(frmCustomer.getno_telepon().getText());
        boolean result = iCustomer.insert(customer);
        if(result==true){
            JOptionPane.showMessageDialog(null, "Input Data Berhasil");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Input Data Gagal (Data Duplikat)");            
        }
    }
    
    public void reset(){
        if(!frmCustomer.getid_customer().isEnabled())
            frmCustomer.getid_customer().setEnabled(true);
        frmCustomer.getid_customer().setText("");
        frmCustomer.getnama().setText("");
        frmCustomer.getalamat().setText("");
        frmCustomer.getno_telepon().setText(""); 
    }
    
    public void isiField(int row){
        frmCustomer.getid_customer().setEnabled(false);
        frmCustomer.getid_customer().setText(lstCustomer.get(row).getId_customer().toString());
        frmCustomer.getnama().setText(lstCustomer.get(row).getNama());
        frmCustomer.getalamat().setText(lstCustomer.get(row).getAlamat());
        frmCustomer.getno_telepon().setText(lstCustomer.get(row).getNo_telpon());
    }
    
    public void update(){
        // Dapatkan data nama customer untuk ubah nama customer di tbl_peminjaman (rent car) dan tbl_pengembalian (return car)
        List<Customer> listCustomer = iCustomer.getAllCustomer();
        String namaCustomer = "";
        for ( Customer cst : listCustomer){
            if(cst.getId_customer() == Integer.parseInt(frmCustomer.getid_customer().getText())){
                namaCustomer = cst.getNama();
            }
        }
        
        //ubah data customer di tbl_customer
        Customer customer = new Customer();
        customer.setNama(frmCustomer.getnama().getText());
        customer.setAlamat(frmCustomer.getalamat().getText());
        customer.setNo_telpon(frmCustomer.getno_telepon().getText());
        customer.setId_customer(Integer.parseInt(frmCustomer.getid_customer().getText()));
        iCustomer.update(customer);
        
        // Ubah nama customer di tbl_peminjaman (rent car)
        iCustomer.updateNamaCustomerRentCar(customer, namaCustomer);
        
        // Ubah nama customer di tbl_pengembalian (return car)
        iCustomer.updateNamaCustomerReturnCar(customer, namaCustomer);
        
        JOptionPane.showMessageDialog(null, "Update Data Berhasil");
       
    }
    
    public void delete(){
        int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(option == 0){
            Customer customer = new Customer();
            iCustomer.delete(Integer.parseInt(frmCustomer.getid_customer().getText()));
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        }
    }
    
    
    CustomerView frmCustomer;
    IDAOCustomer iCustomer;
    List<Customer> lstCustomer;
    IDAORentCar iRentCar;
}
