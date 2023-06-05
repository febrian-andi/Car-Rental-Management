/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAORentCar;
import DAO.DAOReturnCar;
import DAOInterface.IDAORentCar;
import DAOInterface.IDAOReturnCar;
import Model.Car;
import Model.RentCar;
import Model.ReturnCar;
import Model.TabelModelRentCar;
import Model.TabelModelReturnCar;
import View.ReturnCarView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ControllerReturn 
{
    ReturnCarView returnCarPage;
    IDAORentCar iRentCar;
    List<RentCar> listRentCar;
    IDAOReturnCar iReturnCar;
    List<ReturnCar> listReturnCar;
    
     public ControllerReturn(ReturnCarView returnCarPage){
        this.returnCarPage = returnCarPage;
        iRentCar = new DAORentCar();
        iReturnCar= new DAOReturnCar();
    }
     
     
    public void isiTabelPeminjamanMobil(){
        listRentCar = iRentCar.getAllRentCarData();
        TabelModelRentCar tabelRentCar = new TabelModelRentCar(listRentCar);
        returnCarPage.getTabelPeminjamanMobil().setModel(tabelRentCar);
    }
    
    
    public Integer isiField(int row){
        returnCarPage.getPlatNomorData().setText(listRentCar.get(row).getPlatNomor());
        returnCarPage.getNamaCustomerData().setText(listRentCar.get(row).getNamaCustomer());
        Integer idPeminjaman = listRentCar.get(row).getIdPeminjaman();
        return idPeminjaman;
        
    }
    
    public void isiTabelPengembalianMobil(){
        listReturnCar = iReturnCar.getAll();
        TabelModelReturnCar tabelReturnCar = new TabelModelReturnCar(listReturnCar);
        returnCarPage.getTabelPengembalianMobil().setModel(tabelReturnCar);
    }
    
    public Integer generateDenda(){
        Integer delay = Integer.valueOf(returnCarPage.getDelay().getText());
        Integer denda = delay * 50000;
        returnCarPage.getDenda().setText(denda.toString());
        
        return denda;
    }
    
    public Integer totalBayar(){
        List<RentCar> listRentCar = iRentCar.getAllRentCarData();
        String platNomor = returnCarPage.getPlatNomorData().getText();
        Integer fee = null;        
        
        for (RentCar rentCar : listRentCar) {
             if (rentCar.getPlatNomor().equals(platNomor)){
                fee = rentCar.getTotalHarga();
             }
        }
        
        Integer totalBayar = fee + generateDenda();
        
        return totalBayar;
    }
    
    public void insertReturnCarData(int row){
        int option = JOptionPane.showConfirmDialog(null, "Apakah Data Yang Diisikan Sudah Benar ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(option == 0){
            ReturnCar b = new ReturnCar();
            b.setIdPengembalian(Integer.valueOf(returnCarPage.getIdPengembalian().getText()));        
            b.setPlatNomor(returnCarPage.getPlatNomorData().getText());
            b.setNamaCustomer(returnCarPage.getNamaCustomerData().getText());
            b.setTglPengembalian(returnCarPage.getTglPengembalianData().getDate());
            b.setDelay(Integer.valueOf(returnCarPage.getDelay().getText()));
            b.setDenda(Integer.valueOf(returnCarPage.getDenda().getText()));
            b.setTotal_bayar(totalBayar());
            boolean result = iReturnCar.insertReturnCar(b);

            //Update data di tabel Peminjaman
                Integer idPeminjaman = isiField(row);
                iRentCar.deleteRentCar(idPeminjaman);

                //Ubah status mobil ke Available
                Car c = new Car();
                c.setPlatNomor(returnCarPage.getPlatNomorData().getText());
                iRentCar.updateStatusMobilAvailable(c);

            if(result==true){
                JOptionPane.showMessageDialog(null, "Input Data Berhasil");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Input Data Gagal (Data Duplikat)");            
            }
        }    
    } 
    
    public void reset(){
        try{
            returnCarPage.getIdPengembalian().setText("");
            returnCarPage.getPlatNomorData().setText("");
            returnCarPage.getNamaCustomerData().setText("");         
            returnCarPage.getTglPengembalianData().setDate(null);
            returnCarPage.getDenda().setText("");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
