/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOReturnCar;
import Helper.KoneksiDatabase;
import Model.Car;
import Model.Customer;
import Model.RentCar;
import Model.ReturnCar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class DAOReturnCar implements IDAOReturnCar {

    public List<Customer> getAllCustomerName;
    public DAOReturnCar(){
        con = KoneksiDatabase.getConnection();
    }
    
    Connection con; 
    
    String strReadReturnCarData = "SELECT * FROM tbl_pengembalian;";
    String strInsertReturnCarData = "INSERT INTO tbl_pengembalian (id_Pengembalian, plat_nomor, nama_customer, tgl_pengembalian, delay, denda, total_bayar) VALUES (?,?,?,?,?,?,?);";
    
    @Override
    public List<ReturnCar> getAll() {
        List<ReturnCar> listReturnCar = null;
        try
        {
            listReturnCar = new ArrayList<ReturnCar>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strReadReturnCarData);
            
            while(rs.next()){
                ReturnCar returnCar = new ReturnCar();
                returnCar.setIdPengembalian(rs.getInt("id_pengembalian"));
                returnCar.setPlatNomor(rs.getString("plat_nomor"));
                returnCar.setNamaCustomer(rs.getString("nama_customer"));
                returnCar.setTglPengembalian(rs.getDate("tgl_pengembalian"));
                returnCar.setDelay(rs.getInt("delay"));
                returnCar.setDenda(rs.getInt("denda"));
                returnCar.setTotal_bayar(rs.getInt("total_bayar"));
                listReturnCar.add(returnCar);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return listReturnCar;
    }

    @Override
    public boolean insertReturnCar(ReturnCar b) {
        {
        boolean result = true;
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strInsertReturnCarData);
            statement.setInt(1, b.getIdPengembalian());
            statement.setString(2, b.getPlatNomor());
            statement.setString(3, b.getNamaCustomer());
            statement.setDate(4, new java.sql.Date(b.getTglPengembalian().getTime()));
            statement.setInt(5, b.getDelay());
            statement.setInt(6, b.getDenda());
            statement.setInt(7, b.getTotal_bayar());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println(e);      
            result = false;
        }
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                System.out.println(e);
                result = false;
            }
        }
        return result;          
    }
    }
    
    

}

