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
public class TabelModelCar extends AbstractTableModel{
    List<Car> listCar;
    
    public TabelModelCar(List<Car> listCar){
        this.listCar = listCar;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public int getRowCount(){
        return listCar.size();
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Car Registration Number";
            case 1:
                return "Brand";
            case 2:
                return "Status";
            case 3:
                return "Price (1 Day)";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listCar.get(rowIndex).getPlatNomor();
            case 1:
                return listCar.get(rowIndex).getMerek();
            case 2:
                return listCar.get(rowIndex).getStatus();
            case 3:
                return listCar.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
}

