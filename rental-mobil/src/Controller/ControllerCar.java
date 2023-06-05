/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOCar;
import View.CarView;
import java.util.List;
import Model.Car;
import Model.TabelModelCar;
import javax.swing.JOptionPane;
import DAOInterface.IDAOCar;

public class ControllerCar {
    CarView carPage;
    IDAOCar iCar;
    List<Car> listCar;  
    
    public ControllerCar(CarView carPage){
        this.carPage = carPage;
        iCar = new DAOCar();
        iCar.getAllCar();
    }
    
    public void isiTabel(){
        listCar = iCar.getAllCar();
        TabelModelCar tabelCar = new TabelModelCar(listCar);
        carPage.getTabelData().setModel(tabelCar);
    }

    public void insertData(){
        Car b = new Car();
        b.setPlatNomor(carPage.getPlatNomorData().getText());
        b.setMerek(carPage.getMerekData().getText());
        b.setStatus(carPage.getStatusData().getSelectedItem().toString());
        b.setHarga(Integer.valueOf(carPage.getHargaData().getText()));
        boolean result = iCar.insert(b);
        if(result==true){
            JOptionPane.showMessageDialog(null, "Input Data Berhasil");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Input Data Gagal (Data Duplikat)");            
        }
    }
    
    public void reset(){
        if(!carPage.getPlatNomorData().isEnabled()){
            carPage.getPlatNomorData().setEnabled(true);
        }
        carPage.getPlatNomorData().setText("");
        carPage.getMerekData().setText("");
        carPage.getStatusData().setSelectedItem("Available");
        carPage.getHargaData().setText("");
    }
    
    public void isiField(int row){
        carPage.getPlatNomorData().setEnabled(false);
        carPage.getPlatNomorData().setText(listCar.get(row).getPlatNomor());
        carPage.getMerekData().setText(listCar.get(row).getMerek());
        carPage.getStatusData().setSelectedItem(listCar.get(row).getStatus());
        carPage.getHargaData().setText(listCar.get(row).getHarga().toString());
    }    

    public void updateData(){
        Car b = new Car();
        b.setMerek(carPage.getMerekData().getText());
        b.setStatus(carPage.getStatusData().getSelectedItem().toString());
        b.setHarga(Integer.valueOf(carPage.getHargaData().getText()));
        b.setPlatNomor(carPage.getPlatNomorData().getText());
        iCar.update(b);
        JOptionPane.showMessageDialog(null, "Update Data Berhasil");        
    }

    public void deleteData(){
        int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(option == 0){
            String platNomor = carPage.getPlatNomorData().getText();
            iCar.delete(platNomor);
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");    
        }
    }
}