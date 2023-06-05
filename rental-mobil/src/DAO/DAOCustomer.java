/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOCustomer;
import Helper.KoneksiDatabase;
import Model.Customer;
import Model.RentCar;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kumil
 */
public class DAOCustomer implements IDAOCustomer {
    public DAOCustomer(){
        con = KoneksiDatabase.getConnection();
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> lstCustomer = null;
        try
        {
            lstCustomer = new ArrayList<Customer>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Customer Customer1 = new Customer();
                Customer1.setId_customer(rs.getInt("id_customer"));
                Customer1.setNama(rs.getString("nama"));
                Customer1.setAlamat(rs.getString("alamat"));
                Customer1.setNo_telpon(rs.getString("no_telepon"));
                lstCustomer.add(Customer1);
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error menampilkan, "+e);
        }
        return lstCustomer;        
    }
    
    @Override
    public boolean insert(Customer customer) {
        PreparedStatement statement = null;
        boolean result = true;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, customer.getId_customer());
            statement.setString(2, customer.getNama());
            statement.setString(3, customer.getAlamat());
            statement.setString(4, customer.getNo_telpon());
            statement.execute();
        }catch(SQLException e)
        {
            System.err.println("Error input, "+ e);
            result = false;
        }finally
        {
            try{
                statement.close();
            } catch(SQLException e){
                System.out.println("gagal input, "+ e);
                result = false;
            }
        }
        return result;
    }
    
    @Override
    public void update(Customer customer) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, customer.getNama());
            statement.setString(2, customer.getAlamat());
            statement.setString(3, customer.getNo_telpon());
            statement.setInt(4, customer.getId_customer());
            statement.execute();
        }catch(SQLException e)
        {
            System.err.println("Error update, "+ e);
        }finally
        {
            try{
                statement.close();
            } catch(SQLException e){
                System.out.println("gagal update, "+ e);
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.execute();
        }catch(SQLException e)
        {
            System.err.println("Error delete "+ e);
        }finally
        {
            try{
                statement.close();
            } catch(SQLException e){
                System.out.println("gagal delete "+ e);
            }
        }
    }

    @Override
    public void updateNamaCustomerRentCar( Customer customer, String namaCustomer) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdateNamaCustomerTabelPeminjaman);
            statement.setString(1, customer.getNama());
            statement.setString(2, namaCustomer);
            statement.execute();
        }catch(SQLException e)
        {
            System.err.println("Error update, "+ e);
        }finally
        {
            try{
                statement.close();
            } catch(SQLException e){
                System.out.println("gagal update, "+ e);
            }
        }       
    }
    
    @Override
    public void updateNamaCustomerReturnCar(Customer customer, String namaCustomer) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdateNamaCustomerTabelPengembalian);
            statement.setString(1, customer.getNama());
            statement.setString(2, namaCustomer);
            statement.execute();
        }catch(SQLException e)
        {
            System.err.println("Error update, "+ e);
        }finally
        {
            try{
                statement.close();
            } catch(SQLException e){
                System.out.println("gagal update, "+ e);
            }
        }
    }
    
    Connection con;
    //SQL Query
    String strRead = "SELECT * FROM tbl_customer;";
    String strInsert = "INSERT INTO tbl_customer(id_customer, nama, alamat, no_telepon) values (?,?,?,?);";
    String strUpdate = "UPDATE tbl_customer SET nama=?, alamat=?, no_telepon=? WHERE id_customer=?;";
    String strDelete = "DELETE FROM tbl_customer WHERE id_customer=?;";
    
    String strUpdateNamaCustomerTabelPeminjaman = "UPDATE tbl_peminjaman SET nama_customer=? WHERE nama_customer=?;";
    String strUpdateNamaCustomerTabelPengembalian = "UPDATE tbl_pengembalian SET nama_customer=? WHERE nama_customer=?;";

}
