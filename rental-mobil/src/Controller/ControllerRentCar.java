/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOCar;
import DAO.DAOCustomer;
import DAO.DAORentCar;
import DAOInterface.IDAORentCar;
import Model.Car;
import Model.Customer;
import Model.RentCar;
import Model.TabelModelCar;
import Model.TabelModelRentCar;
import View.RentCarView;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import DAOInterface.IDAOCar;
import DAOInterface.IDAOCustomer;
/**
 *
 * @author user
 */
public class ControllerRentCar {
    RentCarView rentCarPage;
    IDAORentCar iRentCar;
    IDAOCar iCar;
    IDAOCustomer iCustomer;
    List<Car> listCar;
    List<RentCar> listRentCar;

            
    public ControllerRentCar(RentCarView rentCarPage){
        this.rentCarPage = rentCarPage;
        iRentCar = new DAORentCar();
        iCustomer = new DAOCustomer();
        iCar = new DAOCar();
    }

    public void isiTabelMobilTersedia(){
        listCar = iRentCar.getAllCarAvailable();
        TabelModelCar tabelCar = new TabelModelCar(listCar);
        rentCarPage.getTabelMobilTersedia().setModel(tabelCar);
    }

    public void isiFieldPlatNomor(int row){
        rentCarPage.getPlatNomorData().setText(listCar.get(row).getPlatNomor());
    }
    
    public void isiComboBoxNamaCustomer() {
        List<Customer> listCustomer = iCustomer.getAllCustomer();
        rentCarPage.getNamaCustomerData().removeAllItems();
        
        // Tambahkan nama customer ke comboBOX
        for (Customer customer : listCustomer) {
            rentCarPage.getNamaCustomerData().addItem(customer.getNama());
        }
        
        rentCarPage.getNamaCustomerData().setSelectedItem(null);
    }    

    public void isiTabelPeminjamanMobil(){
        listRentCar = iRentCar.getAllRentCarData();
        TabelModelRentCar tabelRentCar = new TabelModelRentCar(listRentCar);
        rentCarPage.getTabelPeminjamanMobil().setModel(tabelRentCar);
    }  
    
    public void insertRentCarData(){
        RentCar b = new RentCar();
        b.setIdPeminjaman(Integer.valueOf(rentCarPage.getIdPeminjamanData().getText()));        
        b.setPlatNomor(rentCarPage.getPlatNomorData().getText());
        b.setNamaCustomer(rentCarPage.getNamaCustomerData().getSelectedItem().toString());
        b.setTglPeminjaman(rentCarPage.getTglPeminjamanData().getDate());
        b.setTglPengembalian(rentCarPage.getTglPengembalianData().getDate());
        b.setTotalHarga(Integer.valueOf(rentCarPage.getTotalHargaData().getText()));
        boolean result = iRentCar.insertRentCar(b);
        
        //Update status mobil ke Booked
        Car c = new Car();
        c.setPlatNomor(rentCarPage.getPlatNomorData().getText());
        iRentCar.updateStatusMobilBooked(c);
        
        if(result==true){
            JOptionPane.showMessageDialog(null, "Input Data Berhasil");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Input Data Gagal (Data Duplikat)");            
        }
    }   
    
    public void reset(){
        if(!rentCarPage.getIdPeminjamanData().isEnabled()){
            rentCarPage.getIdPeminjamanData().setEnabled(true);
        }
        try{
            rentCarPage.getIdPeminjamanData().setText("");
            rentCarPage.getPlatNomorData().setText("");
            rentCarPage.getNamaCustomerData().setSelectedItem(null);         
            rentCarPage.getTglPeminjamanData().setDate(null);
            rentCarPage.getTglPengembalianData().setDate(null);
            rentCarPage.getTotalHargaData().setText("");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public void isiField(int row){
        rentCarPage.getIdPeminjamanData().setEnabled(false);
        rentCarPage.getIdPeminjamanData().setText(listRentCar.get(row).getIdPeminjaman().toString());
        rentCarPage.getPlatNomorData().setText(listRentCar.get(row).getPlatNomor());
        rentCarPage.getNamaCustomerData().setSelectedItem(listRentCar.get(row).getNamaCustomer());
        rentCarPage.getTglPeminjamanData().setDate(listRentCar.get(row).getTglPeminjaman());
        rentCarPage.getTglPengembalianData().setDate(listRentCar.get(row).getTglPengembalian());
        rentCarPage.getTotalHargaData().setText(listRentCar.get(row).getTotalHarga().toString());
    }
    
    public void updateRentCarData(){
        List<RentCar> listRentCar =  iRentCar.getAllRentCarData();
        Integer totalHarga = Integer.valueOf(rentCarPage.getTotalHargaData().getText());
        String platNomor = rentCarPage.getPlatNomorData().getText();
        Integer idPeminjaman = Integer.valueOf(rentCarPage.getIdPeminjamanData().getText());
        
        if (totalHarga != null ){
            for (RentCar rentCar : listRentCar){
                if(rentCar.getIdPeminjaman() == idPeminjaman){
                    if(!rentCar.getPlatNomor().equals(platNomor)){
                        //Ubah status mobil ke Available
                        Car c = new Car();
                        c.setPlatNomor(rentCarPage.getPlatNomorData().getText());
                        iRentCar.updateStatusMobilBooked(c);

                        //Ubah status mobil ke Booked
                        Car d = new Car();
                        d.setPlatNomor(rentCar.getPlatNomor());
                        System.out.println(rentCar.getPlatNomor());
                        System.out.println(platNomor);
                        System.out.println(c.getPlatNomor());
                        iRentCar.updateStatusMobilAvailable(d);
                    }
                }
            }
        }
        
        RentCar b = new RentCar();
        b.setNamaCustomer(rentCarPage.getNamaCustomerData().getSelectedItem().toString());
        b.setPlatNomor(rentCarPage.getPlatNomorData().getText());
        b.setTglPeminjaman(rentCarPage.getTglPeminjamanData().getDate());
        b.setTglPengembalian(rentCarPage.getTglPengembalianData().getDate());
        b.setTotalHarga(Integer.valueOf(rentCarPage.getTotalHargaData().getText()));
        b.setIdPeminjaman(Integer.valueOf(rentCarPage.getIdPeminjamanData().getText()));
        iRentCar.updateRentCar(b);
        
        JOptionPane.showMessageDialog(null, "Update Data Berhasil");
    }    
    
    public void deleteRentCarData(){
        int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(option == 0){
            Integer idPeminjaman = Integer.parseInt(rentCarPage.getIdPeminjamanData().getText());
            iRentCar.deleteRentCar(idPeminjaman);

            //Ubah status mobil ke Available
            Car b = new Car();
            b.setPlatNomor(rentCarPage.getPlatNomorData().getText());
            iRentCar.updateStatusMobilAvailable(b);        

            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        }
    }

    public void generateFee(){
        List<Car> listCar = iCar.getAllCar();
        String platNomor = rentCarPage.getPlatNomorData().getText();
        Integer price = null;
        Date tglPeminjaman = rentCarPage.getTglPeminjamanData().getDate();
        Date tglPengembalian = rentCarPage.getTglPengembalianData().getDate();
        
        for (Car car : listCar) {
             if (car.getPlatNomor().equals(platNomor)){
                price = car.getHarga();
             }
        }
        LocalDate datePeminjaman = tglPeminjaman.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate datePengembalian = tglPengembalian.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        Period period = Period.between(datePeminjaman, datePengembalian);
        Integer daysDiff = period.getDays();
        Integer fee = null;
        
        if(daysDiff > 0) {
            if (daysDiff == 0) {
                fee = price;
            } else {
                fee = price * daysDiff;
            }
        }
        rentCarPage.getTotalHargaData().setText(fee.toString());        
    }
    
    public void resetFee(){
        rentCarPage.getTotalHargaData().setText("");
    }
}
