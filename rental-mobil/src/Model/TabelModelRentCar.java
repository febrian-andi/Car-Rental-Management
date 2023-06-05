/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TabelModelRentCar extends AbstractTableModel{
    List<RentCar> listRentCar;
    
    public TabelModelRentCar(List<RentCar> listRentCar){
        this.listRentCar = listRentCar;
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public int getRowCount(){
        return listRentCar.size();
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Rent ID";
            case 1:
                return "Car Registration Number";
            case 2:
                return "Customer's Name";
            case 3:
                return "Rent Date";
            case 4:
                return "Return Date";
            case 5:
                return "Fee";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listRentCar.get(rowIndex).getIdPeminjaman();
            case 1:
                return listRentCar.get(rowIndex).getPlatNomor();
            case 2:
                return listRentCar.get(rowIndex).getNamaCustomer();
            case 3:
                return listRentCar.get(rowIndex).getTglPeminjaman();
            case 4:
                return listRentCar.get(rowIndex).getTglPengembalian();
            case 5:
                return listRentCar.get(rowIndex).getTotalHarga();    
            default:
                return null;
        }
    }
}

