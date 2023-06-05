/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAORentCar;
import Helper.KoneksiDatabase;
import Model.Car;
import Model.RentCar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DAORentCar implements IDAORentCar {

    public DAORentCar(){
        con = KoneksiDatabase.getConnection();
    }
    
    Connection con;    
    //SQL Query (tbl_mobil)
    String strReadCarAvailable = "SELECT * FROM tbl_mobil WHERE status='Available';";
    String strUpdateCarState = "UPDATE tbl_mobil SET status=? WHERE plat_nomor=?;";
    
    //SQL Query (tbl_peminjaman)
    String strReadRentCarData = "SELECT * FROM tbl_peminjaman;";
    String strInsertRentCarData = "INSERT INTO tbl_peminjaman (id_peminjaman, plat_nomor, nama_customer, tgl_peminjaman, tgl_pengembalian, total_harga) VALUES (?,?,?,?,?,?);";
    String strUpdateRentCarData = "UPDATE tbl_peminjaman SET nama_customer=?, plat_nomor=?, tgl_peminjaman=?, tgl_pengembalian=?, total_harga=? WHERE id_peminjaman=?;";
    String strDeleteRentCarData = "DELETE FROM tbl_peminjaman WHERE id_peminjaman=?;";
    
    @Override
    public List<Car> getAllCarAvailable() {
        List<Car> listCar = null;
        try
        {
            listCar = new ArrayList<Car>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strReadCarAvailable);
            
            while(rs.next()){
                Car car = new Car();
                car.setPlatNomor(rs.getString("plat_nomor"));
                car.setMerek(rs.getString("merek"));
                car.setStatus(rs.getString("status"));
                car.setHarga(rs.getInt("harga"));
                listCar.add(car);
            }
        }
        catch(SQLException e){
            System.out.println("error " + e);
        }
        return listCar;        
    }    


    @Override
    public List<RentCar> getAllRentCarData() {
        List<RentCar> listRentCar = null;
        try
        {
            listRentCar = new ArrayList<RentCar>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strReadRentCarData);
            
            while(rs.next()){
                RentCar rentCar = new RentCar();
                rentCar.setIdPeminjaman(rs.getInt("id_peminjaman"));
                rentCar.setPlatNomor(rs.getString("plat_nomor"));
                rentCar.setNamaCustomer(rs.getString("nama_customer"));
                rentCar.setTglPeminjaman(rs.getDate("tgl_peminjaman"));
                rentCar.setTglPengembalian(rs.getDate("tgl_pengembalian"));
                rentCar.setTotalHarga(rs.getInt("total_harga"));
                listRentCar.add(rentCar);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return listRentCar;
    }    
    
    @Override
    public boolean insertRentCar(RentCar b) {
        boolean result = true;
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strInsertRentCarData);
            statement.setInt(1, b.getIdPeminjaman());
            statement.setString(2, b.getPlatNomor());
            statement.setString(3, b.getNamaCustomer());
            statement.setDate(4, new java.sql.Date(b.getTglPeminjaman().getTime()));
            statement.setDate(5, new java.sql.Date(b.getTglPengembalian().getTime()));
            statement.setInt(6, b.getTotalHarga());
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

    @Override
    public void updateStatusMobilBooked(Car b) {
        PreparedStatement statement = null;
            try{
                statement = con.prepareStatement(strUpdateCarState);
                statement.setString(1, "Booked");
                statement.setString(2, b.getPlatNomor());
                statement.execute();
            }
            catch(SQLException e){
                System.out.println(e);        
            }
            finally{
                try{
                    statement.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }        
        }

    @Override
    public void updateStatusMobilAvailable(Car b) {
        PreparedStatement statement = null;
            try{
                statement = con.prepareStatement(strUpdateCarState);
                statement.setString(1, "Available");
                statement.setString(2, b.getPlatNomor());
                statement.execute();
            }
            catch(SQLException e){
                System.out.println(e);        
            }
            finally{
                try{
                    statement.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }        
        }    

    @Override
    public void updateRentCar(RentCar b) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strUpdateRentCarData);
            statement.setString(1, b.getNamaCustomer());
            statement.setString(2, b.getPlatNomor());
            statement.setDate(3, new java.sql.Date(b.getTglPeminjaman().getTime()));
            statement.setDate(4, new java.sql.Date(b.getTglPengembalian().getTime()));
            statement.setInt(5, b.getTotalHarga());
            statement.setInt(6, b.getIdPeminjaman());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println(e);        
        }
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }         
    }

    @Override
    public void deleteRentCar(Integer id_peminjaman) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strDeleteRentCarData);
            statement.setInt(1, id_peminjaman);
            statement.execute();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }        
    }
}
