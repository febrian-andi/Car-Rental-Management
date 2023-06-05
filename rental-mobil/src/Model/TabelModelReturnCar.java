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
public class TabelModelReturnCar extends AbstractTableModel{
    List<ReturnCar> listReturnCar;
    
    public TabelModelReturnCar(List<ReturnCar> listReturnCar){
        this.listReturnCar = listReturnCar;
    }
    
    @Override
    public int getColumnCount(){
        return 7;
    }
    
    @Override
    public int getRowCount(){
        return listReturnCar.size();
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Return ID";
            case 1:
                return "Car Registration Number";
            case 2:
                return "Customer's Name";
            case 3:
                return "Return Date";
            case 4:
                return "Delay";
            case 5:
                return "Fee";
            case 6:
                return "Payment";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listReturnCar.get(rowIndex).getIdPengembalian();
            case 1:
                return listReturnCar.get(rowIndex).getPlatNomor();
            case 2:
                return listReturnCar.get(rowIndex).getNamaCustomer();
            case 3:
                return listReturnCar.get(rowIndex).getTglPengembalian();
            case 4:
                return listReturnCar.get(rowIndex).getDelay();
            case 5:
                return listReturnCar.get(rowIndex).getDenda();   
            case 6:
                return listReturnCar.get(rowIndex).getTotal_bayar();    
            default:
                return null;
        }
    }
}
