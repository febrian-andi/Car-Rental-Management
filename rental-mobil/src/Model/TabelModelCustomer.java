/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kumil
 */
public class TabelModelCustomer extends AbstractTableModel {
List<Customer> lstCustomer;

    public TabelModelCustomer(List<Customer> lstCustomer){
        this.lstCustomer = lstCustomer;

    }
    
    @Override
    public int getRowCount() {
        return this.lstCustomer.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Customer ID";
            case 1:
                return "Customer's Name";
            case 2:
                return "Address";
            case 3:
                return "Phone Number";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lstCustomer.get(rowIndex).getId_customer();
            case 1:
                return lstCustomer.get(rowIndex).getNama();
            case 2:
                return lstCustomer.get(rowIndex).getAlamat();
            case 3:
                return lstCustomer.get(rowIndex).getNo_telpon();
            default:
                return null;
        }
    }
}
